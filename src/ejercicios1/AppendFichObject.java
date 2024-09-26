package ejercicios1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppendFichObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona persona;
		File fichero = new File("FichPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero, true); 
		ObjectOutputStream dataos = new ObjectOutputStream(fileout);
		persona = new Persona("Germán", 20);
		dataos.writeObject (persona);
	}
}
