/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.text.SimpleDateFormat;


public class BibliotecaAClient {

    private static BibliotecaA look_upA;

    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        
        //DECLARACION DE VARIABLES PARA LOS CONDICIONALES
        String b = "B";
        String c = "C";
        boolean salida = true;
        
        //CREACION DEL ARCHIVO DE LOGS
        FileWriter logs = new FileWriter("C:\\Users\\Public\\Logs Bibliotecas\\logsA.txt");
        
        
        while(salida) {
            
        String bi = JOptionPane.showInputDialog("En cual biblioteca desea buscar?");
        
        //PETICIONES A BIBLIOTECA B
        if(b.equals(bi)){  //Entra por aqui si se quiere pedir libro a biblioteca B
        String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
        
        MiddlewareClientA mA = new MiddlewareClientA(); //Se instacia objeto de clase Middleware para traducir peticiones a 
        
        if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo);
                 logs.write(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo);
                 
                 //Cliente A llama a medoto PedirLibro de su Middleware para que este lo traduzca a Z39
                 String libro = mA.PedirLibro(titulo, "B");
                 JOptionPane.showMessageDialog(null, libro); 
                 
                  //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 
                 
        } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor);
                 logs.write(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor);
                 
                 String libro = mA.PedirAutor(autor, "B");
                 JOptionPane.showMessageDialog(null, libro); 
        
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
        
        } 
                
        } else 
            //PETICIONES A BIBLIOTECA C
            if (c.equals(bi)) {
                String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");

                MiddlewareClientA mA = new MiddlewareClientA();

                if("titulo".equals(opcion)) {
                         String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            System.out.println(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Libro " + titulo);
                            logs.write(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Libro " + titulo);
                         
                         String libro = mA.PedirLibro(titulo, "C");
                         JOptionPane.showMessageDialog(null, libro);
                         
                         //Imprimiendo traza y escribiendo logs en txt
                            String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                            logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
        
                } else { 
                         String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                         String libro = mA.PedirAutor(autor, "C");
                         JOptionPane.showMessageDialog(null, libro); } 
        } else {
            //PETICIONES LOCALES A BIBLIOTECA A
            look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
            
            String opcion = JOptionPane.showInputDialog("Desea buscar libro por autor o titulo?");
            
                if("titulo".equals(opcion)) {
                 String titulo = JOptionPane.showInputDialog("Coloque el titulo que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo);
                 logs.write(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo);
                 
                 //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA A
                 String libro = look_upA.PedirLibro(titulo); 
                 JOptionPane.showMessageDialog(null, libro);
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 
                } else { 
                 String autor = JOptionPane.showInputDialog("Coloque el autor que desea buscar");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor);
                 logs.write(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor);
                 
                  //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA A
                 String libro = look_upA.PedirAutor(autor); 
                 JOptionPane.showMessageDialog(null, libro); 
                
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
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