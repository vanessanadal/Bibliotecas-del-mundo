/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;

import BibliotecaA.BibliotecaA;
import BibliotecaA.MiddlewareServidorA;
import BibliotecaC.BibliotecaC;
import BibliotecaC.MiddlewareServidorC;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yosma
 */
public class MiddlewareClientB {
    
    public MiddlewareClientB() {
    }
    
    public String BuscarTitulo(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        if("A".equals(destino)) {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://10.2.126.70:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente B traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente B traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetTitle " + nombre);
        
        //LLAMADA A MIDDLEWARE SERVIDOR A EN Z39
        return mA.getTitle(look_upA, nombre, "B",logs); }
        
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://10.2.127.252:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente B traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente B traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetTitle " + nombre);
        
        //LLAMADA A MIDDLEWARE SERVIDOR C EN Z39
        return mC.getTitle(look_upC, nombre, "B",logs); 
        }
    }
    
    public String BuscarAutor(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException{
        if("A".equals(destino)) {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://10.2.126.70:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente B traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente B traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetAuthor " + nombre);
        
         //LLAMADA A MIDDLEWARE SERVIDOR A EN Z39
        return mA.getAuthor(look_upA, nombre, "B",logs); }
        
        else {
        BibliotecaC look_upC = (BibliotecaC) Naming.lookup("rmi://10.2.127.252:5097/BibliotecaC"); //ruta donde busca objeto
        MiddlewareServidorC mC = new MiddlewareServidorC();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente B traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente B traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor C: GetAuthor " + nombre);
        
        //LLAMADA A MIDDLEWARE SERVIDOR C EN Z39
        return mC.getAuthor(look_upC, nombre, "B",logs); 
        }
    }
    
}
