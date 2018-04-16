import java.io.File;
import java.io.IOException;
//Class designed to make the FIFO and LRU replacement methods
public class FL extends Organiza{
	private String tag; 
	private String[][] FL=new String[Index.length][nway+1];
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
				if(FL[In][j]==null) { 
					this.FL[In][j]=tag; 
					this.FLaux[In][j]=j+1; 
					this.miss++;
					break;
				}
				int com=Integer.parseInt(FL[In][j], 2); 
				int para=Integer.parseInt(tag, 2);
				if(com==para) { 
					if(forma=="LRU") { 
						repaginar(forma,j);
					}
					this.hit++; 
					break;
				}
				else if(FL[In][j]!=null) {
					if(cont==nway-1) {
						pivo=repaginar("Fifo",0); 
						this.FL[In][pivo]=tag; 
						this.miss++;
					}
					cont++;
				}
				
			}
		}
		System.out.println("Miss:"+miss);
		System.out.println("Hits:"+hit);	
	}
}
