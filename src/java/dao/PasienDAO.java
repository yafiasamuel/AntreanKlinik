/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Pasien;

/**
 *
 * @author Dytra
 */
@Stateless
public class PasienDAO implements PasienDAOLocal {
  @PersistenceContext
  private EntityManager em;
  
  @Override
  public void addPasien(Pasien pasien) {
    em.persist(pasien);
  }

  @Override
  public void editPasien(Pasien pasien) {
    em.merge(pasien);
  }

  @Override
  public void deletePasien(int id_pasien) {
    em.remove(getPasien(id_pasien));
  }

  @Override
  public Pasien getPasien(int id_pasien) {
    return em.find(Pasien.class, id_pasien);
  }

  @Override
  public List <Pasien> getAllPasien() {
    return null;
  }
  

  
  
}
