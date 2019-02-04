/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author Auron
 */
public interface KlientiInterface {
    void create(Klienti k)throws FarmaciaException;
    void edit(Klienti k)throws FarmaciaException;
    void delete(Klienti k)throws FarmaciaException;
    List<Klienti> findAll()throws FarmaciaException;
    Klienti findById(Integer id)throws FarmaciaException;
}
