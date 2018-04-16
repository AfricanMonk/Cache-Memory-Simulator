import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Organiza {
	protected int nway; //direct, 2-way, 4-way, 8-way (speakers)
	protected int tamC; //cache size
	protected int tamB=16; //block size
	protected ArrayList<String> linha = new ArrayList<String>();

	
	//private String[] Offset; //I do "not" need it
	protected int[] Index; 
	private String TagS;
	
	protected int In; //Line acting
	
	protected int[][] FLaux;//Matrix of positions
	
	Organiza(File arq,int way,int Tcache) throws IOException{// File, Set, and Cache Size
		this.nway=way;
		this.tamC=Tcache;
		this.Index=new int[tamC/(tamB*nway)];
		FLaux=new int[Index.length][nway];
		//lendo o arquivo
		FileReader leitor= new FileReader(arq);
		BufferedReader buffer = new BufferedReader(leitor);
		String teInto;
		while((teInto = buffer.readLine()) != null){//Saving the file in an array
			this.linha.add(teInto);
		}
	}
	
	public int conversor2(int In) { //Convert to base two
		int y=1;
		int cont = 0;
		while(y<In) {
			In=In/2;
			cont++;
		}
		return cont;
	}
	
	public String conversorHB(int y) {//Hexa Converter for Binary
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
		
		
		int a=conversor2(tamB); //Offset
		int b=conversor2(tamC/(tamB*nway)); //Index
		int c=32-a-b; //Tag=32-Off-In
		
		//Temporarily Save This Tag Index
		this.In=Integer.parseInt(verso.substring(c,28), 2);
		//I do not need them
		//this.Offset[In]=verso.substring(28,32);
		//this.Index[In]=In;
		return this.TagS=verso.substring(0, c);//Returns the tag of the read file
	}
	
	public int repaginar(String f,int pos) { //shape and position that hit
		int menor=1,maior=1, pme=0; //higher, lower and position of the minor
		for(int k=0;k<nway;k++) { 
			if(maior<=FLaux[In][k]) 
				maior=FLaux[In][k];
			if(menor>FLaux[In][k]) 
				menor=FLaux[In][k];
		}
		//LRU
		if(f=="LRU") { 
			for(int k=0;k<nway;k++) {
				if(FLaux[In][k]>FLaux[In][pos]) 								
					FLaux[In][k]--;          
			}
			FLaux[In][pos]=maior;
			return 0;
		}
		//Fifo
		for(int k=0;k<nway;k++) { 
			if(menor==FLaux[In][k]) 
				pme=k;
		}
		
		for(int k=0;k<nway;k++) { 
			FLaux[In][k]--;
		}
		for(int k=0;k<nway;k++)
			if(FLaux[In][k]==0) 
				FLaux[In][k]=maior;
		return pme;
	}
}
