/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Furnizuesi;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class FurnizuesiRepository extends EntMngClass implements FurnizuesiInterface{
    
     @Override
    public void create(Furnizuesi f) throws FarmaciaException{
        try{
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Furnizuesi f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Furnizuesi f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }
    
    public void deleteFurnizuesi(Furnizuesi f){
        em.getTransaction().begin();
        Furnizuesi mergedFurnizuesi = em.merge(f);
        em.remove(mergedFurnizuesi);
        em.getTransaction().commit();
    }

    @Override
    public List<Furnizuesi> findAll() {
        return (List<Furnizuesi>)em.createNamedQuery("Furnizuesi.findAll").getResultList();
    }

    @Override
    public Furnizuesi findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void test(){
        
    }
}
