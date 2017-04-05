<%-- 
    Document   : listAntrean
    Created on : Apr 5, 2017, 10:51:21 AM
    Author     : Yafia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Antrean, java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Antrean List</h1>
    <jsp:include page="/RUDantrean" />

    <table border="1">
      <tr>
        <th>ID Antrean</th>
        <th>Username</th>
        <th>Nomor Antrean</th>
        <th>Tanggal Antrean</th>
        <th>Status</th>
        <th>Keluhan</th>
        <th colspan="2">Action</th>
      </tr>

      <c:forEach var="u" items="<%= request.getAttribute("ole") %>">
        <tr>
          <td>${u.getIdAntrean()}</td>
          <td>${u.getUsername()}</td>
          <td>${u.getNomorAntrean()}</td>
          <td>${u.getTanggalAntrean()}</td>
          <td>${u.getStatus()}</td>
          <td>${u.getKeluhan()}</td>
          <td><a href="/AntreanKlinik/edit_antrean.jsp?e=${u.getIdAntrean()}">Edit</td>
          <td><a href="/AntreanKlinik/RUDantrean?d=${u.getIdAntrean()}">Hapus</td>
        </tr>

      </c:forEach>
    </table>
    <a href="input_antrean.jsp">Tambah Pasien</a>
    <%= request.getAttribute("pesan") %>
    </body>
</html>
