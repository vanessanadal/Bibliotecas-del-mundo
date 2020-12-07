/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;

import BibliotecaA.BibliotecaA;
import BibliotecaA.MiddlewareServidorA;
import BibliotecaB.BibliotecaB;
import BibliotecaB.MiddlewareServidorB;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public class MiddlewareClientC {
    
    public MiddlewareClientC() {
    }
    
    public String EncontrarVol(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException {
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        return mB.getTitle(look_upB, nombre); }
        else {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        return mA.getTitle(look_upA, nombre);
        }
    }
    
    public String EncontrarAutor(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException{
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        return mB.getAuthor(look_upB, nombre); }
        else {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        return mA.getAuthor(look_upA, nombre);
        }
    }
}
