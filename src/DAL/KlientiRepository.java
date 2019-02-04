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
public class KlientiRepository extends EntMngClass implements KlientiInterface {

    @Override
    public void create(Klienti k) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Klienti k) {
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Klienti k) {
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
    }
    
    public void deleteKlienti(Klienti k){
        em.getTransaction().begin();
        Klienti mergedKlienti = em.merge(k);
        em.remove(mergedKlienti);
        em.getTransaction().commit();
        
    }

    @Override
    public List<Klienti> findAll() {
        return (List<Klienti>)em.createNamedQuery("Klienti.findAll").getResultList();
    }
    
    public int numeroKlientat(){
        return ((Number)em.createNamedQuery("Klienti.numeroKlientat").getSingleResult()).intValue();
    }

    @Override
    public Klienti findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
