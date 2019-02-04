/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Klienti;
import BLL.Terapia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class TerapiaDorzimTableModel extends AbstractTableModel {
    String [] kolonat = {"Emri klientit","Komuna","Emri rruges","Numri hyrjes","Kati","Pershkrimi"};
    
    List<Terapia> lista;
    
    public TerapiaDorzimTableModel(List<Terapia> lista){
        this.lista = lista;
    }
    
    public Terapia getTerapia(int pos) {
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
       Terapia t = getTerapia(rowIndex);
       Klienti k = t.getKlientiID();
       
       
       switch(columnIndex){
           case 0:
               return k.getEmri();
           case 1:
               return k.getKomunaID();
           case 2:
               return k.getEmriRruges();
           case 3:
               return k.getNumriHyrjes();
           case 4:
               return k.getKati();
           case 5:
               return k.getPershkrimi();
           default:
               return null;
       }
       
       
    }
    
    
}
