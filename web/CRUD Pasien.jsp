<%-- 
    Document   : CRUD Pasien
    Created on : Mar 28, 2017, 6:24:31 PM
    Author     : Yafia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pasien</title>
    </head>
    <body>
        <form action="POST">
        <h1>Data Pasien</h1>
        <table border="1">
            <tr>
                <td>Username</td>
                <td>Nama</td>
                <td>Password</td>
                <td>Tempat Lahir</td>
                <td>Tanggal Lahir</td>
                <td>Jenis Kelamin</td>
                <td>Status</td>
                <td>Pekerjaan</td>
                <td>Nomor Telp</td>
                <td>Alamat</td>
                <td>Foto</td>
                <td>Action</td>
            </tr>
        </table>
        <p><input type="submit" name="tambahpasien" value="Tambah Pasien"></p>
        </form>
    </body>
</html>
