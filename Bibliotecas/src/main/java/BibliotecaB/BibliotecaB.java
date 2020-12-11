/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public interface BibliotecaB extends Remote{
    
     //Metodos a implementar por el servidor de la Biblioteca B
    
     public String helloToB(String name) throws RemoteException; //Metodo de prueba
    
     public String BuscarTitulo(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException;
     
     public String BuscarAutor(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException;
}
