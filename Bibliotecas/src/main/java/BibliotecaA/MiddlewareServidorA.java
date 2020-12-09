/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorA {
    
     public MiddlewareServidorA() {
    }
       
    public String getAuthor(BibliotecaA look_upA, String nombre)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        return look_upA.PedirAutor(nombre);
    }
    
    public String getTitle(BibliotecaA look_upA, String nombre)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        return look_upA.PedirLibro(nombre);
    }
    
}
