import java.io.File;
import java.io.IOException;

public class FL extends Organiza{ // Classe para FIFO e LRU
	private String tag;
	private String[][] FL=new String[Index.length][nway];
	private int miss;
	private int hit;
	private String forma;
	int cont=0;
	int pivo=0;
	
	FL(File a, int b, int c,String f) throws IOException {
		super(a, b, c);
		this.forma=f;
		for(int k=0; k<linha.size();k++) {
			this.tag=conversorHB(k);
			cont=0;
			for(int j=0;j<nway;j++) {
				if(FL[x][j]==null) {
					this.FL[x][j]=tag;
					this.Fifoaux[x][j]=j;
					this.miss++;
					break;
				}
				int com=Integer.parseInt(FL[x][j], 2); 
				int para=Integer.parseInt(tag, 2);
				if(com==para) { //Se for igual
					if(forma=="LRU") {
						repaginar(forma,j);
					}
					this.hit++; //Se for == hit++
					break;
				}
				else if(FL[x][j]!=null) {
					if(cont==nway-1) {
						pivo=repaginar("Fifo",0);
						this.FL[x][pivo]=tag;
						this.miss++;
					}
					cont++;
				}
			}
		}
		System.out.println("Erros:"+miss);
		System.out.println("Acertos:"+hit);	
	}
}