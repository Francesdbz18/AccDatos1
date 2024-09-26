package ejercicios1;
import java.io.*; 
public class EscribirFichObject { 
	public static void main(String[] args) throws IOException, ClassNotFoundException { 
		Persona persona;
		File fichero = new File("FichPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero); 
		ObjectOutputStream dataos = new ObjectOutputStream(fileout); 
		String nombres [] = {"Ana", "Luis Miguel", "Alicia", "Andrés", "Julio", "Manuel", "Antonio", "Pedro", "María Jesús"}; 
		int edades [] = {14,15,13,15,16,12,16,14,13}; 
		for (int i=0;i<edades.length; i++) { 
			persona = new Persona (nombres [i], edades[i]); 
			dataos.writeObject (persona); 
			} 
		dataos.close();
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(filein); 
		try { 
			while (true) {
				persona= (Persona) dataIS.readObject();
				System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad()); 
				} 
			} catch (EOFException eo) { 
				System.out.println("FIN DE LECTURA."); 
			} 
		dataIS.close(); 
	}
}