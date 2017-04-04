/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.Antrean;
import org.jboss.weld.util.LazyValueHolder;

/**
 *
 * @author Dytra
 */
public class AntreanDAO implements Serializable{

  private final EntityManager em;
  private final EntityManagerFactory emf;

  public AntreanDAO() {
    emf = Persistence.createEntityManagerFactory("AntreanKlinik3PU");
    em = emf.createEntityManager();
  }

  public void create(Antrean tb) {
    em.getTransaction().begin();
    em.persist(tb);
    em.getTransaction().commit();
  }

  public void update(Antrean tb) {
    em.getTransaction().begin();
    em.merge(tb);
    em.getTransaction().commit();
  }

  public void delete(Antrean tb) {
    em.getTransaction().begin();
    //em.remove(tb);
    em.remove(em.contains(tb) ? tb : em.merge(tb));
    em.getTransaction().commit();
  }

  public Antrean getId(int id) {
    return em.find(Antrean.class, id);
  }

  public List<Antrean> getAllAntrean() {
    String jpql = "SELECT a FROM Antrean a ORDER BY a.anakID";
    return (List<Antrean>) em.createQuery(jpql).getResultList();
  }

  public static void main(String[] args) {
    System.out.println("hi");
    AntreanDAO ad = new AntreanDAO();
  }

}
