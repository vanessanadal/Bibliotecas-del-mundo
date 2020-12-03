/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import BibliotecaA.BibliotecaA;
import BibliotecaC.BibliotecaC;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;


public class BibliotecaBClient {

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
        
        if(c.equals(bi)){
        look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
        String txt = JOptionPane.showInputDialog("What is your name?");
            
        String response = look_upC.helloToC(txt);
        JOptionPane.showMessageDialog(null, response);
        } else 
            if (a.equals(bi)) {
                look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
                String txt = JOptionPane.showInputDialog("What is your name?");
            
                String response = look_upA.helloToA(txt); //Esto no deberia ser
                JOptionPane.showMessageDialog(null, response);
        } else {
            look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
            String txt = JOptionPane.showInputDialog("What is your name?");
            
            String response = look_upB.helloToB(txt);
            JOptionPane.showMessageDialog(null, response);
            
            String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
            if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 String libro = look_upB.BuscarTitulo(titulo); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro);
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 String libro = look_upB.BuscarAutor(autor); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro); } 
            
            }
        
    }

}
