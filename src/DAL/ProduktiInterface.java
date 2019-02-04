/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Produkti;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface ProduktiInterface {
    void create(Produkti p)throws FarmaciaException;
    void edit(Produkti p)throws FarmaciaException;
    void delete(Produkti p)throws FarmaciaException;
    List<Produkti> findAll()throws FarmaciaException;
    Produkti findById(Integer id)throws FarmaciaException;
}
