/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;



import BLL.TipiStafit;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Auron
 */
public class TipiStafitComboBoxModel extends AbstractListModel<TipiStafit> implements ComboBoxModel<TipiStafit>{
    List<TipiStafit> lista;
    TipiStafit selectedItem;
    
    public TipiStafitComboBoxModel(List<TipiStafit> lista){
        this.lista = lista;
    }

    public TipiStafitComboBoxModel() {
        
    }
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public TipiStafit getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (TipiStafit)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
