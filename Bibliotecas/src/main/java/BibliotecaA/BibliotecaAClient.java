/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;


public class BibliotecaAClient {

    private static BibliotecaA look_up;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException {
        
        look_up = (BibliotecaA) Naming.lookup("rmi://localhost:5099/test"); //ruta donde busca objeto
        String txt = JOptionPane.showInputDialog("What is your name?");
            
        String response = look_up.helloTo(txt);
        JOptionPane.showMessageDialog(null, response);

    }

}