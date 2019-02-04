/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Produkti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Auron
 */
public class ProduktiComboBoxModel extends AbstractListModel<Produkti> implements ComboBoxModel<Produkti>{
    
    
    List<Produkti> lista;
    Produkti selectedItem;
    
    public ProduktiComboBoxModel(List<Produkti> lista){
        this.lista = lista;
    }

    public ProduktiComboBoxModel() {
        
    }
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Produkti getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Produkti)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
