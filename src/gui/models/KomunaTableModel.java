/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Komuna;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dfz
 */
public class KomunaTableModel extends AbstractTableModel{

    
    String[] kolonat = {"Komuna"};
    List<Komuna> lista;
    
    public KomunaTableModel(List<Komuna> lista){
        this.lista = lista;
    }
    
    public void add(List<Komuna> lista){
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount(){
        return kolonat.length;
    }

    public Object getKomuna(int pos) {
        return lista.get(pos);
    }
    
    public String convertDateFormat(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(d);
    }
    
    @Override
    public Object getValueAt(int rowIndex , int columnIndex){
        Komuna k = (Komuna)getKomuna(rowIndex);
            return k.getEmriKomunes();
        }
    
    @Override
    public String getColumnName(int column){
        return kolonat[column];
    }
    
}

