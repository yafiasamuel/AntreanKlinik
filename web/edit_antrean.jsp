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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RUDantrean" method="post">
            <h1>Edit Antrean</h1>
            <jsp:include page="<%= "/RUDantrean?e=" + request.getParameter("e") %>" />
            <input type="hidden" name="id" value="${p.getIdAntrean()}"  ><br >
            <input type="text" name="username" value="${p.getUsername()}"><br >
            <input type="text" name="nomor" value="${p.getNomorAntrean()}" ><br >
            <input type="date" name="tanggal_antrean" value="${p.getTanggalAntrean()}"><br >
            <select name="status" value="${p.getStatus()}">
                <option name="status" value="Mengantri" >Mengantri</option>
                <option name="status" value="Diperiksa">Diperiksa</option>
                <option name="status" value="Skip">Skip</option>
                <option name="status" value="Batal">Batal</option>
            </select>
                <br >
            <textarea name="keluhan" placeholder="keluhan" value="${p.getKeluhan()}">${p.getKeluhan()}</textarea><br >
            <p><input type="submit" name="submit" value="Edit"></p>

        </form>
    </body>
</html>
