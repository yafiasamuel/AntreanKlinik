<%-- 
    Document   : input_antrean
    Created on : Apr 2, 2017, 2:12:35 AM
    Author     : ChrisTz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action=".\CRUDantrean" method="post">
            <!--<input type="text" name="idantrian" placeholder="ID Antrian" ><br >-->
            <input type="text" name="username" placeholder="Username" ><br >
            <input type="text" name="nomor" placeholder="Nomor Antrian" ><br >
            <input type="date" placaholder="tanggal" name="tgl" ><br >
            <select name="status">
                <option name="status" value="mengantre">Mengantri</option>
                <option name="status" value="diperiksa">Diperiksa</option>
                <option name="status" value="skip">Skip</option>
                <option name="status" value="batal">Batal</option>
            </select>
                <br >
            <textarea name="keluhan" placeholder="keluhan" ></textarea><br >
            
              <input type="submit" name="action" value="input">
              <input type="reset"  Value="Clear">

        </form>
    </body>
</html>
