<%-- 
    Document   : registrasiAntrean
    Created on : Mar 28, 2017, 9:21:57 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Daftar Antrean</title>
    <link rel="stylesheet" href="assets/semantic.min.css" />

  </head>
  <body style="background: #eceaea;margin-top:3em">
    <div class="main ui stackable centered page grid">
      <form action="RegistrasiAntrean" method="post" class="ui form column eight wide segment">
        <h1>Daftar Antrean</h1>
        <div class="field">
          <label>Tanggal Antrean</label>
          <input type="date" name="tanggalAntrean" /> 
        </div>
        <div class="field">
          <label>Keluhan</label>
          <textarea name="keluhan"> 
          </textarea>
        </div>
        <div class="field ui centered page grid">
        <input type="submit" name="submit" class="fluid ui huge blue button" value="Daftar Antrean" />
      </div>
      </form>
    </div>
  </body>
</html>
