<%-- 
    Document   : registrasi
    Created on : Mar 26, 2017, 12:20:53 AM
    Author     : ChrisTz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrasi Pasien</title>
    </head>
    <body>
        <form action="./RegistrasiPasien" method="POST">
            <input type="text" name="username" placeholder="username" value="${pasien.username}"><br />
            <input type="text" name="nama" placeholder="nama" value="${pasien.nama}"><br />
            <input type="password" name="password" placeholder="password" value="${pasien.password}"><br />
            <input type="text" name="tempat_lahir" placeholder="tempatLahir" value="${pasien.tempatLahir}"><br />
            <input type="date" name="tanggal_lahir" placeholder="tanggalLahir" value="${pasien.tanggalLahir}"><br />
            <select name="jenisKelamin" value="${pasien.jenisKelamin}">
                <option name="jenisKelamin" value="Pria">Pria</option>
                <option name="jenisKelamin" value="Wanita">Wanita</option>
            </select><br />
            <select name="status" value="${pasien.status}">
                
                <option name="status" value="Menikah">Menikah</option>
                <option name="status" value="Belum Menikah">Belum Menikah</option>
            </select><br />
            <input type="text" name="pekerjaan" placeholder="Pekerjaan" value="${pasien.pekerjaan}" ><br />
            <input type="text" name="nomorTelp" placeholder="Nomor Telepon" value="${pasien.nomorTelepon}"><br />
            <textarea name="alamat" placeholder="Alamat" value="${pasien.alamat}"></textarea><br />
            <input type="text" name="foto" placeholder="Foto" value="${pasien.foto}"><br />
            
            <input type="submit" name="action" value="daftar">
            <input type="reset" Value="Clear">
        </form>
    </body>
</html>
