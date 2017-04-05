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
    <link rel="stylesheet" href="assets/main.css" />
  </head>
  <body>
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
        <input type="submit" class="fluid ui huge teal button" name="login" value="Login" />
      </div>
      
    </form>
    </div>
  </body>
</html>
