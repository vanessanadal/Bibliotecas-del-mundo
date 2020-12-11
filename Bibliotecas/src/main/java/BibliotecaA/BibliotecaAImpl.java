/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;
import XML.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class BibliotecaAImpl extends UnicastRemoteObject implements BibliotecaA{
    
        public BibliotecaAImpl() throws RemoteException { //constructor que llama a constructor de su padre
        super(); //Esto llama al constructor de UnicastRemoteObject
    }

     @Override
    public String helloToA(String name) throws RemoteException{  //Metodo de prueba

        System.err.println(name + " is trying to contact!");
        return "Server A says hello to " + name;

    }

    @Override
    public String PedirLibro(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException {
        //Aqui buscara en XML libro con el titulo "name" pasado por parametro
        Buscador b = new Buscador();
        return "(A)" + b.RecorreXMLporTitulo(name, "A");
    }

    @Override
    public String PedirAutor(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException  {
        //Aqui buscara en XML los libros del autor "name" pasado por parametro
        Buscador b = new Buscador();
        return "(A)" + b.RecorreXMLporAutor(name, "A");
    }
    
}
