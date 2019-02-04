/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Komuna;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface KomunaInterface {
    void create(Komuna k)throws FarmaciaException;
    void edit(Komuna k)throws FarmaciaException;
    void delete(Komuna k)throws FarmaciaException;
    List<Komuna> findAll()throws FarmaciaException;
    Komuna findById(Integer id)throws FarmaciaException;
}
