/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesit;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PerdoruesitRepository extends EntMngClass implements PerdoruesitInterface {
    
    @Override
    public void create(Perdoruesit p) throws FarmaciaException{
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Perdoruesit p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Perdoruesit p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public void deletePerdoruesit(Perdoruesit p){
        em.getTransaction().begin();
        Perdoruesit mergedPerdoruesit = em.merge(p);
        em.remove(mergedPerdoruesit);
        em.getTransaction().commit();
    }

    @Override
    public List<Perdoruesit> findAll() {
        return (List<Perdoruesit>)em.createNamedQuery("Perdoruesit.findAll").getResultList();
    }

    @Override
    public Perdoruesit findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void test(){
        
    }
}
