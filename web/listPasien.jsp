<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Pasien, java.util.List" %>
<h1>Pasien List</h1>
<jsp:include page="/PasienManager" />

<table class="ui celled table">
  <thead>
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
  </thead>
  <tbody>
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
        <td><a class="ui blue button" href="/AntreanKlinik/editPasien.jsp?e=${u.getUsername()}"><i class="write icon"></i></td>
        <td><a class="ui red button" href="/AntreanKlinik/PasienManager?d=${u.getUsername()}"><i class="remove circle icon"></i></td>
      </tr>

    </c:forEach>
  </tbody>
</table>
<a href="input.jsp" class="ui green button"><i class="plus icon"> </i>Tambah Pasien</a>
