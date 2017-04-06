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
    <link rel="stylesheet" href="assets/semantic.min.css" />
  </head>
  <%@page import="javax.servlet.http.HttpSession" %>

  <jsp:include page="/SessionManager" />
  <% String username =  request.getAttribute("username").toString();
 
  %>


  <jsp:include page="/DashboardPasienControl?u=${username}" />

  <body style="background: #eceaea">
    <div class="ui grid">
      <div class="twelve wide centered column">
        <h1>Dashboard</h1>
        <div class="ui success icon message">
          <i class="checkmark icon"></i>
          <div class="content">
            <div class="header">
              Have you heard about our mailing list?
            </div>
            <p>Get the best news in your e-mail every day.</p>
          </div>
        </div>
        <div id="infoBox" class="ui three column grid">
          <p id="pesan"></p>
          <div class="row">
            <div class="ui column pink segment">
              <h2><p id="tanggalMengantre"><%= request.getAttribute("tanggalMengantre") %></p></h2>
              <em>Tanggal Mengantre</em>
            </div>
            <div class="ui column orange segment">
              <h2><p id="totalAntrean"><%= request.getAttribute("totalCurrentAntrean") %></p></h2>
              <em>Total Antrean</em>
            </div>
            <div class="ui column green segment">
              <h2><p id="nomorDiperiksa"><%= request.getAttribute("nomorDiperiksa") %></p></h2>
              <em>Diperiksa</em>
            </div>
          </div>
        </div>
        <div class="ui three column grid">
          <div class="row">
            <div class="ui column teal segment">
              <h2><p id="nomorAntrean"><%= request.getAttribute("nomorAntrean") %></p></h2>
              <em>Nomor Antrean</em>
            </div>
            <div class="ui column purple segment">
              <h2><p id="sisaAntrean"><%= request.getAttribute("sisaAntrean") %></p></h2>
              <em>Sisa Antrean</em>
            </div>
            <div class="ui column brown segment">
              <h2><p id="status"><%= request.getAttribute("status") %></p></h2>
              <em>Status</em>
            </div>


            <script>
              function LoopForever() {
                console.log("hey");
                var jqxhr = $.ajax("api?u=${username}")
                        .done(function (text) {
                          alert(text);
                          if ($('#status').text() == 'selesai') {
                            $('#infoBox').hide();
                            $('#pesan').text("Anda telah selsai mengantre, Terimakasih");
                          } else {
                            var antrean = text.split('#');
                            var sisaAntrean = antrean[4];
                            $('#sisaAntrean').text(sisaAntrean);
                            $('#tanggalMengantre').text(antrean[1]);
                            $('#totalAntrean').text(antrean[2]);
                            $('#nomorDiperiksa').text(antrean[3]);
                            $('#nomorAntrean').text(antrean[0]);
                            $('#status').text(antrean[5]);
                            console.log(text);
                            if (sisaAntrean == 0) {
                              $('#pesan').text("Giliran Anda mengantre!");
                              console.log("sudah 0!");
                            } else if (sisaAntrean < 0) {
                              $('#pesan').text("Anda sudah mengantre!");
                              console.log("sudah selesai mengantre!");
                              $('#infoBox').hide();
                            } else {
                              console.log("belum 0,sisaAntrean =" + sisaAntrean);
                            }
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
          </div>
          <div class="row">
            <a href="lobbyPasien.jsp" class="ui button">Back</a>
            <a href="Logout" class="ui red button">Logout</a>
          </div>
        </div>

      </div>
    </div>
  </body>
</html>
