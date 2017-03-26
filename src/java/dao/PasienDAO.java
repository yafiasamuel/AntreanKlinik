/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import model.Pasien;

/**
 *
 * @author Dytra
 */
@Stateless
public class PasienDAO implements PasienDAOLocal {

  @Override
  public void addPasien(Pasien pasien) {
  }

  @Override
  public void editPasien(Pasien pasien) {
  }

  @Override
  public void deletePasien(int id_pasien) {
  }

  @Override
  public Pasien getPasien(int id_pasien) {
    return null;
  }

  @Override
  public List <Pasien> getAllPasien() {
    return null;
  }
  

  
  
}
