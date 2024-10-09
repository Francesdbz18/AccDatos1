package xml;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CrearCancionXml {
    public static void main(String args[]) throws IOException {
        File fichero = new File("AleatorioCancion.dat");
        RandomAccessFile file = new RandomAccessFile (fichero, "r");
        int id, anyo, posicion=0;
        char titulo[] = new char [20], artista[] = new char [20], duracion[] = new char [20], aux;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument (null, "Canciones", null);
            document.setXmlVersion("1.0");
            for(;;) {
                file.seek(posicion); //nos posicionamos
                id = file.readInt();
                anyo = file.readInt();
                for (int i = 0; i < titulo.length; i++) {
                    aux = file.readChar();
                    titulo[i] = aux;
                }
                String titulos = new String(titulo);
                for (int i = 0; i < artista.length; i++) {
                    aux = file.readChar();
                    artista[i] = aux;
                }
                String artistas = new String(artista);
                for (int i = 0; i < duracion.length; i++) {
                    aux = file.readChar();
                    duracion[i] = aux;
                }
                String duracion2 = new String(duracion);
                boolean espanyol = file.readBoolean();
                if (id > 0) {
                    Element raiz = document.createElement("cancion");
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("id", Integer.toString(id), raiz, document);
                    CrearElemento("anyo", Integer.toString(anyo), raiz, document);
                    CrearElemento("titulo", titulos.trim(), raiz, document);
                    CrearElemento("artista", artistas.trim(), raiz, document);
                    CrearElemento("duracion", duracion2.trim(), raiz, document);
                    CrearElemento("espanyol", (espanyol)?"si":"no", raiz, document);
                }
                posicion = posicion + 129; // me posiciono para el sig empleado
                if (file.getFilePointer() == file.length()) break;
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Canciones.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }catch(Exception e) {
            System.err.println("Error: "+e);
        }
        file.close();
    }

    static void CrearElemento (String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement (datoEmple);
        Text text = document.createTextNode (valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}
