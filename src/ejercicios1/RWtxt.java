package ejercicios1;
import java.util.*;
import java.io.*;

public class RWtxt {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\\\Users\\\\aludam2\\\\Documents\\\\sisirve.txt");
		FileWriter fic = new FileWriter (fichero, true);
		String nueva = " Alcorcón";
		fic.write(nueva);
		fic.close();
		Scanner sc = new Scanner(new FileReader("C:\\Users\\aludam2\\Documents\\sisirve.txt")).useDelimiter(" ");
        String str;
        int i = 0;
        String[] array = new String[13];
        while (sc.hasNext()) {
            str = sc.next();
            array[i] = str;
            i++;
        }
        sc.close();
        Arrays.sort(array, Collections.reverseOrder());
		fic = new FileWriter (fichero);
		for(int j=0; j<array.length; j++)
		fic.write(array[j] +  " ");
		fic.close();
	}
}

/* Realizar un programa java que abra para añadir el fichero de ciudades creado anteriormente, y añada al final una nueva ciudad. A continuación, realizar un proceso que lea el fichero resultante, lo guarde en un array, lo vuelva a ordenar descendentemente y lo escriba de nuevo en el fichero, reemplazando el anterior. */