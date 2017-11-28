/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class Html {

    private String filename;
    private PrintWriter output;
    private File file;
    private String titulo = null, p1 = null, p2 = null, p3 = null;

 
    public void ReadPersonFile() {
        JFileChooser fileChooser = new JFileChooser(); // Se crea un objeto de tipo JFlieChooser
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            this.file = fileChooser.getSelectedFile(); // Obtenemos todo lo relcionado al archivo no el archivo en si
            try {
                //Create a Scanner for the file
                Scanner input = new Scanner(this.file);//Read text from the file
                titulo = input.nextLine();
                p1 = input.nextLine() + input.nextLine() + input.nextLine()+ input.nextLine()+ input.nextLine();
                p2 = input.nextLine() + input.nextLine() + input.nextLine() + input.nextLine() + input.nextLine();
                p3 = input.nextLine() +input.nextLine() +input.nextLine() +input.nextLine();
                System.out.println(titulo + "\n" + p1+ "\n" + p2 + "\n" + p3);
                input.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null/*se refiere a la posiscion en la que se mostraria el error, se le pone el nombre de la ventana para que aparesca en esa ventana centrado el error*/, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file Selected");
        }
    }

    public void createFile(String name) throws FileNotFoundException {
        this.filename = name;
        this.file = new File(this.filename);
        if (!this.file.exists()) {
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");
        }
    }

    public void WritePerson() throws FileNotFoundException {

        if (this.file.exists()) {
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
            this.output.println(
                    "<html> \n"
                    + "<head> \n"
                    + "<title>" + this.titulo + "</title> \n"
                    + "</head> \n"
                    + "<body> \n"
                    + "<h1>" + this.titulo + "</h1> \n"
                    + "<p>" + this.p1+ "</p> \n"
                    + "<p>" + this.p2 + "</p> \n"
                    + "<p>" + this.p3 + "</p> \n"
                    + "</body> \n"
                    + "</html> \n");
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");
        }
        this.output.close();
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Html t = new Html();
            t.ReadPersonFile();
            
            String nameFile = null;
        nameFile = JOptionPane.showInputDialog(nameFile);
        try {
            t.createFile(nameFile);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " FileNotFoundException " + ex.getMessage());
        }
        try {
            t.WritePerson();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Html.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
