package ejercicios1.cancion;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichCancion.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataos = new ObjectOutputStream(fileout);
        menu(dataos);
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        Cancion c;
        try {
            while (true) {
                c = (Cancion) dataIS.readObject();
                c.mostrarDatosCancion();
            }
        } catch (EOFException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        dataIS.close();
    }

    private static void menu(ObjectOutputStream dataos) throws IOException {
        int escribir = 1;
        Scanner sc = new Scanner(System.in);
        while (escribir != 0) {
            System.out.println("1. Añadir una nueva canción\n0. Salir\nElija una opción:");
            escribir = sc.nextInt();
            sc.nextLine();
            if (escribir == 1) {
                dataos.writeObject(construirCancion());
            }
        }
        dataos.close();

    }

    public static Cancion construirCancion() {
        Cancion c = new Cancion();
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador de la canción: ");
        c.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Introduzca el año de publicación: ");
        c.setAnyo(sc.nextInt());
        sc.nextLine();
        System.out.print("Introduzca el título de la canción: ");
        c.setTitulo(sc.nextLine());
        System.out.print("\nIntroduzca el artista: ");
        c.setArtista(sc.nextLine());
        System.out.print("\nIntroduzca la duración: ");
        c.setDuracion(sc.nextLine());
        System.out.print("¿La canción es española? Pulsa 1 para sí, 0 para no: ");
        c.setEspanyol(sc.nextInt() == 1);
        return c;
    }
}
