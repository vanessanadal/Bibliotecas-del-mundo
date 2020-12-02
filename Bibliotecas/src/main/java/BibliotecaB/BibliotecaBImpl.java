/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    
}
