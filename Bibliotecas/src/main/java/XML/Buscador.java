/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class Buscador {
    
        public Buscador() {
    }
    
       public static String RecorreXMLporTitulo (String titulo, String biblioteca) throws ParserConfigurationException, SAXException, IOException{  
          
           File archivo;
           
           if("A".equals(biblioteca)) {
            archivo = new File("BibliotecaAXML.xml"); }
          else if("B".equals(biblioteca)) {
            archivo = new File("BibliotecaBXML.xml");
          } else {
             archivo = new File("BibliotecaCXML.xml");
          }
          
           
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
           
            document.getDocumentElement().normalize();
            NodeList listaLibros = document.getElementsByTagName("LIBRO");
           
            Node nodo;
            for(int i = 0 ; i < listaLibros.getLength() ; i++) {
                nodo = listaLibros.item(i);
                NodeList listaCaracteristicas = nodo.getChildNodes();
                Node caracteristica;
                for(int z=0; z<listaCaracteristicas.getLength(); z++){
                    caracteristica = listaCaracteristicas.item(z);
                if(caracteristica.getNodeName().equals("TITULO") && caracteristica.getTextContent().equals(titulo)){
                    return "Libro: " + titulo;
                }
                }
            }
            return "No se encontro el Libro";
           
    }
    
    public static String RecorreXMLporAutor (String autor, String biblioteca) throws ParserConfigurationException, SAXException, IOException{  
         File archivo;
           
           if("A".equals(biblioteca)) {
            archivo = new File("BibliotecaAXML.xml"); }
          else if("B".equals(biblioteca)) {
            archivo = new File("BibliotecaBXML.xml");
          } else {
             archivo = new File("BibliotecaCXML.xml");
          }
           
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
           
            document.getDocumentElement().normalize();
            NodeList listaLibros = document.getElementsByTagName("LIBRO");
           
            Node nodo;
            for(int i = 0 ; i < listaLibros.getLength() ; i++) {
                nodo = listaLibros.item(i);
                NodeList listaCaracteristicas = nodo.getChildNodes();
                Node caracteristica;
                for(int z=0; z<listaCaracteristicas.getLength(); z++){
                    caracteristica = listaCaracteristicas.item(z);
                if(caracteristica.getNodeName().equals("AUTOR") && caracteristica.getTextContent().equals(autor)){
                    JOptionPane.showMessageDialog(null, "Se encontro el autor " + autor);
                    return "Autor: " + autor;
                }
                }
            }
            return "No se encontro el Autor";
           
    }
    
}
