<%-- 
    Document   : registrasi
    Created on : Mar 26, 2017, 12:20:53 AM
    Author     : ChrisTz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrasi Pasien</title>
    <link rel="stylesheet" href="assets/semantic.min.css" />
    <script src="assets/jquery-3.2.0.min.js" ></script>
    <script src="assets/semantic.min.js" ></script>
  </head>
  <body>
    <div class="ui stackable sixten column grid">
      <div class="four wide column"></div>
      <div class="eight wide column">
        <div class="ui segment">
          <form action="./RegistrasiPasien" method="POST" class="ui form">
            <h1>Pendaftaran Pasien</h1>
            <div class="field">
              <label>Username</label>
              <input type="text" name="username" placeholder="username" value="${pasien.username}" required>
            </div>
            <div class="field">
              <label>Nama Lengkap</label>
              <input type="text" name="nama" placeholder="nama" value="${pasien.nama}" required>
            </div>
            <div class="field">
              <label>Password</label>
              <input type="password" name="password" placeholder="password" value="${pasien.password}" required>
            </div>
            <div class="field">
              <div class="two fields">
                <div class="field">
                  <label>Tempat</label>
                  <input type="text" name="tempat_lahir" placeholder="tempat Lahir" value="${pasien.tempatLahir}">
                </div>
                <div class="field">
                  <label>Tanggal Lahir</label>
                  <input type="date" name="tanggal_lahir" placeholder="tanggal Lahir" value="${pasien.tanggalLahir}" required>
                </div>
              </div>
            </div>
            <div class="field">
              <label>Jenis Kelamin</label>
              <select name="jenisKelamin" class="ui selection dropdown" value="${pasien.jenisKelamin}" required>
                <option name="jenisKelamin" value="Pria">Pria</option>
                <option name="jenisKelamin" value="Wanita">Wanita</option>
              </select>
            </div>
            <div class="field">
              <label>Status</label>
              <select name="status" class="ui sleection dropdown" value="${pasien.status}" required>
                <option name="status" value="Menikah">Menikah</option>
                <option name="status" value="Belum Menikah">Belum Menikah</option>
              </select>
            </div>
            <div class="field">
              <label>Pekerjaan</label>
              <input type="text" name="pekerjaan" placeholder="Pekerjaan" value="${pasien.pekerjaan}" required >
            </div>
            <div class="field">
              <label>Nomor Telepon</label>
              <input type="text" name="nomorTelp" placeholder="Nomor Telepon" value="${pasien.nomorTelepon}" required>
            </div>
            <div class="field">
              <label>Alamat</label>
              <textarea name="alamat" placeholder="Alamat" value="${pasien.alamat}" required></textarea>
            </div>
            <div class="field">
              <label>Foto</label>
              <input type="text" name="foto" placeholder="Foto" value="${pasien.foto}" required><br />
            </div>

            <div class="ui buttons">
              <input type="submit" class="ui big positive teal button" name="action" value="daftar">
              <div class="or"></div>
              <input type="reset" class="ui big button" Value="Clear">
            </div>
          </form>

          <div class="four wide column"></div>
        </div>
        <script>
          $('.ui.dropdown')
                  .dropdown()
                  ;
        </script>
      </div>


  </body>
</html>
