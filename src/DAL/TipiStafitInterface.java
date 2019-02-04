/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.TipiStafit;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface TipiStafitInterface {
    void create(TipiStafit ts)throws FarmaciaException;
    void edit(TipiStafit ts)throws FarmaciaException;
    void delete(TipiStafit ts)throws FarmaciaException;
    List<TipiStafit> findAll()throws FarmaciaException;
    TipiStafit findById(Integer id)throws FarmaciaException;
}
