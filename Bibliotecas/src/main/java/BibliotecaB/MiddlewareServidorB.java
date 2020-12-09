/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;

import BibliotecaA.BibliotecaA;
import java.io.IOException;
import java.io.FileWriter;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorB {
    
    public MiddlewareServidorB() {
    }
    
    public String getAuthor(BibliotecaB look_upB, String nombre)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        return look_upB.BuscarAutor(nombre);
    }
    
    public String getTitle(BibliotecaB look_upB, String nombre)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        return look_upB.BuscarTitulo(nombre);
    }
    
}
