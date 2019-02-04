/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Produkti;
import java.util.List;

/**
 *
 * @author Auron
 */
public class ProduktiRepository extends EntMngClass implements ProduktiInterface {
    @Override
    public void create(Produkti p) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Produkti p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Produkti p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public void deleteProdukti(Produkti p){
        em.getTransaction().begin();
        Produkti mergedProdukti = em.merge(p);
        em.remove(mergedProdukti);
        em.getTransaction().commit();
    }

    @Override
    public List<Produkti> findAll() {
        return (List<Produkti>)em.createNamedQuery("Produkti.findAll").getResultList();
    }
    
    public int numeroProduktet(){
        return ((Number)em.createNamedQuery("Produkti.numeroProduktet").getSingleResult()).intValue();
    }

    @Override
    public Produkti findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
