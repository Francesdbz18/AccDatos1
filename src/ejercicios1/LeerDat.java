package ejercicios1;
import java.io.*;

public class LeerDat {
	public static void main(String[] args) throws IOException { 
		File fichero = new File("C:\\Users\\aludam2\\documents\\FichBytes.dat");
		FileOutputStream fileout = new FileOutputStream(fichero); 
		FileInputStream filein = new FileInputStream(fichero); 
		int i; 
		for (i=1; i<100; i++) 
			fileout.write(i); 
		fileout.close(); 
		while ((i = filein.read()) != -1) 
			System.out.println(i);
		filein.close(); 
		
	}
}
