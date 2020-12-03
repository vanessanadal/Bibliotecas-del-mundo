/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Yosma
 */
public class BibliotecaAImpl extends UnicastRemoteObject implements BibliotecaA{
    
        public BibliotecaAImpl() throws RemoteException { //constructor que llama a constructor de su padre
        super(); //Esto llama al constructor de UnicastRemoteObject
    }

     @Override
    public String helloToA(String name) throws RemoteException{

        System.err.println(name + " is trying to contact!");
        return "Server A says hello to " + name;

    }

    @Override
    public String PedirLibro(String name) throws RemoteException {
        //Aqui buscara en XML libro con el titulo "name" pasado por parametro
        return "El libro es: " +  name + " por J.K Rowling";
    }

    @Override
    public String PedirAutor(String name) throws RemoteException {
        //Aqui buscara en XML los libros del autor "name" pasado por parametro
        return "Los libros del autor " + name + "encontrados son: " +  "Matematica III, Calculo Avanzado II y Fundamentos del calculo diferencial";
    }
    
}
