/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import BibliotecaA.BibliotecaA;
import BibliotecaB.BibliotecaB;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;


public class BibliotecaCClient {

    private static BibliotecaB look_upB;
    private static BibliotecaA look_upA;
    private static BibliotecaC look_upC;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException {
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        String x = String.valueOf(bi);
        String a = "A";
        String b = "B";
        String c = "C";
        
        if(b.equals(bi)){
        look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
        String txt = JOptionPane.showInputDialog("What is your name?");
            
        String response = look_upB.helloToB(txt);
        JOptionPane.showMessageDialog(null, response);
        } else 
            if (a.equals(bi)) {
                look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
                String txt = JOptionPane.showInputDialog("What is your name?");
            
                String response = look_upA.helloToA(txt); //Esto no deberia ser
                JOptionPane.showMessageDialog(null, response);
        } else {
            
                look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
                String txt = JOptionPane.showInputDialog("What is your name?");
            
                String response = look_upC.helloToC(txt); //Esto no deberia ser
                JOptionPane.showMessageDialog(null, response);
                
            }
        
    }

}