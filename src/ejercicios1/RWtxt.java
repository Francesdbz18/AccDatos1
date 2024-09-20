package ejercicios1;
import java.util.*;
import java.io.*;

public class RWtxt {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Documents\\sisirve.txt");
		FileWriter fic = new FileWriter (fichero, true);
		String nueva = "Salamanca" + "\n";
		fic.append(nueva);
		fic.close();
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
        ArrayList<String> arrayList = new ArrayList<>();
        String str;
		while((str = br.readLine()) != null){
    		arrayList.add(str);		
    	}
        br.close();
        arrayList.sort(Collections.reverseOrder());
		fic = new FileWriter (fichero);
		for(String str2 : arrayList)
		fic.write(str2 +  "\n");
		fic.close();
	}
}
/* Realizar un programa java que abra para añadir el fichero de ciudades creado anteriormente, y añada al final una nueva ciudad. A continuación, realizar un proceso que lea el fichero resultante, lo guarde en un array, lo vuelva a ordenar descendentemente y lo escriba de nuevo en el fichero, reemplazando el anterior. */