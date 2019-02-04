/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Auron
 */
public class ReportGenerator {
    
    Connection con;
    JasperReport jReport;
    JasperPrint jasperPrint;
    String reportPath;
    
    public ReportGenerator() throws SQLException{
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;username=auron;password=auron123;databaseName=DigitalPharmacy");
        
    }
    
    public void gjeneroRaportin(String path,String emriPDF) throws JRException{
        JasperReport jReport = JasperCompileManager.compileReport(path);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jReport, null, con);
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Auron\\Documents\\NetBeansProjects\\DigitalPharmacy\\src\\Reports\\" + emriPDF);
        JasperViewer.viewReport(jasperPrint, false);
        
    }

}
