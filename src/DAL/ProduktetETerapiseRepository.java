/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.ProduktetETerapise;
import java.util.List;

/**
 *
 * @author Auron
 */
public class ProduktetETerapiseRepository extends EntMngClass implements ProduktetETerapiseInterface{

    @Override
    public void create(ProduktetETerapise pt) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(pt);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(ProduktetETerapise pt) throws FarmaciaException {
        em.getTransaction().begin();
        em.merge(pt);
        em.getTransaction().commit();
    }

    @Override
    public void delete(ProduktetETerapise pt) throws FarmaciaException {
        em.getTransaction().begin();
        em.remove(pt);
        em.getTransaction().commit();
    }
    
    public void deleteProduktetETerapise(ProduktetETerapise pt){
        em.getTransaction().begin();
        ProduktetETerapise mergedProduktetETerapise = em.merge(pt);
        em.remove(mergedProduktetETerapise);
        em.getTransaction().commit();
    }

    @Override
    public List<ProduktetETerapise> findAll()  {
        return (List<ProduktetETerapise>)em.createNamedQuery("ProduktetETerapise.findAll").getResultList();
    }
    
    public List<ProduktetETerapise> findTerapiaKlientit(Integer id){
        return em.createNamedQuery("ProduktetETerapise.findTerapiaKlientit").getResultList();
    }

    @Override
    public ProduktetETerapise findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
