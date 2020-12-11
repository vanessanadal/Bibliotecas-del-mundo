/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;

import BibliotecaA.BibliotecaA;
import BibliotecaA.MiddlewareServidorA;
import BibliotecaB.BibliotecaB;
import BibliotecaB.MiddlewareServidorB;
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
public class MiddlewareClientC {
    
    public MiddlewareClientC() {
    }
    
    public String EncontrarVol(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException {
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://10.2.126.68:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente C traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente C traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetTitle " + nombre);
            
        //LLAMADA A MIDDLEWARE SERVIDOR B EN Z39
        return mB.getTitle(look_upB, nombre, "C", logs); }
        
        else {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://10.2.126.70:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente C traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente C traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetTitle " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetTitle " + nombre);
            
        //LLAMADA A MIDDLEWARE SERVIDOR A EN Z39
        return mA.getTitle(look_upA, nombre, "C", logs);
        }
    }
    
    public String EncontrarAutor(String nombre, String destino, FileWriter logs)throws MalformedURLException, RemoteException, NotBoundException, ParserConfigurationException, SAXException, IOException{
        if("B".equals(destino)) {
        BibliotecaB look_upB = (BibliotecaB) Naming.lookup("rmi://10.2.126.68:5098/BibliotecaB"); //ruta donde busca objeto
        MiddlewareServidorB mB = new MiddlewareServidorB();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente C traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente C traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor B: GetAuthor " + nombre);
            
        //LLAMADA A MIDDLEWARE SERVIDOR B EN Z39
        return mB.getAuthor(look_upB, nombre, "C", logs); }
        
        else {
        BibliotecaA look_upA = (BibliotecaA) Naming.lookup("rmi://10.2.126.70:5099/BibliotecaA"); //ruta donde busca objeto
        MiddlewareServidorA mA = new MiddlewareServidorA();
        
        //Imprimiendo traza y escribiendo logs en txt
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Middleware Cliente C traduciendo peticion a Z39"+ " | ");
            System.out.println(marca + " -- Middleware Cliente C traduciendo peticion a Z39");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetAuthor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion traducida. LLamando a Middleware de Servidor A: GetAuthor " + nombre);
            
        //LLAMADA A MIDDLEWARE SERVIDOR A EN Z39
        return mA.getAuthor(look_upA, nombre, "C", logs);
        }
    }
}
