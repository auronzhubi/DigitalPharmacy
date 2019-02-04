/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.TipiStafit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TipiStafitTableModel extends AbstractTableModel {
    
    String [] kolonat = {"Tipi i Stafit"};
    
    List<TipiStafit> lista;
    
    public TipiStafitTableModel(List<TipiStafit> lista){
        this.lista = lista;
    }
    
    public void add(List<TipiStafit> lista){
        this.lista = lista;
    }
    
    public TipiStafit getTipiStafit(int pos){
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipiStafit ts = getTipiStafit(rowIndex);
        return ts.getLlojiTipit();
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
}
    
