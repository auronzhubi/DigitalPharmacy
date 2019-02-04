/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Komuna;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;



/**
 *
 * @author Auron
 */
public class KomunaComboboxModel extends AbstractListModel<Komuna> implements ComboBoxModel<Komuna> {
    
    List<Komuna> lista;
    Komuna selectedItem;
    
    public KomunaComboboxModel(List<Komuna> lista){
        this.lista = lista;
    }
    
    public KomunaComboboxModel(){
       
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Komuna getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Komuna)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

   
}
