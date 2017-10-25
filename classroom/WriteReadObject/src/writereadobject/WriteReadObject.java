/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class WriteReadObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Write an object to binary file
        ObjectOutputStream fileOut;
        TestObject obj = new TestObject(1,"test1",2.0);
        String fileName = JOptionPane.showInputDialog(null,"Enter the File's name");
        
     
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(fileName));
            fileOut.writeObject(obj);
            fileOut.close();
            
        } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null,"File not Found "+ ex.getMessage());
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,"File not Found "+ ex.getMessage());
        }//end write
        
        //Reads object from a binary file
        TestObject objIn;
        try {
            ObjectInputStream fileInt = new ObjectInputStream(new FileInputStream(fileName));
            objIn =(TestObject)fileInt.readObject();
            objIn.display();
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"File not Found "+ ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"IOEException"+ ex.getMessage());
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null,"Class not Found "+ ex.getMessage());
        }
    
        
    }
    
}
