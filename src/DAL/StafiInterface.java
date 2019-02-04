/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Stafi;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface StafiInterface {
    void create(Stafi s)throws FarmaciaException;
    void edit(Stafi s)throws FarmaciaException;
    void delete(Stafi s)throws FarmaciaException;
    List<Stafi> findAll()throws FarmaciaException;
    Stafi findById(Integer id)throws FarmaciaException;
}
