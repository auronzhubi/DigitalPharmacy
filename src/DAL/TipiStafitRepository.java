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
public class TipiStafitRepository extends EntMngClass implements TipiStafitInterface{

    @Override
    public void create(TipiStafit ts) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(ts);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(TipiStafit ts) throws FarmaciaException {
        em.getTransaction().begin();
        em.merge(ts);
        em.getTransaction().commit();
    }

    @Override
    public void delete(TipiStafit ts) throws FarmaciaException {
        em.getTransaction().begin();
        em.remove(ts);
        em.getTransaction().commit();
    }

    @Override
    public List<TipiStafit> findAll() {
        return (List<TipiStafit>)em.createNamedQuery("TipiStafit.findAll").getResultList();
    }

    @Override
    public TipiStafit findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
