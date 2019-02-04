/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LlojiProduktit;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface LlojiProduktitInterface {
    void create(LlojiProduktit l)throws FarmaciaException;
    void edit(LlojiProduktit l)throws FarmaciaException;
    void delete(LlojiProduktit l)throws FarmaciaException;
    List<LlojiProduktit> findAll()throws FarmaciaException;
    LlojiProduktit findById(Integer id)throws FarmaciaException;
}
