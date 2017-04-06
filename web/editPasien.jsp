<%-- 
    Document   : editPasien
    Created on : Apr 5, 2017, 7:44:19 AM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Pasien, java.util.List" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Pasien | Klinik Online</title>
    <link rel="stylesheet" href="assets/semantic.min.css" />
    <link rel="stylesheet" href="assets/main.css" />
  </head>
  <body>
    <form class="ui form" action="PasienManager" method="POST" style="width:50% !important;margin-left: 3em">
      <h1>Edit Pasien</h1>
      <jsp:include page="<%= "/PasienManager?e=" + request.getParameter("e") %>" />

      <p><div class="disabled field"><input type="text" placeholder="Username" value="${p.getUsername()}" name="username"></div></p>
      <p><input type="text" placeholder="Nama" value="${p.getNama()}" name="nama"></p>
      <p><input type="text" placeholder="password" value="${p.getPassword()}" name="password"></p>
      <p><input type="text" placeholder="Tempat Lahir" value="${p.getTempatLahir()}" name="tempatlahir"></p>
      <p><input type="text" placeholder="Tanggal Lahir" value="${p.getTanggalLahir()}" name="tanggallahir"></p>
      <p><input type="text" placeholder="Jenis Kelamin" value="${p.getJenisKelamin()}" name="jeniskelamin"></p>
      <p><input type="text" placeholder="Status" value="${p.getStatus()}" name="status"></p>
      <p><input type="text" placeholder="Pekerjaan" value="${p.getPekerjaan()}" name="pekerjaan"></p>
      <p><input type="text" placeholder="Nomor Telepon" value="${p.getNomorTelpon()}" name="nomortelp"></p>
      <p><input type="text" placeholder="Alamat" value="${p.getAlamat()}" name="alamat"></p>
      <p>Foto : <input type="file" class="ui button" name="foto" value="${p.foto}" accept="image/*" ></p>
      <p><input type="submit" class="ui blue button" name="submit" value="Edit"></p>
    </form>
  </body>
</html>
