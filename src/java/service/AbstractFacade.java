/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Antrean;

/**
 *
 * @author Dytra
 */
public abstract class AbstractFacade<T> {

  private Class<T> entityClass;
  String globalDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected abstract EntityManager getEntityManager();

  public void create(T entity) {
    getEntityManager().persist(entity);
  }

  public void createAntrean(T entity) {
    getEntityManager().persist(entity);
    getEntityManager().flush();
    getEntityManager().refresh(entity);

  }

  public void edit(T entity) {
    getEntityManager().merge(entity);
  }

  public void remove(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }

  public T find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public List<T> findAll() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findRange(int[] range) {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0] + 1);
    q.setFirstResult(range[0]);
    return q.getResultList();
  }

  public int count() {
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
    cq.select(getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }

  public List<Antrean> getCurrentAntrean() {
    String arg1 = globalDate;
    String arg2 = "diperiksa";
    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1 and e.status=:arg2");
    query.setParameter("arg1", arg1);
    query.setParameter("arg2", arg2);
    return query.getResultList();
  }

  public List<Antrean> getAllCurrentAntrean() {

    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1 and e.status=:arg2");
    query.setParameter("arg1", globalDate);
    query.setParameter("arg2", "mengantre");
    return query.getResultList();
  }

  public Antrean getSingleCurrentAntrean() {

    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1 and e.status=:arg2");
    query.setParameter("arg1", globalDate);
    query.setParameter("arg2", "diperiksa");
    return (Antrean) query.getSingleResult();
  }
  
  public Antrean getCurrentAntreanByUsername(String user) {
    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.username=:arg1");
    query.setParameter("arg1", user);
    return (Antrean) query.getSingleResult();
  }
  
  
  
  public int getTotalCurrentAntrean(String tanggal) {
    //api * mengambil total yang mengantre
    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1 and (e.status=:arg2 or e.status=:arg3 or e.status=:arg4)");
    query.setParameter("arg1", tanggal);
    query.setParameter("arg2", "mengantre");
    query.setParameter("arg3", "diperiksa");
    query.setParameter("arg4", "selesai");
    return query.getResultList().size();
  }
  
  public int getNomorDiperiksa(String tanggalMengantre) {
     Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1 and e.status=:arg2");
    query.setParameter("arg1", tanggalMengantre);
    query.setParameter("arg2", "diperiksa");
    //cek apakah blm ada yg periksa
    int count = 0;
    
    List <Antrean> la = (List <Antrean>) query.getResultList();
    int a = la.size();
    if(a == 0)
      count =0;
    else
      count = la.get(0).getNomorAntrean();
    return count;
    
  }
  
  public int generateNomorAntrean(String tanggalAntrean) {
    int count;
    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean=:arg1");
    query.setParameter("arg1", tanggalAntrean);
    List <Antrean> a = (List <Antrean>) query.getResultList();
    if(a == null) {
      count = 0;
    } else {
      count = a.size();
    }
    return count;
  }
  
    public int getNumberOfAntreanByUser(String username) {
    int count;
    Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.username =:arg2");

    query.setParameter("arg2", username);
    List <Antrean> a = (List <Antrean>) query.getResultList();
    return a.size();
  }
    
    public int getAntreanByTanggal(String tanggal) {
      Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean =:arg2");

    query.setParameter("arg2", tanggal);
    List <Antrean> a = (List <Antrean>) query.getResultList();
    return a.size();
    }
    
    public int checkEmpty() {
      Query query = getEntityManager().createQuery("SELECT e FROM Antrean e where e.tanggalAntrean =:arg1 and e.status =:arg2");
      query.setParameter("arg1", globalDate);
      query.setParameter("arg2", "mengantre");
      List <Antrean> la = (List <Antrean>)query.getResultList();
      return la.size();
    }
  
  
  
  


}
