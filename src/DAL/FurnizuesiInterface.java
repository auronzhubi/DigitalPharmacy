/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Furnizuesi;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface FurnizuesiInterface {
    void create(Furnizuesi f)throws FarmaciaException;
    void edit(Furnizuesi f)throws FarmaciaException;
    void delete(Furnizuesi f)throws FarmaciaException;
    List<Furnizuesi> findAll()throws FarmaciaException;
    Furnizuesi findById(Integer id)throws FarmaciaException;
}
