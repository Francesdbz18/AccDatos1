package ejercicios1.cancion;

import ejercicios1.MiObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static ejercicios1.cancion.Main.construirCancion;

public class Existente {
    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void buscarArtista() throws IOException {
        File fichero = new File("FichCancion.dat");
        Scanner sc = new Scanner(System.in);
        Cancion cancion;
        System.out.println("Ingrese el nombre del artista");
        String nombre = sc.nextLine();
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        ArrayList<Cancion> encontrado = new ArrayList<Cancion>();
        try {
            while (true) {
                cancion = (Cancion) dataIS.readObject();
                if (cancion.getArtista().equals(nombre)) {
                    encontrado.add(cancion);
                }
            }
        } catch (IOException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        dataIS.close();
        if (encontrado.isEmpty()) {
            System.out.println("No existen canciones con ese artista");
        } else {
            for (Cancion c : encontrado) {
                c.mostrarDatosCancion();
            }
        }
    }

    private static void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int escribir = 1;
        File fichero = new File("FichCancion.dat");
        FileOutputStream fileout = new FileOutputStream(fichero, true);
        MiObjectOutputStream dataos = new MiObjectOutputStream(fileout);
        while (escribir != 0) {
            System.out.println("1. Añadir una nueva canción\n2. Buscar artista\n0. Salir\nElija una opción:");
            escribir = sc.nextInt();
            sc.nextLine();
            if (escribir == 1) {
                dataos.writeObject(construirCancion());
            } else if (escribir == 2) {
                buscarArtista();
           } else if (escribir == 0) {
                System.out.println("Saliendo...");
            }
        }
    }
}
