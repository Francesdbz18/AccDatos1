package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LecturaEmpleadoXml {
    /*public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Empleados.xml"));
            document.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: is in", document.getDocumentElement().getNodeName());
            NodeList empleados = document.getElementsByTagName("empleado");
            System.out.printf("Nodos empleado a recorrer: d in", empleados.getLength());
            for (int i=0; i< empleados.getLength(); i++) {
                Node emple = empleados.item(i);
                if (emple.getNodeType () == Node. ELEMENT_NODE){
                    Element elemento = (Element) emple;
                    System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
                    System.out.printf("Apellido = %s %n", elemento.getElementsByTagName("dep"). item(0).getTextContent());
                    //System.out.printf("");.getElementsByTagName("apellido"). item(0).getTextContent()); System.out.printf(" Departamento is in", System.out.printf(" Salarios in", elemento.getElementsByTagName("salario item(0).getTextContent()); } } catch (Exception e) (e.printStackTrace();) }//fin de main //fin de la clase

     */}