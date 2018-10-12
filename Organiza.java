import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organiza {
	protected int nway; //qual vai ser, direto, 2-way, 4-way,8-way(colunas)
	protected int tamC; //tamanho da cache
	protected int tamB=16; //tamanho do bloco
	protected ArrayList<String> linha = new ArrayList<String>();

	//Os caras da cache
	private String Offset;
	protected String[] Index;
	private String TagS;
	
	//Localização
	protected int x; //Linha q ta atuando
	
	protected int[][] Fifoaux;
	
	Organiza(File a,int b,int c) throws IOException{	// Arquivo, Conjunto e tamanho da cache
		//Atribuindo os valores
		this.nway=b;
		this.tamC=c;
		this.Index=new String[tamC/(tamB*nway)];
		Fifoaux=new int[Index.length][nway];
		//lendo o arquivo
			FileReader leitor= new FileReader(a);
			BufferedReader buffer = new BufferedReader(leitor);
			String texto;
			while((texto = buffer.readLine()) != null){//Salvando o arquivo num arraqy
				this.linha.add(texto);
			}
	}
	
	public int conversor2(int x) { //Converso pra base dois
		int y=1;
		int cont = 0;
		while(y<x) {
			x=x/2;
			cont++;
		}
		return cont;
	}
	
	public String conversorHB(int y) {//Conversor de Hexa para binario
		String x=linha.get(y);
		String verso = "";
		for(int i=0;i<x.length();i++) {
			switch(x.substring(i,i+1)){
				case "0":
					verso+="0000";
					break;
				case "1":
					verso+="0001";
					break;
				case "2":
					verso+="0010";
					break;
				case "3":
					verso+="0011";
					break;
				case "4":
					verso+="0100";
					break;
				case "5":
					verso+="0101";
					break;
				case "6":
					verso+="0110";
					break;
				case "7":
					verso+="0111";
					break;
				case "8":
					verso+="1000";
					break;
				case "9":
					verso+="1001";
					break;
				case "a":
					verso+="1010";
					break;
				case "b":
					verso+="1011";
					break;
				case "c":
					verso+="1100";
					break;
				case "d":
					verso+="1101";
					break;
				case "e":
					verso+="1110";
					break;
				case "f":
					verso+="1111";
					break;
			}
		}
		//variaveis q auxiliam os caras da cache
		int a=conversor2(tamB);
		int b=conversor2(tamC/(tamB*nway));
		int c=32-a-b;
		
		String aux=verso.substring(c,28);
		int conv=Integer.parseInt(aux, 2);
		
		this.x=conv;//Guarda a posição em q a tag está
		//Vai so dividir o resto
		this.Offset=verso.substring(28,32);
		this.Index[conv]=aux;
		this.TagS=verso.substring(0, c);
		return TagS;
	}
	
	public int repaginar(String f,int j) { //Repagina de acordo os metodos
		int menor=0,maior=0, pme=0;
		for(int k=0;k<nway;k++) {
			if(maior<=Fifoaux[x][k]) {
				maior=Fifoaux[x][k];
			}
			if(menor>Fifoaux[x][k]) {
				menor=Fifoaux[x][k];
			}
		}
		if(f=="LRU") {
			for(int k=0;k<nway;k++) {
				if(k>j) {
					Fifoaux[x][k]--;
				}
			}
			Fifoaux[x][j]=maior;
			return 0;
		}
		for(int k=0;k<nway;k++) {
			if(menor==Fifoaux[x][k]) {
				pme=k;
			}
		}
		Fifoaux[x][pme]=maior;
		for(int k=0;k<nway;k++) {
			if(k!=pme) {
				Fifoaux[x][k]--;
			}
		}
		return pme;
	}
}