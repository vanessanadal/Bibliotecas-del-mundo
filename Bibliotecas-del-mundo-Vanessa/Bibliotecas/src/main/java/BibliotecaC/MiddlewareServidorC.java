/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaC;

import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorC {
    
     public MiddlewareServidorC() {
    }
    
    public String getAuthor(BibliotecaC look_upC, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("A".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Encontrar Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Encontrar Autor " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor C: Encontrar Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor C: Encontrar Autor " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A SERVIDOR C
        return look_upC.EncontrarAutor(nombre);
    }
    
    public String getTitle(BibliotecaC look_upC, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("A".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Encontrar Vol " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Encontrar Vol " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Middleware Servidor C traduciendo peticion de Z39 a lenguaje de Biblioteca C");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor C: Encontrar Vol " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor C: Encontrar Vol " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A SERVIDOR C
        return look_upC.EncontrarVol(nombre);
    }
    
}
