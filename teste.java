import java.io.File;
import java.io.IOException;

public class teste {
	public static void main(String args[]) throws IOException {
		File arq=new File("Local"); // Local do arquivo
		FL p=new FL(arq,8,16384,"LRU"); //Instacia um obejto para executar Fifo ou Lru
		Direto b = new Direto(arq,1,8192); //Instacia um objeto para executar o 
	}										//Mapeamento Direto
}