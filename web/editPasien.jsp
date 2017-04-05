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
        <form action="PasienManager" method="POST">
            <h1>Edit Pasien</h1>
            <jsp:include page="<%= "/PasienManager?e=" + request.getParameter("e") %>" />

            <p><input type="text" value="${p.getUsername()}" name="username"></p>
            <p><input type="text" value="${p.getNama()}" name="nama"></p>
            <p><input type="text" value="${p.getPassword()}" name="password"></p>
            <p><input type="text" value="${p.getTempatLahir()}" name="tempatlahir"></p>
            <p><input type="text" value="${p.getTanggalLahir()}" name="tanggallahir"></p>
            <p><input type="text" value="${p.getJenisKelamin()}" name="jeniskelamin"></p>
            <p><input type="text" value="${p.getStatus()}" name="status"></p>
            <p><input type="text" value="${p.getPekerjaan()}" name="pekerjaan"></p>
            <p><input type="text" value="${p.getNomorTelpon()}" name="nomortelp"></p>
            <p><input type="text" value="${p.getAlamat()}" name="alamat"></p>
            <p>Foto : <input type="file" name="foto" value="${p.foto}" accept="image/*" ></p>
            <p><input type="submit" name="submit" value="Edit"></p>
        </form>
    </body>
</html>
