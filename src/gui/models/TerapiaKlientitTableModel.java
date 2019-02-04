/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Klienti;
import BLL.ProduktetETerapise;
import BLL.Terapia;
import gui.TerapiaFinal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class TerapiaKlientitTableModel extends AbstractTableModel {

    String[] kolonat = {"Emri produktit", "Doza", "Ditore", "Kohezgjatja"};

    
    Klienti k ;
    List<Terapia> lista ;
    
    public TerapiaKlientitTableModel(Klienti k){
        this.k = k;
        lista = k.getTerapiaList();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolonat.length;
    }

    public Terapia getTerapia(int pos) {
        return lista.get(pos);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

}
