package ejercicios1.randAccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion;
        double salario;
        char[] apellido = new char[10];
        char aux;
        posicion = 0;
        for(;;){
            file.seek (posicion);
            id = file.readInt();
            for (int i=0; i < apellido.length; i++) {
                aux = file.readChar();
                apellido[i] = aux;
            }
            String apellidos= new String (apellido);
            dep = file.readInt();
            salario = file.readDouble();
            if (id > 0) System.out.printf("ID: %s, Apellido: %s, Departamento: %d. Salario: %.2f \n", id, apellidos.trim(), dep, salario);
            posicion = posicion + 36;
            if (file.getFilePointer() == file.length()) break;
        }
        consultar(file);
        anyadir(file);
        file.close();
    }

    private static void consultar(RandomAccessFile file) throws IOException {
        Scanner sc = new Scanner(System.in);
        int identificador = sc.nextInt();
        int posicion = (identificador - 1) * 36;
        char[] apellido = new char[10];
        if (posicion >= file.length()) System.out.printf("ID: %d, NO EXISTE EMPLEADO. ", identificador);
        else {
            file.seek (posicion);
            int id = file.readInt();
            double salario = file.readDouble();
            int dep = file.readInt();
            String apellidos = new String (apellido);
            System.out.printf("ID: %s, Apellido: %s, Departamento: %d. Salario: %.2f \n", id, apellidos.trim(), dep, salario);
        }
    }

    private static void anyadir(RandomAccessFile file) throws IOException {
        long posicion = file.length();
        file.seek (posicion);
        StringBuffer buffer;
        String apellido = "GONZALEZ";
        double salario = 1230.87;
        int id = 20;
        int dep = 10;
        /* long posicion = (id-1) *36; si se sabe el identificador*/
        file.seek(posicion);
        file.writeInt(id);
        buffer = new StringBuffer(apellido);
        buffer.setLength(10);
        file.writeChars(buffer.toString());
        file.writeInt(dep);
        file.writeDouble (salario);
        file.close();
    }
}



