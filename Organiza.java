import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organiza {
	protected int nway; //qual vai ser, direto, 2-way, 4-way,8-way(colunas)
	protected int tamC; //tamanho da cache
	protected int tamB=16; //tamanho do bloco
	protected ArrayList<String> linha = new ArrayList<String>();

	//Os caras da cache
	//private String[] Offset; //Eu n "preciso" dele
	protected int[] Index; //Ele vai Determina, apenas o Tamanho das matrizes
	private String TagS;
	
	//Localizaï¿½ï¿½o
	protected int In; //Linha q ta atuando
	
	protected int[][] FLaux;// 
	
	Organiza(File arq,int way,int Tcache) throws IOException{	// Arquivo, Conjunto e tamanho da cache
		//Atribuindo os valores
		this.nway=way;
		this.tamC=Tcache;
		this.Index=new int[tamC/(tamB*nway)];
		FLaux=new int[Index.length][nway];
		//lendo o arquivo
		FileReader leitor= new FileReader(arq);
		BufferedReader buffer = new BufferedReader(leitor);
		String teInto;
		while((teInto = buffer.readLine()) != null){//Salvando o arquivo num arraqy
			this.linha.add(teInto);
		}
	}
	
	public int conversor2(int In) { //Converso pra base dois
		int y=1;
		int cont = 0;
		while(y<In) {
			In=In/2;
			cont++;
		}
		return cont;
	}
	
	public String conversorHB(int y) {//Conversor de HeIna para binario
		String In=linha.get(y);
		String verso = "";
		for(int i=0;i<In.length();i++) {
			switch(In.substring(i,i+1)){
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
		
		//variaveis q auIniliam o cara da cache
		int a=conversor2(tamB); //Offset
		int b=conversor2(tamC/(tamB*nway)); //IndeIn
		int c=32-a-b; //Tag=32-Off-In
		
		//Guarda temporariamente o Index desta Tag
		this.In=Integer.parseInt(verso.substring(c,28), 2);
		
		//Vai so dividir o resto
		//this.Offset[In]=verso.substring(28,32); //Eu n preciso deles
		//this.Index[In]=In;
		return this.TagS=verso.substring(0, c);//Retorna a tag do aqr lido
	}
	
	public int repaginar(String f,int pos) { //forma e posição que ocorreu o hit
		int menor=1,maior=1, pme=0; // variaveis de apoio
		for(int k=0;k<nway;k++) { //Percorre para achar o maior e menor do conjunto em questão
			if(maior<=FLaux[In][k]) 
				maior=FLaux[In][k];
			if(menor>FLaux[In][k]) 
				menor=FLaux[In][k];
		}
		//LRU
		if(f=="LRU") { //Ocorre apenas se o método for Lru
			for(int k=0;k<nway;k++) { //Percorre o conjunto em questão
				if(FLaux[In][k]>FLaux[In][pos]) //Se A posição em questão for								
					FLaux[In][k]--;           //que a posição que ocorreu o hit
			}
			FLaux[In][pos]=maior; //A posição que aconteceu o hit recebe o maior
			return 0;
		}
		//Fifo
		for(int k=0;k<nway;k++) { //Percorre o cojunto para encontrar o seu menor
			if(menor==FLaux[In][k]) 
				pme=k;
		}
		
		for(int k=0;k<nway;k++) { //Diminui todos
			FLaux[In][k]--;
		}
		for(int k=0;k<nway;k++)//Como eu diminui todos é logico
			if(FLaux[In][k]==0) //que terá um com zero
				FLaux[In][k]=maior; // O que estiver zero, recebe o maior
		return pme;
	}
}