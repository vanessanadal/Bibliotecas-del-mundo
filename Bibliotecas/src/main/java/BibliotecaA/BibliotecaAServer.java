/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 *
 * @author Yosma
 */
public class BibliotecaAServer {

    public static void main(String[] args){

        try {
            Registry registry = LocateRegistry.createRegistry(5099);
            registry.rebind("test", new BibliotecaAImpl());    //ruta donde sube objeto        

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}