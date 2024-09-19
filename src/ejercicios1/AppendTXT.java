package ejercicios1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class AppendTXT {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Documents\\sisirve.txt");//declarar fichero
		//crear flujo de salida
		FileWriter fic = new FileWriter (fichero, true);
		String nueva = "Alcorcón";
		fic.write(nueva); // se va escribiendo un carácter
		fic.close();
		//cerrar fichero
	}

}
