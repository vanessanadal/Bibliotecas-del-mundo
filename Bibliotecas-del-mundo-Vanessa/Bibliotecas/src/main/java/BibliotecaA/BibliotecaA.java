/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 *
 * @author Yosma
 */
public interface BibliotecaA extends Remote{
    
     public String helloToA(String name) throws RemoteException;
     
     public String PedirLibro(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException;
     
     public String PedirAutor(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException;
    
}
