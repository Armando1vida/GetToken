/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArmandoPC
 */
public class Serialize {

    public Serialize() {
    }

    public void writeXml(DataCompiler p, String namefile) {
        String to = System.getProperty("user.dir"); // recupero el directorio del proyecto
        String separator = System.getProperty("file.separator"); //recupero el separador ex: Windows= '\' , Linux='/'
        to = to + separator + "src" + separator + "src" + separator + namefile + ".xml"; // concateno la ruta destino
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(to)));
            encoder.writeObject(p);
            encoder.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serialize.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//

    public DataCompiler ReadXml(String filename) {
        DataCompiler archivo = null;
        String to = System.getProperty("user.dir"); // recupero el directorio del proyecto
        String separator = System.getProperty("file.separator"); //recupero el separador ex: Windows= '\' , Linux='/'
        to = to + separator + "src" + separator + "src" + separator + filename + ".xml"; // concateno la ruta destino
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(to)));
            archivo = (DataCompiler) decoder.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        return archivo;
    }
}
