import java.io.File;
import java.io.IOException;

public class Direto extends Organiza {
	private String tag; //Recebe a Tag
	private String[][] N=new String[Index.length][nway];
	//Acertos e erros
	private int miss;
	private int hit;
	
	Direto(File a, int b, int c) throws IOException {
		super(a, b, c);
		for(int k=0;k<Index.length;k++) {
			for(int j=0;j<nway;j++) {
				N[k][j]="0";
			}
		}
		for(int k=0; k<linha.size();k++) { //Percorre o numero de informa��es lidas
			this.tag=conversorHB(k);//Pega a primeira Tag
			int com=Integer.parseInt(N[In][0], 2); 
			int para=Integer.parseInt(tag, 2);
			if(com!=para) {
				this.N[In][0]=tag;
				this.miss++;//Se for != miss++	
			}
			else {
				this.hit++; //Se for == hit++
			}	
		}
		System.out.println("Erros:"+miss);
		System.out.println("Acertos:"+hit);	
	}	
}	