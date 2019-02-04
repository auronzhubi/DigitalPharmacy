/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;


import BLL.Perdoruesit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class PerdoruesitTableModel extends AbstractTableModel {
    String [] kolonat = {"Emri Perdoruesit","Fjalekalimi","Niveli Perdorimit"};
    
    List<Perdoruesit> lista;
    
    public PerdoruesitTableModel(List<Perdoruesit> lista){
        this.lista = lista;
    }
    
    public void add(List<Perdoruesit> lista) {
        this.lista = lista;
    }

    public Perdoruesit getPerdoruesi(int pos) {
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
        Perdoruesit p = getPerdoruesi(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getEmriPerdoruesit();
            case 1:
                return p.getFjalekalimi();
            case 2:
                return p.getNiveliPerdorimit();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

}
