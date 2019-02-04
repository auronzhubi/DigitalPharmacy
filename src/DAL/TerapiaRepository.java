/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.Terapia;
import java.util.List;

/**
 *
 * @author Auron
 */
public class TerapiaRepository extends EntMngClass implements TerapiaInterface {
    @Override
    public void create(Terapia t) throws FarmaciaException {
        try{
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Terapia t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Terapia t) {
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }
    
    public void deleteTerapia(Terapia t){
        em.getTransaction().begin();
        Terapia mergedTerapia = em.merge(t);
        em.remove(mergedTerapia);
        em.getTransaction().commit();
    }

    @Override
    public List<Terapia> findAll() {
        return (List<Terapia>)em.createNamedQuery("Klienti.findAll").getResultList();
    }
    
    public int numeroTerapite(){
        return ((Number)em.createNamedQuery("Terapia.numeroTerapite").getSingleResult()).intValue();
    }
    
    public List<Terapia> findTerapiaKlientit(Integer id){
        return em.createNamedQuery("Terapia.findTerapiaKlientit").getResultList();
    }

    @Override
    public Terapia findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
