/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.LlojiProduktit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class LlojiProduktitTableModel extends AbstractTableModel {
    
    String [] kolonat = {"Lloji i Produktit"};
    
    List<LlojiProduktit> lista;
    
    public LlojiProduktitTableModel(List<LlojiProduktit> lista){
        this.lista = lista;
    }
    
    public void add(List<LlojiProduktit> lista){
        this.lista = lista;
    }
    
    public LlojiProduktit getLlojiProduktit(int pos){
        return lista.get(pos);
    }
    
    @Override
    public int getRowCount(){
        return lista.size();
    }
   
    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LlojiProduktit lp = getLlojiProduktit(rowIndex);
        return lp.getLlojiProduktit();
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
}

