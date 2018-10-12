import java.io.File;
import java.io.IOException;

public class teste {
	public static void main(String args[]) throws IOException {
		File arq=new File("Diretorio");
		FL p=new FL(arq,2,8192,"LRU");
	}
}