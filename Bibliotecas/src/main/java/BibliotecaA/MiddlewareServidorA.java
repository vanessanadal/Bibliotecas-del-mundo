/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaA;

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
public class MiddlewareServidorA {
    
     public MiddlewareServidorA() {
    }
       
    public String getAuthor(BibliotecaA look_upA, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("B".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Autor " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Autor " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A METODO DESDE OBJETO REMOTO
        return look_upA.PedirAutor(nombre);
    }
    
    public String getTitle(BibliotecaA look_upA, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("B".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Libro " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca B -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Libro " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Middleware Servidor A traduciendo peticion de Z39 a lenguaje de Biblioteca A");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Libro " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor A: Pedir Libro " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A METODO DESDE OBJETO REMOTO
        return look_upA.PedirLibro(nombre);
    }
    
}
