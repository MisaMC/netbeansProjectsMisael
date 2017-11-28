/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.*;
import org.json.simple.parser.*;
/**
 *
 * @author Usuario
 */
public class ApiRequest {

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
            String jsonData = "";
            JSONParser parser = new JSONParser();
            while((output = br.readLine()) != null){
                //System.out.println(output);
                jsonData += output;
            }
            Object object = parser.parse(jsonData);
            JSONObject jObject = (JSONObject)object;
            Double latitude = (Double)jObject.get("latitude");
            Double longitude = (Double)jObject.get("longitude");
            String timezone = (String)jObject.get("timezone");
            
            JSONObject c = (JSONObject) jObject;
            Object cu = (Object)c.get("currently");
            JSONObject cur= (JSONObject)c.get("currently");
            String Summary = (String) cur.get("summary");
            String Icon = (String)cur.get("icon");
            System.out.println(latitude+" "+longitude+" "+timezone+" "+ Icon+" "+Summary);
            
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"Verificar: "+ ex.getMessage());
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"IOException"+ ex.getMessage());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null,"Error " +ex.getMessage());
        }
        
    }
    
}
