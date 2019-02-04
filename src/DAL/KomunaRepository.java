/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Komuna;
import java.util.List;

/**
 *
 * @author Auron
 */
public class KomunaRepository extends EntMngClass implements KomunaInterface {

    @Override
    public void create(Komuna k) throws FarmaciaException {
        try {
            em.getTransaction().begin();
            em.persist(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FarmaciaException("Test 123");
        }
    }

    @Override
    public void edit(Komuna k) {
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Komuna k) {
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
    }

    @Override
    public List<Komuna> findAll() {
        return (List<Komuna>) em.createNamedQuery("Komuna.findAll").getResultList();
    }

//    public void detach(Komuna k) {
//        Komuna current = null;
//        em.getTransaction().begin();
//        if (!em.contains(k)) {
//            current = em.merge(k);
//        }
//        em.remove(current);
//        em.getTransaction().commit();
//        em.close();
//    }

    @Override
    public Komuna findById(Integer id) throws FarmaciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
