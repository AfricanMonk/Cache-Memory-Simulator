import java.io.File;
import java.io.IOException;

public class MapeamentoN extends Organiza {
	private String tag; //Recebe a Tag
	private String[][] N=new String[Index.length][nway];;//gera a matriz com as tags
	//Acertos e erros
	private int miss;
	private int hit;
	
	MapeamentoN(File a, int b, int c) throws IOException {
		super(a, b, c);
		for(int k=0; k<linha.size();k++) { //Percorre o numero de informações lidas
			this.tag=conversorHB(k);//Pega a primeira Tag
				//Converte para comparar
				int com=Integer.parseInt(N[x][0], 2); 
				int para=Integer.parseInt(tag, 2);
				if(com!=para) {
					this.N[x][0]=tag;//Salva na posição do bloco
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
