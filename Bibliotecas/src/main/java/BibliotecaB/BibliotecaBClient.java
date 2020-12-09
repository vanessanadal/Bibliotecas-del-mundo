/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import BibliotecaA.BibliotecaA;
import BibliotecaC.BibliotecaC;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class BibliotecaBClient {

    private static BibliotecaB look_upB;
    
    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        String a = "A";
        String c = "C";
        boolean salida = true;

        while(salida){
               
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        
        if(c.equals(bi)){
        String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");

            MiddlewareClientB mB = new MiddlewareClientB();

            if("titulo".equals(opcion)) {
                String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                String libro = mB.BuscarTitulo(titulo, "C");
                JOptionPane.showMessageDialog(null, libro);
              } else { 
                String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                String libro = mB.BuscarAutor(autor, "C");
                JOptionPane.showMessageDialog(null, libro); } 
        } else 
            if (a.equals(bi)) {
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
        
                MiddlewareClientB mB = new MiddlewareClientB();

                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         String libro = mB.BuscarTitulo(titulo, "A");
                         JOptionPane.showMessageDialog(null, libro);
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         String libro = mB.BuscarAutor(autor, "A");
                         JOptionPane.showMessageDialog(null, libro); } 
                
        } else {
            look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto
            
            String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
            if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 String libro = look_upB.BuscarTitulo(titulo); 
                 JOptionPane.showMessageDialog(null, libro);
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 String libro = look_upB.BuscarAutor(autor); 
                 JOptionPane.showMessageDialog(null, libro); } 
            
            }
        
        String res = JOptionPane.showInputDialog("Desea salir? s/n");
        if("n".equals(res)) {
        salida=true;
        } else { salida=false; } 
        
        } 
    }

}
