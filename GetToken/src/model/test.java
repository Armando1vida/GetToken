/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 *
 * @author ArmandoPC
 */
public class test {

    public static void main(String[] args) {
//////        CompiladorOld c = new CompiladorOld("22-1203.9");
//////        c.analzarLexico();
//////        c.MostarToken();
//////        c.analizadorSintactico();
//////        String d="^";
//////        System.out.println(d.matches("\\^"));
        String d = "q{";

        Boolean dd = d.equalsIgnoreCase("q{");
//        Boolean dd = d.matches("[+|\\-|*|/]");
        
//
        System.out.println(dd);
////        "[^0-9|^A-Za-zÑñ|^ |\\^]|[\\^]"
//        String to = System.getProperty("user.dir"); // recupero el directorio del proyecto
//        String separator = System.getProperty("file.separator"); //recupero el separador ex: Windows= '\' , Linux='/'
//        to = to + separator + "src" + separator + "src" + separator; // concateno la ruta destino
//        File f = new File(to);
//        if (f.exists()) { // Directorio existe 
//            File[] ficheros = f.listFiles();
//            for (int x = 0; x < ficheros.length; x++) {
//                System.out.println(ficheros[x].getName());
//            }
//        } else { //Directorio no existe 
//            
//        }

    }

}
