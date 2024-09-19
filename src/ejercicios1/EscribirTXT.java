package ejercicios1;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class EscribirTXT {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Documents\\sisirve.txt");//declarar fichero
		//crear flujo de salida
		FileWriter fic = new FileWriter (fichero, true);
		String prov [] = {"Albacete", "Zamora", "Badajoz", "Cáceres", "Huelva", "Jaén", "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Avila"};
		Arrays.sort(prov, Collections.reverseOrder());
		for(int i=0; i<prov.length; i++)
		fic.write(prov[i] +  " "); // se va escribiendo un carácter
		fic.append('*'); //se añade al final un *
		fic.close();
		//cerrar fichero
	}

}

