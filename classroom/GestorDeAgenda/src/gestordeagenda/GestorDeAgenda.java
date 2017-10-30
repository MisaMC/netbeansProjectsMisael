/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;

/**
 *
 * @author Usuario
 */
public class GestorDeAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ItemAgenda ia1 = new ItemAgenda("Misael Muñoz Cervantes", "2381555517",75792);
        ItemAgenda ia2 = new ItemAgenda("Mi Compa el Naman", "2381231232",75792);
        ItemAgenda ia3 = new ItemAgenda("Valentin Zamora Rojas", "2383213213",75792);
        
        //Crear una agenda
        Agenda a1 = new Agenda();
        a1.insertar(ia1);
        a1.insertar(ia2);
        a1.insertar(ia3);
        
        //Escribir en el archivo
        a1.guardarAgenda("MyAgend.dat");
        
        //Leer el archivo
        Agenda resAgenda = Agenda.leerAgenda("MyAgend.dat");
        System.out.println(resAgenda);
    }
    
}
