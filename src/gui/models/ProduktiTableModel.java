/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Klienti;
import BLL.LlojiProduktit;
import BLL.Produkti;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class ProduktiTableModel extends AbstractTableModel {
    String[] kolonat = {"Barkodi", "Numri Serise", "Emri", "Perberesi Baze", "Data Skadimit", "Numri Tabletave", 
        "Lloji Produktit", "Cmimi", "Cmimi furnizues","Prodhuesi", "Shteti Prodhimit"};
    
    List<Produkti> lista;
    
    public ProduktiTableModel(){
        
    }
    
    public ProduktiTableModel(List<Produkti> lista){
        this.lista = lista;
    }
    
    public void add(List<Produkti> lista) {
        this.lista = lista;
    }
    
    public Produkti getProdukti(int pos){
        return lista.get(pos);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return kolonat.length;
    }
    
    public String convertDateFormat(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(d);
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produkti p = getProdukti(rowIndex);
        LlojiProduktit lp = p.getLlojiProduktitID();
        
        
        switch (columnIndex) {
            case 0:
                return p.getProduktiID();
            case 1:
                return p.getNumriSerik();
            case 2:
                return p.getEmri();
            case 3:
                return p.getPerbersiBaze();
            case 4:
                return convertDateFormat(p.getDataSkadimit());
            case 5:
                return p.getNumriTabletave();
            case 6:
                return lp.getLlojiProduktit();
            case 7:
                return p.getQmimi();
            case 8:
                return p.getQmimiFurnizues();
            case 9:
                return p.getProdhuesi();
            case 10:
                return p.getShtetiProdhimit();
            default:
                return null;

        }
    }
    
    
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
}
