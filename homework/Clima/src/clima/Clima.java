/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Clima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        try {
            URL url = new URL("https://api.darksky.net/forecast/5a02fd2308a169845bd02a8313c31f4d/18.45,-97.3833"); 
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept","application/json");
            
            if(conn.getResponseCode() != 200){//Si el resultado es diferente de 200, es un error
            throw new RuntimeException("Failed: HTTP error code: "+ conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));//Obtiene el archivo Json
            
            String output="";
            while((output = br.readLine()) != null){
                System.out.println(output);
            }
            
            
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"Verificar: "+ ex.getMessage());
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"IOException"+ ex.getMessage());
        }
        
    }
    
}
