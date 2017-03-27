<%-- 
    Document   : register
    Created on : Mar 24, 2017, 4:46:29 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pendaftaran Pasien</title>
  </head>
  <body>
    <h1>Pendaftaran Pasien</h1>
    <form action="./PasienServlet" method="POST">
      <p><input type="text" name="id_pasien" placeholder="ID Pasien..." value="${pasien.id_pasien}"/></p>
      <p><input type="text" name="nama" placeholder="Nama lengkap..." value="${pasien.nama}" /></p>
      <p><input type="text" name="username" placeholder="Username..." value="${pasien.username}"/></p>
      <p><input type="password" name="password" placeholder="Password..." value="${pasien.password}"/></p>
      <p><input type="text" name="tempat_lahir" placeholder="Tempat lahir..." value="${pasien.tempat_lahir}"/></p>
      <p><input type="date" name="tanggal_lahir" placeholder="Tanggal lahir..." value="${pasien.tanggal_lahir}"/></p>
      <p><input type="text" name="jenis_kelamin" placeholder="Jenis Kelamin..." value="${pasien.jenis_kelamin}"/></p>
      <p><input type="text" name="status" placeholder="Status..." value="${pasien.status}"/></p>
      <p><input type="text" name="pekerjaan" placeholder="Pekerjaan..." value="${pasien.pekerjaan}"/></p>
      <p><input type="text" name="nomor_telepon" placeholder="Nomor tlepon..." value="${pasien.nomor_telepon}"/></p>
      <p><input type="text" name="alamat" placeholder="Alamat..." value="${pasien.alamat}"/></p>
      <p><input type="text" name="foto" placeholder="Foto..." value="${pasien.foto}"/></p>
      
      <p><input type="submit" name="Add" value="Add"/></p>
    </form>
  </body>
</html>
