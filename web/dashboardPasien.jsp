<%-- 
    Document   : dashboardPasien
    Created on : Apr 5, 2017, 9:11:57 AM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard | Klinik Online</title>
    <script src="assets/jquery-3.2.0.min.js" type="text/javascript"></script>

  </head>
  <%@page import="javax.servlet.http.HttpSession" %>

  <jsp:include page="/SessionManager" />
  <% String username =  request.getAttribute("username").toString();
 
  %>


  <jsp:include page="/DashboardPasienControl?u=${username}" />
  <body>
    <h1>Dashboard</h1>
    <table id="infoBox">
      <tr>
        <th>Tanggal Mengantre</th>
        <th>Total Antrean</th>
        <th>Sedang Diperiksa</th>
        <th>Nomor Antrean</th>
        <th>Sisa Antrean</th>
      </tr>
      <tr>


        <td id="tanggalMengantre"><%= request.getAttribute("tanggalMengantre") %></td>
        <td id="totalAntrean"><%= request.getAttribute("totalCurrentAntrean") %></td>
        <td id="nomorDiperiksa"><%= request.getAttribute("nomorDiperiksa") %></td>
        <td id="nomorAntrean"><%= request.getAttribute("nomorAntrean") %></td>
        <td id="sisaAntrean"><%= request.getAttribute("sisaAntrean") %></td>

      </tr>
    </table>
    <p id="pesan"></p>
    <a href="Logout">Logout</a>
    <script>
      function LoopForever() {
        console.log("hey");
        var jqxhr = $.ajax("api?u=${username}")
                .done(function (text) {
                  var antrean = text.split('#');
                  var sisaAntrean = antrean[4];
                  $('#sisaAntrean').text(sisaAntrean);
                  $('#tanggalMengantre').text(antrean[1]);
                  $('#totalAntrean').text(antrean[2]);
                  $('#nomorDiperiksa').text(antrean[3]);
                  $('#nomorAntrean').text(antrean[0]);
                  console.log(text);
                  if (sisaAntrean == 0) {
                    $('#pesan').text("Giliran Anda mengantre!");
                    console.log("sudah 0!");
                  } else if (sisaAntrean <= 0) {
                    $('#pesan').text("Anda sudah mengantre!");
                    console.log("sudah selesai mengantre!");
                    $('#infoBox').hide();
                  }
                   else {
                    console.log("belum 0,sisaAntrean =" + sisaAntrean);
                  }
                })
                .fail(function () {
//                  alert("error");
                })
                .always(function () {
                  console.log("success ajax request");
                });
      }
      var interval = self.setInterval(function () {
        LoopForever()
      }, 1000);
    </script>
  </body>
</html>
