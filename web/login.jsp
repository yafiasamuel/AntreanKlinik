<%-- 
    Document   : login
    Created on : Mar 27, 2017, 8:48:43 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login | Klinik Online</title>
    <link rel="stylesheet" href="assets/semantic.min.css" />

  </head>
  <body style="background: #eceaea;margin-top:3em">
    <div class="main ui stackable centered page grid">
    <form action="LoginServlet" method="post" class="ui form column eight wide segment" id="formlogin">
      <h1>Login</h1>
      <div class="field">
        <input type="text" name="username" placeholder="Username..." value="" /> 
      </div>
      <div class="field">
        <input type="password" name="password" placeholder="Password..." />
      </div>
      <div class="field ui centered page grid">
        <input type="submit" class="fluid ui teal button" name="login" value="Login" />
      </div>
      <p>Belum mempunyai akun? Registrasi <a href="registrasi.jsp">disini</a></p>
    </form>
    </div>
  </body>
</html>
