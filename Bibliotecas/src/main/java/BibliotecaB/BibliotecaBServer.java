/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 *
 * @author Yosma
 */
public class BibliotecaBServer {

    public static void main(String[] args){

        try {
            Registry registry = LocateRegistry.createRegistry(5098); //Puerto por donde escuchara el servidor B
            registry.rebind("BibliotecaB", new BibliotecaBImpl());    //ruta donde sube objeto remoto e instancia del mismo       

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}
