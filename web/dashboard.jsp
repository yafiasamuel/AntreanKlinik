<%-- 
    Document   : dashboard
    Created on : Mar 29, 2017, 7:41:01 AM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard Pasien | Klinik Online</title>
  </head>
  <body>
    <%

      String sessionUsername = session.getAttribute("username").toString();
    %>
    <h1>Hello <% out.println(sessionUsername); %></h1>
  </body>
</html>
