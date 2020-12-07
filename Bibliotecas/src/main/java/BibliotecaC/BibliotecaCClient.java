/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;


public class BibliotecaCClient {

    private static BibliotecaC look_upC;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException {
        String a = "A";
        String b = "B";
        boolean salida = true;
        
        while(salida) {
        
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        
        if(b.equals(bi)){
        String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
        
                MiddlewareClientC mC = new MiddlewareClientC();

                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         String libro = mC.EncontrarVol(titulo, "B");
                         JOptionPane.showMessageDialog(null, libro);
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         String libro = mC.EncontrarAutor(autor, "B");
                         JOptionPane.showMessageDialog(null, libro); } 
        } else 
            if (a.equals(bi)) {
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
        
                MiddlewareClientC mC = new MiddlewareClientC();

                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         String libro = mC.EncontrarVol(titulo, "A");
                         JOptionPane.showMessageDialog(null, libro);
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         String libro = mC.EncontrarAutor(autor, "A");
                         JOptionPane.showMessageDialog(null, libro); } 
                
        } else {
            
                look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
                
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
            if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 String libro = look_upC.EncontrarVol(titulo); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro);
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 String libro = look_upC.EncontrarAutor(autor); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro); } 
            
            }
        
           String res = JOptionPane.showInputDialog("Desea salir? s/n"); //Pregunta si desea salir de la app
           if("n".equals(res)) {
           salida=true;
           } else { salida=false; } 
        
        }
      }
    }

