<%-- 
    Document   : admin
    Created on : Apr 6, 2017, 7:42:27 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Pasien, java.util.List" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin | Klinik Online</title>
    <link rel="stylesheet" href="assets/semantic.min.css" />
    <link rel="stylesheet" href="assets/main.css" />
  </head>
  <body>
    <div class="ui grid">
      <div class="four wide black column">
        <jsp:include page="antreanController.jsp" />
      </div>
      <div class="twelve wide column">
        <div class="ui secondary pointing menu">
          <a class="item" href="admin.jsp">
            Pasien
          </a>
          <a class="item" href="adminAntrean.jsp">
            Antrean
          </a>
          <div class="right menu">
            <a class="ui item" href="Logout">
              Logout
            </a>
          </div>
        </div>
        <jsp:include page="listPasien.jsp" />
      </div>
    </div>
  </body>
</html>
