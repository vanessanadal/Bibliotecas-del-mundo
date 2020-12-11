/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
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
public class BibliotecaBImpl extends UnicastRemoteObject implements BibliotecaB{
    
        public BibliotecaBImpl() throws RemoteException { //constructor que llama a constructor de su padre
        super(); //Esto llama al constructor de UnicastRemoteObject
    }

    @Override
    public String helloToB(String name) throws RemoteException{

        System.err.println(name + " is trying to contact!");
        return "Server B says hello to " + name;

    }
    
    @Override
    public String BuscarTitulo(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException {
        //Aqui buscara en XML libro con el titulo "name" pasado por parametro
       Buscador b = new Buscador();
        return "(B)" + b.RecorreXMLporTitulo(name, "B");
    }

    @Override
    public String BuscarAutor(String name) throws RemoteException, ParserConfigurationException, SAXException, IOException {
        //Aqui buscara en XML los libros del autor "name" pasado por parametro
        Buscador b = new Buscador();
        return "(B)" + b.RecorreXMLporAutor(name, "B");
    }
}
