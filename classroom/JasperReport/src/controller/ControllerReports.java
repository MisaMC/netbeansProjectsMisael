/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import jasperreport.JasperReport;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.*;
/**
 *
 * @author Usuario
 */
public class ControllerReports {
    public void executeReport(){
        try {
           JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/reports/MyReport1.jasper"));
           JasperPrint jp = JasperFillManager.fillReport(jr, null,new JREmptyDataSource());
           JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void executeReportWithParameters(String title){
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/reports/Myreport1.jasper"));
            Map parameters = new HashMap<String, Object>();
            parameters.put("title", title);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, null);
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
           JOptionPane.showMessageDialog(null,"JRException "+ ex);
        }
    }
    
}
