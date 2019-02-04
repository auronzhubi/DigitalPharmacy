/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LlojiProduktit;
import java.util.List;

/**
 *
 * @author Auron
 */
public class LlojiProduktitRepository extends EntMngClass implements LlojiProduktitInterface{

    @Override
    public void create(LlojiProduktit l) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(LlojiProduktit l) throws FarmaciaException {
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
    }

    @Override
    public void delete(LlojiProduktit l) throws FarmaciaException {
         em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    }

    @Override
    public List<LlojiProduktit> findAll()  {
        return (List<LlojiProduktit>)em.createNamedQuery("LlojiProduktit.findAll").getResultList();
    }

    @Override
    public LlojiProduktit findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
