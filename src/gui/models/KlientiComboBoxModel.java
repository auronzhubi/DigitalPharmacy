/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Klienti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Auron
 */
public class KlientiComboBoxModel extends AbstractListModel<Klienti> implements ComboBoxModel<Klienti> {
    
    List<Klienti> lista;
    Klienti selectedItem;
    
    public KlientiComboBoxModel(List<Klienti> lista){
        this.lista = lista;
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Klienti getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Klienti)anItem;    
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
