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
@Table(name = "pasien")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Pasien.findAll", query = "SELECT p FROM Pasien p")
  , @NamedQuery(name = "Pasien.findByUsername", query = "SELECT p FROM Pasien p WHERE p.username = :username")
  , @NamedQuery(name = "Pasien.findByNama", query = "SELECT p FROM Pasien p WHERE p.nama = :nama")
  , @NamedQuery(name = "Pasien.findByPassword", query = "SELECT p FROM Pasien p WHERE p.password = :password")
  , @NamedQuery(name = "Pasien.findByTempatLahir", query = "SELECT p FROM Pasien p WHERE p.tempatLahir = :tempatLahir")
  , @NamedQuery(name = "Pasien.findByTanggalLahir", query = "SELECT p FROM Pasien p WHERE p.tanggalLahir = :tanggalLahir")
  , @NamedQuery(name = "Pasien.findByJenisKelamin", query = "SELECT p FROM Pasien p WHERE p.jenisKelamin = :jenisKelamin")
  , @NamedQuery(name = "Pasien.findByStatus", query = "SELECT p FROM Pasien p WHERE p.status = :status")
  , @NamedQuery(name = "Pasien.findByPekerjaan", query = "SELECT p FROM Pasien p WHERE p.pekerjaan = :pekerjaan")
  , @NamedQuery(name = "Pasien.findByNomorTelpon", query = "SELECT p FROM Pasien p WHERE p.nomorTelpon = :nomorTelpon")
  , @NamedQuery(name = "Pasien.findByAlamat", query = "SELECT p FROM Pasien p WHERE p.alamat = :alamat")
  , @NamedQuery(name = "Pasien.findByFoto", query = "SELECT p FROM Pasien p WHERE p.foto = :foto")})
public class Pasien implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "username")
  private String username;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "nama")
  private String nama;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "password")
  private String password;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "tempat_lahir")
  private String tempatLahir;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "tanggal_lahir")
  private String tanggalLahir;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "jenis_kelamin")
  private String jenisKelamin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "status")
  private String status;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pekerjaan")
  private String pekerjaan;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 15)
  @Column(name = "nomor_telpon")
  private String nomorTelpon;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "alamat")
  private String alamat;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "foto")
  private String foto;

  public Pasien() {
  }

  public Pasien(String username) {
    this.username = username;
  }

  public Pasien(String username, String nama, String password, String tempatLahir, String tanggalLahir, String jenisKelamin, String status, String pekerjaan, String nomorTelpon, String alamat, String foto) {
    this.username = username;
    this.nama = nama;
    this.password = password;
    this.tempatLahir = tempatLahir;
    this.tanggalLahir = tanggalLahir;
    this.jenisKelamin = jenisKelamin;
    this.status = status;
    this.pekerjaan = pekerjaan;
    this.nomorTelpon = nomorTelpon;
    this.alamat = alamat;
    this.foto = foto;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTempatLahir() {
    return tempatLahir;
  }

  public void setTempatLahir(String tempatLahir) {
    this.tempatLahir = tempatLahir;
  }

  public String getTanggalLahir() {
    return tanggalLahir;
  }

  public void setTanggalLahir(String tanggalLahir) {
    this.tanggalLahir = tanggalLahir;
  }

  public String getJenisKelamin() {
    return jenisKelamin;
  }

  public void setJenisKelamin(String jenisKelamin) {
    this.jenisKelamin = jenisKelamin;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPekerjaan() {
    return pekerjaan;
  }

  public void setPekerjaan(String pekerjaan) {
    this.pekerjaan = pekerjaan;
  }

  public String getNomorTelpon() {
    return nomorTelpon;
  }

  public void setNomorTelpon(String nomorTelpon) {
    this.nomorTelpon = nomorTelpon;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (username != null ? username.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pasien)) {
      return false;
    }
    Pasien other = (Pasien) object;
    if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.Pasien[ username=" + username + " ]";
  }
  
}
