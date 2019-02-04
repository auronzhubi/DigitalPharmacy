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
public class StafiRepository extends EntMngClass implements StafiInterface   {

    @Override
    public void create(Stafi s) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Stafi s) throws FarmaciaException {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Stafi s){
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
    }
    
    public void deleteStafi(Stafi s){
        em.getTransaction().begin();
        Stafi mergedStafi = em.merge(s);
        em.remove(mergedStafi);
        em.getTransaction().commit();
    }

    @Override
    public List<Stafi> findAll(){
        return (List<Stafi>)em.createNamedQuery("Stafi.findAll").getResultList();
    }

    @Override
    public Stafi findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
