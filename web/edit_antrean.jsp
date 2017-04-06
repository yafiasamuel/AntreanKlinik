<%-- 
    Document   : edit_antrean
    Created on : Apr 5, 2017, 1:05:33 PM
    Author     : Yafia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Antrean, java.util.List" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/semantic.min.css" />
    <link rel="stylesheet" href="assets/main.css" />
    <title>Edit Antrean</title>
  </head>
  <body>
    <form action="RUDantrean" class="ui form" method="post" style="width:50% !important;margin-left: 3em">
      <h1>Edit Antrean</h1>
      <jsp:include page="<%= "/RUDantrean?e=" + request.getParameter("e") %>" />
      <input type="hidden" name="id" value="${p.getIdAntrean()}"  ><br >
      <input type="text" name="username" value="${p.getUsername()}"><br >
      <input type="text" name="nomor" value="${p.getNomorAntrean()}" ><br >
      <input type="date" name="tanggal_antrean" value="${p.getTanggalAntrean()}"><br >
      <select name="status" value="${p.getStatus()}">
        <option name="status" value="mengantre" >Mengantri</option>
        <option name="status" value="diperiksa">Diperiksa</option>
        <option name="status" value="skip">Skip</option>
        <option name="status" value="batal">Batal</option>
        <option name="status" value="selesai">Selesai</option>
      </select>
      <br >
      <textarea name="keluhan" placeholder="keluhan" value="${p.getKeluhan()}">${p.getKeluhan()}</textarea><br >
      <p><input type="submit" class="ui blue button" name="submit" value="Edit"></p>

    </form>
  </body>
</html>
