/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Terapia;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface TerapiaInterface {
    void create(Terapia t)throws FarmaciaException;
    void edit(Terapia t)throws FarmaciaException;
    void delete(Terapia t)throws FarmaciaException;
    List<Terapia> findAll()throws FarmaciaException;
    Terapia findById(Integer id)throws FarmaciaException;
}
