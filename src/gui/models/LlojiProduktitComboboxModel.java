/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;


import BLL.LlojiProduktit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Auron
 */
public class LlojiProduktitComboboxModel extends AbstractListModel<LlojiProduktit> implements ComboBoxModel<LlojiProduktit> {
    
    List<LlojiProduktit> lista;
    LlojiProduktit selectedItem;
    
    public LlojiProduktitComboboxModel( List<LlojiProduktit> lista){
        this.lista = lista;
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public LlojiProduktit getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (LlojiProduktit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
