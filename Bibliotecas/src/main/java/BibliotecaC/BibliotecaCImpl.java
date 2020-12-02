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
    
}