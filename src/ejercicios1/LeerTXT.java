package ejercicios1;
import java.io.*;
public class LeerTXT {
	public static void main(String[] args) throws IOException {
		//declarar fichero
		File fichero = new File("C:\\Users\\aludam2\\Documents\\nosirve.txt");
		//crear el flujo de entrada hacia el fichero 
		FileReader fic = new FileReader (fichero);
		int i; 
		char b[] = new char[20];
		while ((i = fic.read(b)) != -1) //se va leyendo un carácter
		System.out.println((char) i); 
		fic.close(); //cerrar fichero
	}
}
