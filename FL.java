import java.io.File;
import java.io.IOException;

public class FL extends Organiza{
	private String tag; 
	private String[][] FL=new String[Index.length][nway+1];//Matriz das tags
	private int miss;
	private int hit;
	private String forma;//Se vai ser Lru ou Fifo
	int cont=0;//contador para atender a uma condição
	int pivo=0;
	
	FL(File a, int b, int c,String f) throws IOException {
		super(a, b, c);
		this.forma=f;
		for(int k=0; k<linha.size();k++) { //Irá roda ate o tamanho do arq
			this.tag=conversorHB(k);//Tag recebe a da primeira linha do arq
			cont=0; //Para verificar se o conjunto está cheio
			for(int j=0;j<nway;j++) { // Percorre o tam do conjunto
				if(FL[In][j]==null) { // Nas primeiras vezes ele será sempre nullo
					this.FL[In][j]=tag; // Armazena a tag em sua matriz
					this.FLaux[In][j]=j+1; // Salva a sua posição na matriz auxiliar
					this.miss++;
					break;
				}
				int com=Integer.parseInt(FL[In][j], 2); //Converte
				int para=Integer.parseInt(tag, 2);
				if(com==para) { //"Compara"
					if(forma=="LRU") { //Somente se o metodo for Lru
						repaginar(forma,j);//atualiza
					}
					this.hit++; //Se for == hit++
					break;
				}
				else if(FL[In][j]!=null) {
					if(cont==nway-1) { //Significa que o conjunto encheu
						pivo=repaginar("Fifo",0); //Recebe a posição do menor
						this.FL[In][pivo]=tag; // coloca a tag no menor
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