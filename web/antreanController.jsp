<%-- 
    Document   : antreanController
    Created on : Apr 3, 2017, 2:41:02 PM
    Author     : Dytra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script src="assets/jquery-3.2.0.min.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>Admin Panel!</h1>
    <%@ page import="javax.ejb.EJB, service.AntreanFacade, controller.api ,model.Antrean, java.util.ArrayList, java.util.List, javax.persistence.EntityManager, javax.persistence.Query, controller.AntreanInfo" %>

    <h2 id="currentNomorAnntrean">
      <jsp:include page="/AntreanInfo" />
      <c:out value="${currentAntrean}"></c:out>
    </h2>

    <jsp:include page="/SessionManager?admin=1" />
    <form action="AntreanManager" method="post">
      <input type="submit" id="next" name="next" value="Next">
      <input type="submit" id="skip" name="skip" value="Skip">
    </form>

    <script>
      $('#next').click(function () {
        var jqxhr = $.ajax("AntreanManager?a=next")
                .done(function (text) {
                  alert(text);
                  if (text == "habis") {
                    $('#currentNomorAnntrean').text("habis");
                  } else {
                    var antrean = text.split('#');
                    var nomorAntrean = antrean[2];
                    $('#currentNomorAnntrean').text(nomorAntrean);
                  }
                })
                .fail(function () {
                  alert("error");
                })
                .always(function () {
                  console.log("success ajax request");
                });
        return false;
      });

      $('#skip').click(function () {
        var jqxhr = $.ajax("AntreanManager?a=skip")
                .done(function (text) {
                  if (text == "habis") {
                    $('#currentNomorAnntrean').text("habis");
                  } else {
                    var antrean = text.split('#');
                    var nomorAntrean = antrean[2];
                    $('#currentNomorAnntrean').text(nomorAntrean);
                  }
                })
                .fail(function () {
                  alert("error");
                })
                .always(function () {
                  console.log("success ajax request");
                });
        return false;
      });


    </script>
  </body>
</html>
