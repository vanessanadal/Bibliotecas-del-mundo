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

    private static BibliotecaA look_upA;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException {
        
        String b = "B";
        String c = "C";
        boolean salida = true;
        
        while(salida) {
        
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        
        if(b.equals(bi)){
        String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
        
        MiddlewareClientA mA = new MiddlewareClientA();
        
        if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 String libro = mA.PedirLibro(titulo, "B");
                 JOptionPane.showMessageDialog(null, libro);
        } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 String libro = mA.PedirAutor(autor, "B");
                 JOptionPane.showMessageDialog(null, libro); } 
                
        } else 
            if (c.equals(bi)) {
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");

                MiddlewareClientA mA = new MiddlewareClientA();

                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         String libro = mA.PedirLibro(titulo, "C");
                         JOptionPane.showMessageDialog(null, libro);
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         String libro = mA.PedirAutor(autor, "C");
                         JOptionPane.showMessageDialog(null, libro); } 
        } else {
            
            look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
            
            String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
                if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 String libro = look_upA.PedirLibro(titulo); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro);
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 String libro = look_upA.PedirAutor(autor); //Esto no deberia ser
                 JOptionPane.showMessageDialog(null, libro); } 
            }
          
           String res = JOptionPane.showInputDialog("Desea salir? s/n");
           if("n".equals(res)) {
           salida=true;
           } else { salida=false; } 
        
        } 
 
    }

}