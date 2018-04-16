import java.io.File;
import java.io.IOException;

public class teste {
	public static void main(String args[]) throws IOException {
		File arq=new File("Local"); //File Location
		FL a=new FL(arq,8,16384,"LRU"); 
		Direto b = new Direto(arq,1,8192); 
	}										
}
