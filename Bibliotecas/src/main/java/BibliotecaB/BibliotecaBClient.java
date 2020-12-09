/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;
import BibliotecaA.BibliotecaA;
import BibliotecaC.BibliotecaC;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

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

        
        //CREACION DEL ARCHIVO DE LOGS
        FileWriter logs = new FileWriter("C:\\Users\\Public\\Logs Bibliotecas\\logsB.txt");
        
        while(salida){
               
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        
        //PETICIONES A BIBLIOTECA C
        
        if(c.equals(bi)){
        String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");

            MiddlewareClientB mB = new MiddlewareClientB();
            
            //SI CLIENTE PIDE POR TITULO A BIBLIOTECA C
            if("titulo".equals(opcion)) {
                String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente B hacia Servidor C: Buscar Titulo " + titulo);
                 logs.write("\n" + marca + " -- Peticion de Cliente B hacia Servidor C: Buscar Titulo " + titulo+ " | ");
                
                 //Cliente B llama a medoto BuscarTitulo de su Middleware para que este lo traduzca a Z39
                String libro = mB.BuscarTitulo(titulo, "C", logs);
                JOptionPane.showMessageDialog(null, libro);
                
                //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                 
                 //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA C
              } else { 
                String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                
                 //Imprimiendo traza y escribiendo logs en txt
                String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente B hacia Servidor C: Buscar Autor " + autor);
                 logs.write("\n" + marca + " -- Peticion de Cliente B hacia Servidor C: Buscar Autor " + autor+ " | ");
                
                String libro = mB.BuscarAutor(autor, "C", logs);
                JOptionPane.showMessageDialog(null, libro);
            
                //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
            } 
            
                
        } else 
            
            //PETICIONES A BIBLIOTECA A
            
            if (a.equals(bi)) {
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
                MiddlewareClientB mB = new MiddlewareClientB();
                
                //SI CLIENTE PIDE POR TITULO A BIBLIOTECA A
                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         
                          //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente B hacia Servidor A: Buscar Titulo " + titulo);
                        logs.write("\n" + marca + " -- Peticion de Cliente B hacia Servidor A: Buscar Titulo " + titulo+ " | ");
                         
                        //Cliente B llama a medoto BuscarTitulo de su Middleware para que este lo traduzca a Z39
                         String libro = mB.BuscarTitulo(titulo, "A", logs);
                         JOptionPane.showMessageDialog(null, libro);
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                         
                  //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA A      
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         
                          //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente B hacia Servidor A: Buscar Autor " + autor);
                        logs.write("\n" + marca + " -- Peticion de Cliente B hacia Servidor A: Buscar Autor " + autor+ " | ");
                         
                         String libro = mB.BuscarAutor(autor, "A", logs);
                         JOptionPane.showMessageDialog(null, libro); 
                
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                } 
           //PETICIONES A LOCALES   
        } else {
            look_upB = (BibliotecaB) Naming.lookup("rmi://localhost:5098/BibliotecaB"); //ruta donde busca objeto LOCALMENTE
            
            String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
            if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Libro " + titulo);
                 logs.write(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Libro " + titulo+ " | ");
                 
                  //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA B
                 String libro = look_upB.BuscarTitulo(titulo); 
                 JOptionPane.showMessageDialog(null, libro);
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                 
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Autor " + autor);
                 logs.write(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Autor " + autor+ " | ");
                 
                  //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA B
                 String libro = look_upB.BuscarAutor(autor); 
                 JOptionPane.showMessageDialog(null, libro); 
            
                  //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                 
                 } 
            
            }
        //PREGUNTA SI DESEA SALIR DEL SISTEMA
        String res = JOptionPane.showInputDialog("Desea salir? s/n");
        if("n".equals(res)) {
        salida=true;
        } else { salida=false; } 
        
        } 
        //CIERRA LA ESCRITURA DEL ARCHIVO DE LOGS
        logs.close();
    }

}
