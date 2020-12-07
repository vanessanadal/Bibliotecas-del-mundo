/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;

import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorC {
    
     public MiddlewareServidorC() {
    }
    
    public String getAuthor(BibliotecaC look_upC, String nombre)throws RemoteException{
        return look_upC.EncontrarAutor(nombre);
    }
    
    public String getTitle(BibliotecaC look_upC, String nombre)throws RemoteException{
        return look_upC.EncontrarVol(nombre);
    }
    
}
