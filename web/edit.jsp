<%-- 
    Document   : edit
    Created on : Mar 28, 2017, 6:21:23 PM
    Author     : Yafia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data Pasien</title>
    </head>
    <body>
    <Form action="POST" >
        <p><input type="text" placeholder="Username" name="username"></p>
        <p><input type="text" placeholder="Nama" name="nama"></p>
        <p><input type="text" placeholder="Password" name="password"></p>
        <p><input type="text" placeholder="Tempat Lahir" name="tempatlahir"></p>
        <p><input type="text" placeholder="Tanggal Lahir" name="tanggallahir"></p>
        <p><input type="text" placeholder="Jenis Kelamin" name="jeniskelamin"></p>
        <p><input type="text" placeholder="Status" name="status"></p>
        <p><input type="text" placeholder="Pekerjaan" name="pekerjaan"></p>
        <p><input type="text" placeholder="Nomor Telp" name="nomortelp"></p>
        <p><input type="text" placeholder="Alamat" name="alamat"></p>
        <p>Foto : <input type="file" name="foto" accept="image/*" ></p>
        <p><input type="submit" name="submit" value="Update"></p>
        <p><input type="reset" name="Reset" value="Clear"></p>
    </form>
    </body>
</html>
