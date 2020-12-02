/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public interface BibliotecaC extends Remote{
    
     public String helloToC(String name) throws RemoteException;
    
}
