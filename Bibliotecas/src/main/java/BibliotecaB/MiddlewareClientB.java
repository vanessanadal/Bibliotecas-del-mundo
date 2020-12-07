/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;

import BibliotecaA.BibliotecaA;
import BibliotecaA.MiddlewareServidorA;
import BibliotecaC.BibliotecaC;
import BibliotecaC.MiddlewareServidorC;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Yosma
 */
public class MiddlewareClientB {
    
    public MiddlewareClientB() {
    }
    
    public String BuscarTitulo(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException {
        if("A".equals(destino)) {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        return mA.getTitle(look_upA, nombre); }
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        return mC.getTitle(look_upC, nombre); 
        }
    }
    
    public String BuscarAutor(String nombre, String destino)throws MalformedURLException, RemoteException, NotBoundException{
        if("A".equals(destino)) {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        return mA.getAuthor(look_upA, nombre); }
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        return mC.getAuthor(look_upC, nombre); 
        }
    }
    
}
