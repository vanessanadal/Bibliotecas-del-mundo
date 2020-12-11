/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;
import BibliotecaC.BibliotecaC;
import BibliotecaB.BibliotecaB;
import BibliotecaB.MiddlewareServidorB;
import BibliotecaC.MiddlewareServidorC;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 *
 * @author Yosma
 */
public class MiddlewareClientA {
    
    public MiddlewareClientA() {
    }
 
    public String PedirLibro(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        if("B".equals(destino)) {
            BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://10.2.126.68:5098/BibliotecaB"); //ruta donde busca objeto
            MiddlewareServidorB mB = new MiddlewareServidorB();
            
            //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente A traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente A traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetTitle " + nombre);
            
            //LLAMADA A MIDDLEWARE SERVIDOR B EN Z39
            return mB.getTitle(look_upB, nombre, "A",logs); }
        else {
            BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://10.2.127.252:5097/BibliotecaC"); //ruta donde busca objeto
            MiddlewareServidorC mC = new MiddlewareServidorC();
            
            //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente A traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente A traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetTitle " + nombre);
            
            //LLAMADA A MIDDLEWARE SERVIDOR C EN Z39
            return mC.getTitle(look_upC, nombre, "A",logs); 
        }
    }
    
    public String PedirAutor(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException , ParserConfigurationException, SAXException, IOException{
        if("B".equals(destino)) {
            BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://10.2.126.68:5098/BibliotecaB"); //ruta donde busca objeto
            MiddlewareServidorB mB = new MiddlewareServidorB();
            
            //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente A traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente A traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetAuthor " + nombre);
            
            //LLAMADA A MIDDLEWARE SERVIDOR B EN Z39
            return mB.getAuthor(look_upB, nombre, "A",logs); }
        else {
            BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://10.2.127.252:5097/BibliotecaC"); //ruta donde busca objeto
            MiddlewareServidorC mC = new MiddlewareServidorC();
            
            //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente A traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente A traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetAuthor " + nombre);
            
            //LLAMADA A MIDDLEWARE SERVIDOR C EN Z39
            return mC.getAuthor(look_upC, nombre, "A",logs); 
        }
    }
    
}
