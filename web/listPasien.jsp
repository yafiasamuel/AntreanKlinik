<%-- 
    Document   : listPasien
    Created on : Apr 4, 2017, 9:45:32 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Pasien, java.util.List" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Pasien</title>
  </head>
  <body>
    <h1>Pasien List</h1>
    <jsp:include page="/PasienManager" />

    <table border="1">
      <tr>
        <th>Username</th>
        <th>Nama</th>
        <th>Password</th>
        <th>Tempat Lahir</th>
        <th>Tanggal Lahir</th>
        <th>Gender</th>
        <th>Status</th>
        <th>Pekerjaan</th>
        <th>Nomor Telepon</th>
        <th>Alamat</th>
        <th>Foto</th>
        <th colspan="2">Action</th>
      </tr>

      <c:forEach var="u" items="<%= request.getAttribute("ole") %>">
        <tr>
          <td>${u.getUsername()}</td>
          <td>${u.getNama()}</td>
          <td>${u.getPassword()}</td>
          <td>${u.getTempatLahir()}</td>
          <td>${u.getTanggalLahir()}</td>
          <td>${u.getJenisKelamin()}</td>
          <td>${u.getStatus()}</td>
          <td>${u.getPekerjaan()}</td>
          <td>${u.getNomorTelpon()}</td>
          <td>${u.getAlamat()}</td>
          <td>${u.getFoto()}</td>
          <td><a href="/editPasien.jsp?e=${u.getUsername()}">Edit</td>
          <td><a href="/AntreanKlinik/PasienManager?d=${u.getUsername()}">Hapus</td>
        </tr>

      </c:forEach>
    </table>
    <a href="input.jsp">Tambah Pasien</a>
    <%= request.getAttribute("pesan") %>
  </body>
</html>
