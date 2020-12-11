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
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BibliotecaAClient {

    private static BibliotecaA look_upA;
    static Icon IconoA;
    
    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        
        //DECLARACION DE VARIABLES PARA LOS CONDICIONALES
        IconoA = new ImageIcon("src\\main\\java\\Imagenes\\iconfinder_book_shop-shop-architecture_and_city-buildings-business-books-sale-city_4059950.png");
        String b = "B";
        String c = "C";
        boolean salida = true;
        
        //CREACION DEL ARCHIVO DE LOGS
        FileWriter logs = new FileWriter("C:\\Users\\Public\\Logs Bibliotecas\\logsA.txt");
        
        
        while(salida) {
            
        String[] biblio = {" ", "B", "C"};
        String bi = (String) JOptionPane.showInputDialog(null, "En cual biblioteca desea buscar?", "Biblioteca A", JOptionPane.DEFAULT_OPTION, IconoA, biblio, biblio[0]);
        
        //PETICIONES A BIBLIOTECA B
        if(b.equals(bi)){  //Entra por aqui si se quiere pedir libro a biblioteca B
        String[] autotitu = {"autor", "titulo"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca A", JOptionPane.DEFAULT_OPTION, IconoA, autotitu, autotitu[0]);
        
        MiddlewareClientA mA = new MiddlewareClientA(); //Se instacia objeto de clase Middleware para traducir peticiones a 

            //SI CLIENTE PIDE POR TITULO A BIBLIOTECA B
            if("titulo".equals(opcion)) {
                     String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");

                     //Imprimiendo traza y escribiendo logs en txt
                     String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                     System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo);
                     logs.write("\n" + marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Libro " + titulo+ " | ");

                     //Cliente A llama a medoto PedirLibro de su Middleware para que este lo traduzca a Z39
                     String libro = mA.PedirLibro(titulo, "B", logs);
                     JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA);

                      //Imprimiendo traza y escribiendo logs en txt
                     String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                     System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                     logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");

              //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA B       
            } else { 
                     String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");

                     //Imprimiendo traza y escribiendo logs en txt
                     String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                     System.out.println(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor);
                     logs.write(marca + " -- Peticion de Cliente A hacia Servidor B: Pedir Autor " + autor+ " | ");

                     //Cliente A llama a medoto PedirAutor de su Middleware para que este lo traduzca a Z39
                     String libro = mA.PedirAutor(autor, "B", logs);
                     JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA); 

                     //Imprimiendo traza y escribiendo logs en txt
                     String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                     System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                     logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");

            } 
                
        } else 
            //PETICIONES A BIBLIOTECA C
            if (c.equals(bi)) {
                String[] autotitu = {"autor", "titulo"};
                String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca A", JOptionPane.DEFAULT_OPTION, IconoA, autotitu, autotitu[0]);

                MiddlewareClientA mA = new MiddlewareClientA();
                
                //SI CLIENTE PIDE POR TITULO A BIBLIOTECA C
                if("titulo".equals(opcion)) {
                         String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            System.out.println(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Libro " + titulo);
                            logs.write(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Libro " + titulo+ " | ");
                         
                         String libro = mA.PedirLibro(titulo, "C", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA);
                         
                         //Imprimiendo traza y escribiendo logs en txt
                            String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                            System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                            logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                 
                  //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA C
                } else { 
                          String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Autor " + autor);
                        logs.write(marca + " -- Peticion de Cliente A hacia Servidor C: Pedir Autor " + autor+ " | ");
                         
                         //Cliente A llama a medoto PedirAutor de su Middleware para que este lo traduzca a Z39
                         String libro = mA.PedirAutor(autor, "C", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA); 
                
                        //Imprimiendo traza y escribiendo logs en txt
                         String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                         System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                         logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                } 
                
                
        } else {
            //PETICIONES LOCALES A BIBLIOTECA A
            look_upA = (BibliotecaA) Naming.lookup("rmi://localhost:5099/BibliotecaA"); //ruta donde busca objeto
            
             String[] autotitu = {"autor", "titulo"};
             String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca A", JOptionPane.DEFAULT_OPTION, IconoA, autotitu, autotitu[0]);
                
            //SI CLIENTE PIDE POR TITULO LOCALMENTE
                if("titulo".equals(opcion)) {
                 String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Libro " + titulo);
                 logs.write(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Libro " + titulo+ " | ");
                 
                 //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA A
                 String libro = look_upA.PedirLibro(titulo); 
                 JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA);
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                 
            //SI CLIENTE PIDE POR AUTOR LOCALMENTE
                } else { 
                 String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca A",JOptionPane.INFORMATION_MESSAGE, IconoA,null,"");
                 
                 //Imprimiendo traza y escribiendo logs en txt
                 String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Autor " + autor);
                 logs.write(marca + " -- Peticion local de Cliente A hacia su Servidor: Pedir Autor " + autor+ " | ");
                 
                  //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA A
                 String libro = look_upA.PedirAutor(autor); 
                  JOptionPane.showMessageDialog(null, libro,"Biblioteca A",JOptionPane.INFORMATION_MESSAGE,IconoA);
                
                 //Imprimiendo traza y escribiendo logs en txt
                 String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                 System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                 logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                } 
            }
          
           //PREGUNTA SI DESEA SALIR DEL SISTEMA
           int resp = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "BibliotecaC", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, IconoA); //Pregunta si desea salir de la app
           if(resp == 1) {
           salida=true;
           } else { salida=false; } 
        
        } 
        //CIERRA LA ESCRITURA DEL ARCHIVO DE LOGS
        logs.close();
 
    }

}