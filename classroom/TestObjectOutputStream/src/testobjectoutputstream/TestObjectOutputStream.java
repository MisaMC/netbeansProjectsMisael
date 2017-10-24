/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario
 */
public class TestObjectOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            output.writeUTF("Misael");
            output.writeDouble(170);
            output.writeObject(new Date());
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Object.dat"));
            String name = input.readUTF();
            Double height = input.readDouble();
            Date date = (Date)input.readObject();
            System.out.println("name "+ name+" Height "+ height+" Date"+date);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
