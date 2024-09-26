package ejercicios1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppendPrimitivos {
	// Realizar un programa que añada al fichero anterior primitivos.dat un dato de tipo Long. Visualizar el fichero para comprobar que se cumple el proceso.
	public static void main(String[] args) throws IOException {
		File f2 = new File("C:\\Users\\aludam2\\Documents\\primitivos.dat");
		
		FileOutputStream fileout = new FileOutputStream(f2, true);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		long l = 20;
		
		dataOS.writeLong(l);

		dataOS.close();
		
		FileInputStream filein = new FileInputStream(f2);
		DataInputStream dataIS = new DataInputStream(filein);
		byte by;
		char c;
		boolean b;
		int v;
		String n;

		try {
			while(dataIS.available()>0) {
				by=dataIS.readByte();
				System.out.println("Esto es un Byte: "+by);
				c=dataIS.readChar();
				System.out.println("Esto es un Caracter: "+c);
				b=dataIS.readBoolean();
				System.out.println("Esto es un Boolean: "+b);
				v=dataIS.readInt();
				System.out.println("Esto es un entero: "+v);
				n=dataIS.readUTF();
				System.out.println("Esto es un String: "+n);
				l = dataIS.readLong();
				System.out.println("Esto es un long: "+l);
			}
			
		}catch(EOFException eo) {
			System.out.println("Error");
		}
	}
}
