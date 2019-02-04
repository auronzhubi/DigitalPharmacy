/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import BLL.Furnizuesi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Auron
 */
public class FurnizuesiComboBoxModel extends AbstractListModel<Furnizuesi> implements ComboBoxModel<Furnizuesi>{
    List<Furnizuesi> lista;
    Furnizuesi selectedItem;
    
    public FurnizuesiComboBoxModel(List<Furnizuesi> lista){
        this.lista = lista;
    }

    public FurnizuesiComboBoxModel() {
        
    }

   

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Furnizuesi getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Furnizuesi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
