package ejercicios1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerReales {
	public static void main(String[] args) throws IOException { 
		File fichero = new File("C:\\Users\\aludam2\\documents\\FichBytesReales.dat");
		FileOutputStream fileout = new FileOutputStream(fichero); 
		DataOutputStream dataOS = new DataOutputStream(fileout); 
		String nombres[] = {"Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andrés", "Julio", "Antonio", "María Jesús"};
		int edades [] = {14,15,13,15,16,12,16,14,13}; 
		double alturas [] = {1.4,1.5,1.3,1.5,1.6,1.2,1.6,1.4,1.3}; 
		boolean asiste[] = {true, false, false, true, true, true, false, false, false};
		for (int i=0;i<edades.length; i++) {
			dataOS.writeUTF (nombres[i]);
			dataOS.writeInt(edades[i]); 
			dataOS.writeDouble(alturas[i]); 
			dataOS.writeBoolean(asiste[i]);
		}
		dataOS.close();
		FileInputStream filein = new FileInputStream(fichero); 
		DataInputStream dataIS = new DataInputStream (filein); 
		String n; 
		int e; 
		double a;
		boolean b;
		ArrayList<Integer> asisten = new ArrayList <Integer>();
		try {
			while (true) { 
				n = dataIS.readUTF(); //recupera el nombre 
				e = dataIS.readInt(); //recupera la edad 
				a = dataIS.readDouble();
				b = dataIS.readBoolean();
				System.out.println("Nombre: "+n+", edad: " + e + ", altura: "+a + ", asiste?: "+b ); 
			} 
		} catch (EOFException eo) {} 
			dataIS.close();
		}
		
	}
