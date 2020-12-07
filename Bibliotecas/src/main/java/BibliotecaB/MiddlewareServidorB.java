/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;

import BibliotecaA.BibliotecaA;
import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorB {
    
    public MiddlewareServidorB() {
    }
    
    public String getAuthor(BibliotecaB look_upB, String nombre)throws RemoteException{
        return look_upB.BuscarAutor(nombre);
    }
    
    public String getTitle(BibliotecaB look_upB, String nombre)throws RemoteException{
        return look_upB.BuscarTitulo(nombre);
    }
    
}
