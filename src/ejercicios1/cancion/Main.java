package ejercicios1.cancion;

import ejercicios1.Persona;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Cancion c;
        File fichero = new File("FichCancion.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataos = new ObjectOutputStream(fileout);
        menu();
    }

    private static void menu() {
        int escribir = 1;
        Scanner sc = new Scanner(System.in);
        while (escribir != 0) {
            System.out.println("1. Añadir una nueva canción\n0. Salir\nElija una opción:");
            escribir = sc.nextInt();
            sc.nextLine();
            if (escribir == 1) {
                //c = new Cancion(sc.nextInt(), sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextLine(), (sc.nextInt()==1)?true:false);
            }
        }
    }

    public static Cancion construirCancion() {
        Cancion c = new Cancion();
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el identificador de la canción: ");
        c.setId(sc.nextInt());
        return c;
    }
}
