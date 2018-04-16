import java.io.File;
import java.io.IOException;

public class Direto extends Organiza {
	private String tag;
	private String[][] N=new String[Index.length][nway];
	private int miss;
	private int hit;
	
	Direto(File a, int b, int c) throws IOException {
		super(a, b, c);
		for(int k=0;k<Index.length;k++) {
			for(int j=0;j<nway;j++) {
				N[k][j]="0";
			}
		}
		for(int k=0; k<linha.size();k++) { 
			this.tag=conversorHB(k);
			int com=Integer.parseInt(N[In][0], 2); 
			int para=Integer.parseInt(tag, 2);
			if(com!=para) {
				this.N[In][0]=tag;
				this.miss++;
			}
			else {
				this.hit++; 
			}	
		}
		System.out.println("Miss:"+miss);
		System.out.println("Hits:"+hit);	
	}	
}	
