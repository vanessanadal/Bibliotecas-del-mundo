/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class BibliotecaCClient {

    private static BibliotecaC look_upC;
    static Icon IconoC;
    public static void main(String[] args) 
        throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        
        //DECLARACION DE VARIABLES PARA LOS CONDICIONALES
        String a = "A";
        String b = "B";
        boolean salida = true;
        IconoC = new ImageIcon("src\\main\\java\\Imagenes\\iconfinder_bookshelf_3512850.png");
        
        //CREACION DEL ARCHIVO DE LOGS
        FileWriter logs = new FileWriter("C:\\Users\\Public\\Logs Bibliotecas\\logsC.txt");
        
        while(salida) {
        
        String[] biblio = {" ", "A", "B"};
        String bi = (String) JOptionPane.showInputDialog(null, "En cual biblioteca desea buscar?", "Biblioteca C", JOptionPane.DEFAULT_OPTION, IconoC, biblio, biblio[0]);
        
        //PETICIONES A BIBLIOTECA B
        if(b.equals(bi)){
        String[] autotitu = {"autor", "titulo"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca C", JOptionPane.DEFAULT_OPTION, IconoC, autotitu, autotitu[0]);
        
                MiddlewareClientC mC = new MiddlewareClientC();

                //SI CLIENTE PIDE POR TITULO A BIBLIOTECA B
                if("titulo".equals(opcion)) {
                          String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente C hacia Servidor B: Encontrar Vol " + titulo);
                        logs.write("\n" + marca + " -- Peticion de Cliente C hacia Servidor B: Encontrar Vol " + titulo+ " | ");
                         
                        //Cliente C llama a medoto EncontrarVol de su Middleware para que este lo traduzca a Z39
                         String libro = mC.EncontrarVol(titulo, "B", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC);
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                         
  
                 //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA B        
                } else { 
                         String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente C hacia Servidor B: Encontrar Autor " + autor);
                        logs.write("\n" + marca + " -- Peticion de Cliente C hacia Servidor B: Encontrar Autor " + autor+ " | ");
                         
                        //Cliente C llama a medoto EncontrarAutor de su Middleware para que este lo traduzca a Z39
                         String libro = mC.EncontrarAutor(autor, "B", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC);
                
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                } 
                
                      
        } else  
            //PETICIONES A BIBLIOTECA A  
            if (a.equals(bi)) {
                String[] autotitu = {"autor", "titulo"};
                String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca C", JOptionPane.DEFAULT_OPTION, IconoC, autotitu, autotitu[0]);
        
                MiddlewareClientC mC = new MiddlewareClientC();
                
                //SI CLIENTE PIDE POR TITULO A BIBLIOTECA A
                if("titulo".equals(opcion)) {
                         String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente C hacia Servidor A: Encontrar Vol " + titulo);
                        logs.write("\n" + marca + " -- Peticion de Cliente C hacia Servidor A: Encontrar Vol " + titulo+ " | ");
                         
                        //Cliente C llama a medoto EncontrarVol de su Middleware para que este lo traduzca a Z39
                         String libro = mC.EncontrarVol(titulo, "A", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC);
                         
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                         
                //SI CLIENTE PIDE POR AUTOR A BIBLIOTECA A
                } else { 
                         String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                         
                        //Imprimiendo traza y escribiendo logs en txt
                        String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marca + " -- Peticion de Cliente C hacia Servidor A: Encontrar Autor " + autor);
                        logs.write("\n" + marca + " -- Peticion de Cliente C hacia Servidor A: Encontrar Autor " + autor+ " | ");
                         
                        //Cliente C llama a medoto EncontrarAutor de su Middleware para que este lo traduzca a Z39
                         String libro = mC.EncontrarAutor(autor, "A", logs);
                         JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC); 
                
                         //Imprimiendo traza y escribiendo logs en txt
                        String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                        System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                        logs.write("\n" +marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                } 
                    
        } else {
                //PETICIONES LOCALES A BIBLIOTECA C
                
                look_upC = (BibliotecaC) Naming.lookup("rmi://localhost:5097/BibliotecaC"); //ruta donde busca objeto
                
                String[] autotitu = {"autor", "titulo"};
                String opcion = (String) JOptionPane.showInputDialog(null, "Desea buscar libro por autor o titulo?", "Biblioteca C", JOptionPane.DEFAULT_OPTION, IconoC, autotitu, autotitu[0]);
            
                //SI CLIENTE PIDE POR TITULO LOCALMENTE
                     if("titulo".equals(opcion)) {
                      String titulo = (String) JOptionPane.showInputDialog(null,"Coloque el titulo que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                     
                    //Imprimiendo traza y escribiendo logs en txt
                    String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    System.out.println(marca + " -- Peticion local de Cliente C hacia su Servidor: Encontrar Vol " + titulo);
                    logs.write(marca + " -- Peticion local de Cliente C hacia su Servidor: Encontrar Vol " + titulo+ " | ");

                    //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA C
                     String libro = look_upC.EncontrarVol(titulo); //Esto no deberia ser
                     JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC);
                     
                    //Imprimiendo traza y escribiendo logs en txt
                    String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                    logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                     
              //SI CLIENTE PIDE POR AUTOR LOCALMENTE
                    } else { 
                     String autor = (String) JOptionPane.showInputDialog(null,"Coloque el autor que desea buscar","Biblioteca C",JOptionPane.INFORMATION_MESSAGE, IconoC,null,"");
                     
                    //Imprimiendo traza y escribiendo logs en txt
                    String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    System.out.println(marca + " -- Peticion local de Cliente C hacia su Servidor: Encontrar Autor " + autor);
                    logs.write(marca + " -- Peticion local de Cliente C hacia su Servidor: Encontrar Autor " + autor+ " | ");
                     
                    //LLAMA LOCALMENTE AL SERVIDOR DE LA BIBLIOTECA C
                     String libro = look_upC.EncontrarAutor(autor); //Esto no deberia ser
                     JOptionPane.showMessageDialog(null, libro,"Biblioteca C",JOptionPane.INFORMATION_MESSAGE,IconoC);
                     
                    //Imprimiendo traza y escribiendo logs en txt
                    String marcaFin = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                    System.out.println(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro);
                    logs.write(marcaFin + " -- Peticion recibida correctamente -- Respuesta:  " + libro+ " | ");
                     
                     } 
            }
        
           int resp = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "Biblioteca C", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, IconoC); //Pregunta si desea salir de la app
           if(resp == 1) {
           salida=true;
           } else { salida=false; } 
        
        }
        //CIERRA LA ESCRITURA DEL ARCHIVO DE LOGS
        logs.close();
      }
    }

