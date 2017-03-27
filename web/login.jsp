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
    <div class="main">
    <form action="LoginServlet" method="post" class="ui form" id="formlogin">
      <input type="text" name="username" placeholder="Username..." /> <br>
      <input type="password" name="password" placeholder="Password..." /> <br>
      <input type="submit" class="ui teal button" name="login" />
      
    </form>
    </div>
  </body>
</html>
