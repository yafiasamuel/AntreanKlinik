/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dytra
 */
@Entity
@Table(name = "antrean")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Antrean.findAll", query = "SELECT a FROM Antrean a")
  , @NamedQuery(name = "Antrean.findByIdAntrean", query = "SELECT a FROM Antrean a WHERE a.idAntrean = :idAntrean")
  , @NamedQuery(name = "Antrean.findByUsername", query = "SELECT a FROM Antrean a WHERE a.username = :username")
  , @NamedQuery(name = "Antrean.findByNomorAntrean", query = "SELECT a FROM Antrean a WHERE a.nomorAntrean = :nomorAntrean")
  , @NamedQuery(name = "Antrean.findByTanggalAntrean", query = "SELECT a FROM Antrean a WHERE a.tanggalAntrean = :tanggalAntrean")
  , @NamedQuery(name = "Antrean.findByStatus", query = "SELECT a FROM Antrean a WHERE a.status = :status")
  , @NamedQuery(name = "Antrean.findByKeluhan", query = "SELECT a FROM Antrean a WHERE a.keluhan = :keluhan")})
public class Antrean implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Basic(optional = false)
  @Column(name = "id_antrean")
  private Integer idAntrean;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "username")
  private String username;
  @Basic(optional = false)
  @NotNull
  @Column(name = "nomor_antrean")
  private int nomorAntrean;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "tanggal_antrean")
  private String tanggalAntrean;
  @Size(max = 50)
  @Column(name = "status")
  private String status;
  @Size(max = 250)
  @Column(name = "keluhan")
  private String keluhan;

  public Antrean() {
  }

  public Antrean(Integer idAntrean) {
    this.idAntrean = idAntrean;
  }

  public Antrean(Integer idAntrean, String username, int nomorAntrean, String tanggalAntrean) {
    this.idAntrean = idAntrean;
    this.username = username;
    this.nomorAntrean = nomorAntrean;
    this.tanggalAntrean = tanggalAntrean;
  }

  public Antrean(String username, int nomorAntrean, String tanggalAntrean, String status, String keluhan) {
    this.username = username;
    this.nomorAntrean = nomorAntrean;
    this.tanggalAntrean = tanggalAntrean;
    this.status = status;
    this.keluhan = keluhan;
  }
  
   public Antrean(Integer idAntrean,String username, int nomorAntrean, String tanggalAntrean, String status, String keluhan) {
    this.idAntrean = idAntrean;
    this.username = username;
    this.nomorAntrean = nomorAntrean;
    this.tanggalAntrean = tanggalAntrean;
    this.status = status;
    this.keluhan = keluhan;
  }
  
  public Antrean(Integer idInteger, String keluhan) {
    this.idAntrean = idInteger;
    this.keluhan = keluhan;
  }

  public Integer getIdAntrean() {
    return idAntrean;
  }

  public void setIdAntrean(Integer idAntrean) {
    this.idAntrean = idAntrean;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getNomorAntrean() {
    return nomorAntrean;
  }

  public void setNomorAntrean(int nomorAntrean) {
    this.nomorAntrean = nomorAntrean;
  }

  public String getTanggalAntrean() {
    return tanggalAntrean;
  }

  public void setTanggalAntrean(String tanggalAntrean) {
    this.tanggalAntrean = tanggalAntrean;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getKeluhan() {
    return keluhan;
  }

  public void setKeluhan(String keluhan) {
    this.keluhan = keluhan;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idAntrean != null ? idAntrean.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Antrean)) {
      return false;
    }
    Antrean other = (Antrean) object;
    if ((this.idAntrean == null && other.idAntrean != null) || (this.idAntrean != null && !this.idAntrean.equals(other.idAntrean))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.Antrean[ idAntrean=" + idAntrean + " ]";
  }
  
}
