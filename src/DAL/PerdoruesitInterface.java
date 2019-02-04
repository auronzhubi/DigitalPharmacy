/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesit;
import java.util.List;
/**
 *
 * @author ASUS
 */
public interface PerdoruesitInterface {
    void create(Perdoruesit p)throws FarmaciaException;
    void edit(Perdoruesit p)throws FarmaciaException;
    void delete(Perdoruesit p)throws FarmaciaException;
    List<Perdoruesit> findAll()throws FarmaciaException;
    Perdoruesit findById(Integer id)throws FarmaciaException;
}
