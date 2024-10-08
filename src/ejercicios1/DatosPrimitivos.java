package ejercicios1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosPrimitivos {
	public static void main(String[] args) throws IOException {
		File f2 = new File("C:\\Users\\aludam2\\Documents\\primitivos.dat");
		f2.createNewFile();
		
		FileOutputStream fileout = new FileOutputStream(f2);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		
		int v = 1;
		char c = 5;
		Boolean b = true;
		String n = "hola";
		byte by = 0;
		//long l = 20;
		
		dataOS.writeByte(by);
		dataOS.writeChar(c);
		dataOS.writeBoolean(b);
		dataOS.writeInt(v);
		dataOS.writeUTF(n);	
		//dataOS.writeLong(l);
		

		dataOS.close();
		
		
		FileInputStream filein = new FileInputStream(f2);
		DataInputStream dataIS = new DataInputStream(filein);

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
			}
			
		}catch(EOFException eo) {
			System.out.println("Error");
		}
	}
}
