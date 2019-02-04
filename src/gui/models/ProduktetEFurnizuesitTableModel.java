/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Furnizuesi;
import BLL.ProduktetEFurnizuesit;
import BLL.Produkti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Auron
 */
public class ProduktetEFurnizuesitTableModel extends AbstractTableModel {

    String[] kolonat = {"Emri furnizuesit", "Emri produktit"};

    List<ProduktetEFurnizuesit> lista;

    public ProduktetEFurnizuesitTableModel(List<ProduktetEFurnizuesit> lista) {
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

    public ProduktetEFurnizuesit getProduktetEFurnizuesit(int pos) {
        return lista.get(pos);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProduktetEFurnizuesit pf = getProduktetEFurnizuesit(rowIndex);
        Produkti p = pf.getProduktiID();
        Furnizuesi f = pf.getFurnizuesiID();

        switch (columnIndex) {
            case 0:
                return f.getEmriFurnizuesit();
            case 1:
                return p.getEmri();
            default:
                return null;
        }

    }
    
    @Override
    public String getColumnName(int column) {
        return kolonat[column];
    }

}
