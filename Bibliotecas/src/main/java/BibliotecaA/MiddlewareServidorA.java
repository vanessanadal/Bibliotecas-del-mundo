/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorA {
    
     public MiddlewareServidorA() {
    }
       
    public String getAuthor(BibliotecaA look_upA, String nombre)throws RemoteException{
        return look_upA.PedirAutor(nombre);
    }
    
    public String getTitle(BibliotecaA look_upA, String nombre)throws RemoteException{
        return look_upA.PedirLibro(nombre);
    }
    
}
