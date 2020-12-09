/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;
import BibliotecaC.BibliotecaC;
import BibliotecaB.BibliotecaB;
import BibliotecaB.MiddlewareServidorB;
import BibliotecaC.MiddlewareServidorC;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author Yosma
 */
public class MiddlewareClientA {
    
    public MiddlewareClientA() {
    }
 
    public String PedirLibro(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + nombre);
        return mB.getTitle(look_upB, nombre); }
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Libro " + nombre);
        return mC.getTitle(look_upC, nombre); 
        }
    }
    
    public String PedirAutor(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException , ParserConfigurationException, SAXException, IOException{
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        return mB.getAuthor(look_upB, nombre); }
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        return mC.getAuthor(look_upC, nombre); 
        }
    }
    
}
