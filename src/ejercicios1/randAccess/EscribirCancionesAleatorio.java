package ejercicios1.randAccess;

import ejercicios1.cancion.Cancion;

import java.io.*;

public class EscribirCancionesAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichCancion.dat");
        File fichero2 = new File("AleatorioCancion.dat");
        RandomAccessFile file = new RandomAccessFile(fichero2, "rw");
        Cancion c;
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        StringBuffer buffer;
        try {
            while (true) {
                c = (Cancion) dataIS.readObject();
                file.writeInt(c.getId());
                file.writeInt(c.getAnyo());
                buffer = new StringBuffer(c.getTitulo());
                buffer.setLength (20);
                file.writeChars (buffer.toString());
                buffer = new StringBuffer(c.getArtista());
                buffer.setLength (20);
                file.writeChars (buffer.toString());
                buffer = new StringBuffer(c.getDuracion());
                buffer.setLength (20);
                file.writeChars (buffer.toString());
                file.writeBoolean(c.isEspanyol());
            }
        } catch (EOFException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        dataIS.close();
    }
}
