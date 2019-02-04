/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Furnizuesi;
import BLL.Komuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class FurnizuesiTableModel extends AbstractTableModel {

    String[] kolonat = {"EmriFurnizuesit", "Komuna", "NumriTelefonit"};

    List<Furnizuesi> lista1;

    public FurnizuesiTableModel() {

    }

    public FurnizuesiTableModel(List<Furnizuesi> lista1) {
        this.lista1 = lista1;
    }

    public void add(List<Furnizuesi> lista) {
        this.lista1 = lista1;
    }

    public Furnizuesi getFurnizuesi(int pos) {
        return lista1.get(pos);
    }

    @Override
    public int getRowCount() {
        return lista1.size();
        
    }

    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Furnizuesi f = getFurnizuesi(rowIndex);
        Komuna k = f.getKomunaID();

        switch (columnIndex) {
            case 0:
                return f.getEmriFurnizuesit();
            case 1:
                return k.getEmriKomunes();
            case 2:
                return f.getNumriTelefonit();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

}
