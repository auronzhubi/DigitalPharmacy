/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ProduktetETerapise;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface ProduktetETerapiseInterface {
    void create(ProduktetETerapise pt)throws FarmaciaException;
    void edit(ProduktetETerapise pt)throws FarmaciaException;
    void delete(ProduktetETerapise pt)throws FarmaciaException;
    List<ProduktetETerapise> findAll()throws FarmaciaException;
    ProduktetETerapise findById(Integer id)throws FarmaciaException;
}
