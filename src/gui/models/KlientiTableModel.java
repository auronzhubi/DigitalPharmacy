/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;


import BLL.Klienti;
import BLL.Komuna;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class KlientiTableModel extends AbstractTableModel {

    String[] kolonat = {"Klienti_ID", "Emri", "Mbiemri", "DataLindjes", "Gjinia", "NrTelefonit", "Komuna", "EmriRruges", "NumriHyrjes",
        "Kati", "Pershkrimi"};
    List<Klienti> lista;
    
    

    public KlientiTableModel(List<Klienti> lista) {
        this.lista = lista;
        
    }

    public void add(List<Klienti> lista) {
        this.lista = lista;
    }
   

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    public Klienti getKlienti(int pos) {
        return lista.get(pos);
    }

    public String convertDateFormat(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(d);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k = getKlienti(rowIndex);
        Komuna kk = k.getKomunaID();
        
        
        switch (columnIndex) {
            case 0:
                return k.getKlientiID();
            case 1:
                return k.getEmri();
            case 2:
                return k.getMbiemri();
            case 3:
                return convertDateFormat(k.getDataLindjes());
            case 4:
                return k.getGjinia();
            case 5:
                return k.getNrTelefonit();
            case 6:
                return kk.getEmriKomunes();
            case 7:
                return k.getEmriRruges();
            case 8:
                return k.getNumriHyrjes();
            case 9:
                return k.getKati();
            case 10:
                return k.getPershkrimi();
            default:
                return null;

        }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

}
