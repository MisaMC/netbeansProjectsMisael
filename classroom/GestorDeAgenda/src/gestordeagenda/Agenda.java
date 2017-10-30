/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Agenda implements Serializable {
   public static final int MAX = 100;
   private ItemAgenda[] elArray;
   private int num;
   
   public Agenda(){
       elArray = new ItemAgenda[MAX];
       num= 0;
   }
   
   public void insertar(ItemAgenda ia){
   elArray[num]= ia;
   num++;
   }
   
   public String toString(){
   String res="";
       for (int i = 0; i < num; i++) {
           res += elArray[i] +"\n";
           res += "*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*"+ "\n";
        }
          return res;
   }
   
   public void guardarAgenda(String fich){
       try {
           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fich)));
           oos.writeObject(this);
           oos.close(); 
       } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"File Not Found"+ ex.getMessage());
       } catch (IOException ex) {
         JOptionPane.showMessageDialog(null,"IOEXEPTION"+ ex.getMessage());
       }
   }
      
       public static Agenda leerAgenda(String fich){
       Agenda aux = null;
       try {
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
           aux =(Agenda) ois.readObject();
           ois.close();
       } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"File Not Found"+ ex.getMessage());
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"IOEXEPTION"+ ex.getMessage());
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Class Not Found "+ ex.getMessage());
       }
       return aux;
       }
       
       /*
       Escribir dos metodos de busqueda de uno por nombre y otro por telefono.
       Ambas operaciones devolveran el primer ItemAgenda que cumpla ,a con la condicion en caso 
       Que exista o null en el caso que no sea asi
       */
}
