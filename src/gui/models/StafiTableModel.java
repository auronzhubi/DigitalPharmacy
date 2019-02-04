/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Stafi;
import BLL.TipiStafit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class StafiTableModel extends AbstractTableModel {
    String [] kolonat = {"ID","Emri","Mbiemri","Data Lindjes","Gjinia","Tipi stafit"};
    
    List<Stafi> lista;
    
    public StafiTableModel(List<Stafi> lista){
        this.lista = lista;
    }
    
    public StafiTableModel(){
        
    }
    
    public void add(List<Stafi> lista) {
        this.lista = lista;
    }

    public Stafi getStafi(int pos) {
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
        Stafi s = getStafi(rowIndex);
        TipiStafit ts = s.getTipiID();

        switch (columnIndex) {
            case 0:
                return s.getStafiID();
            case 1:
                return s.getEmri();
            case 2:
                return s.getMbiemri();
            case 3:
                return convertDateFormat(s.getDataLindjes());
            case 4:
                return s.getGjinia();
            case 5:
                return ts.getLlojiTipit();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
    
}
