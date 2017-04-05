/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Antrean;

/**
 *
 * @author Dytra
 */
@Stateless
public class AntreanFacade extends AbstractFacade<Antrean> {

  @PersistenceContext(unitName = "AntreanKlinik3PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AntreanFacade() {
    super(Antrean.class);
  }
  
}
