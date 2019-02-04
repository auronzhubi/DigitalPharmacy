/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ProduktetEFurnizuesit;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface ProduktetEFurnizuesitInterface {
     void create(ProduktetEFurnizuesit p)throws FarmaciaException;
    void edit(ProduktetEFurnizuesit p)throws FarmaciaException;
    void delete(ProduktetEFurnizuesit p)throws FarmaciaException;
    List<ProduktetEFurnizuesit> findAll()throws FarmaciaException;
    ProduktetEFurnizuesit findById(Integer id)throws FarmaciaException;
}
