/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.ProduktetETerapise;
import BLL.Produkti;
import BLL.Terapia;
import gui.TerapiaFinal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class TerapiaTableModel extends AbstractTableModel {

    String[] kolonat = {"Emri produktit", "Doza", "Ditore", "Kohezgjatja e terapise"};

    List<ProduktetETerapise> lista;

    public TerapiaTableModel(List<ProduktetETerapise> lista) {
        this.lista = lista;
    }

    public void add(List<ProduktetETerapise> lista) {
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

    public ProduktetETerapise getProduktetETerapise(int pos) {
        return lista.get(pos);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProduktetETerapise pt = getProduktetETerapise(rowIndex);
        Produkti p = pt.getProduktiID();
        Terapia t = pt.getTerapiaID();
        
        switch(columnIndex){
            case 0:
                return p.getEmri();
            case 1:
                return pt.getDoza();
            case 2:
                return pt.getDitore();
            case 3:
                return t.getKohezgjatja();
            default:
                return null;
        }

       
    }

    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }
}
