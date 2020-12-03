/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    public String EncontrarVol(String name) throws RemoteException {
        //Aqui buscara en XML libro con el titulo "name" pasado por parametro
        return "El libro es: " +  name + " por J.K Rowling";
    }

    @Override
    public String EncontrarAutor(String name) throws RemoteException {
        //Aqui buscara en XML los libros del autor "name" pasado por parametro
        return "Los libros del autor " + name + "encontrados son: " +  "Matematica III, Calculo Avanzado II y Fundamentos del calculo diferencial";
    }
    
}