/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import model.Pasien;

/**
 *
 * @author Dytra
 */
@Local
public interface PasienDAOLocal {

  void addPasien(Pasien pasien);

  void editPasien(Pasien pasien);

  void deletePasien(int id_pasien);

  Pasien getPasien(int id_pasien);

  List <Pasien> getAllPasien();
  
}
