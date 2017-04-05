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
  </head>
  <body>
    <h1>Edit Pasien</h1>
    <jsp:include page="<%= "/PasienManager?e=" + request.getParameter("e") %>" />

    ${p.getNama()}
    ${p.getTanggalLahir()}
  </body>
</html>
