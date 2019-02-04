/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ProduktetEFurnizuesit;
import java.util.List;

/**
 *
 * @author Auron
 */
public class ProduktetEFurnizuesitRepository extends EntMngClass implements ProduktetEFurnizuesitInterface {

    @Override
    public void create(ProduktetEFurnizuesit p) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(ProduktetEFurnizuesit p) throws FarmaciaException {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    @Override
    public void delete(ProduktetEFurnizuesit p) throws FarmaciaException {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public void deleteProduktetEFurnizuesit(ProduktetEFurnizuesit p){
        em.getTransaction().begin();
        ProduktetEFurnizuesit mergedProduktetEFurnizuesit = em.merge(p);
        em.remove(mergedProduktetEFurnizuesit);
        em.getTransaction().commit();
    }

    @Override
    public List<ProduktetEFurnizuesit> findAll() {
        return (List<ProduktetEFurnizuesit>)em.createNamedQuery("ProduktetEFurnizuesit.findAll").getResultList();
    }

    @Override
    public ProduktetEFurnizuesit findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
