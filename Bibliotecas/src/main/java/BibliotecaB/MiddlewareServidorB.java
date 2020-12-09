/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaB;

import BibliotecaA.BibliotecaA;
import java.io.IOException;
import java.io.FileWriter;
import java.rmi.RemoteException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

/**
 *
 * @author Yosma
 */
public class MiddlewareServidorB {
    
    public MiddlewareServidorB() {
    }
    
    public String getAuthor(BibliotecaB look_upB, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("A".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Autor " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Autor " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Autor " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A SERVIDOR B
        return look_upB.BuscarAutor(nombre);
    }
    
    public String getTitle(BibliotecaB look_upB, String nombre, String origen, FileWriter logs)throws RemoteException, ParserConfigurationException, SAXException, IOException{
        //ESCRIBIENDO LOGS
        if("A".equals(origen)) {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Titulo " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca A -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Titulo " + nombre);
        }
        else {
            String marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B"+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Middleware Servidor B traduciendo peticion de Z39 a lenguaje de Biblioteca B");
            marca = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            logs.write(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Titulo " + nombre+ " | ");
            System.out.println(marca + " -- Peticion de Biblioteca C -- Peticion traducida. Ejecutando metodo de Servidor B: Buscar Titulo " + nombre);
        }
        //FIN ESCRITURA
        
        //LLAMADA A SERVIDOR B
        return look_upB.BuscarTitulo(nombre);
    }
    
}
