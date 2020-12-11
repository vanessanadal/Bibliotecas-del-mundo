/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import XML.Buscador;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class BibliotecaCImpl extends UnicastRemoteObject implements BibliotecaC{
    
        public BibliotecaCImpl() throws RemoteException { //constructor que llama a constructor de su padre
        super(); //Esto llama al constructor de UnicastRemoteObject
    }

    @Override
    public String helloToC(String name) throws RemoteException{

        System.err.println(name + " is trying to contact!");
        return "Server C says hello to " + name;

    }

     @Override
    public String EncontrarVol(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //Aqui buscara en XML libro con el titulo "name" pasado por parametro
        Buscador b = new Buscador();
        return "(C)" + b.RecorreXMLporTitulo(name, "C");
    }

    @Override
    public String EncontrarAutor(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException {
        //Aqui buscara en XML los libros del autor "name" pasado por parametro
        Buscador b = new Buscador();
        return "(C)" + b.RecorreXMLporAutor(name, "C");
    }
    
}