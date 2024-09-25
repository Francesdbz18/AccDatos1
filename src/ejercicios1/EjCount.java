package ejercicios1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjCount {
	public static void main(String[] args) throws IOException {
        String fileName = "C:\\\\Users\\\\aludam2\\\\Documents\\\\sirve.txt";
        String contenido = leer(fileName);

        int caracteres = contarCaracteres(contenido);
        int palabras = contarPalabras(contenido);

        if (caracteres > 1000 || palabras > 150) {
            System.out.println("El archivo excede el límite: " + caracteres + " caracteres, " + palabras + " palabras.");
        }
    }

    private static String leer(String fileName) throws IOException {
        StringBuilder contenido = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String linea;
        while ((linea = br.readLine()) != null)
                contenido.append(linea).append("\n");
        br.close();
        return contenido.toString();
    }

    private static int contarCaracteres(String contenido) {
        return contenido.length();
    }

    private static int contarPalabras(String contenido) {
        String[] palabras = contenido.split("\\s+");
        return palabras.length;
    }
}
