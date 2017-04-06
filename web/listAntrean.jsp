
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Antrean, java.util.List" %>

    <h1>Antrean List</h1>
    <jsp:include page="/RUDantrean" />

    <table class="ui celled table" border="1">
      <thead>
      <tr>
        <th>ID Antrean</th>
        <th>Username</th>
        <th>Nomor Antrean</th>
        <th>Tanggal Antrean</th>
        <th>Status</th>
        <th>Keluhan</th>
        <th colspan="2">Action</th>
      </tr>
      </thead>
      <c:forEach var="u" items="<%= request.getAttribute("ole") %>">
        <tbody>
        <tr>
          <td>${u.getIdAntrean()}</td>
          <td>${u.getUsername()}</td>
          <td>${u.getNomorAntrean()}</td>
          <td>${u.getTanggalAntrean()}</td>
          <td>${u.getStatus()}</td>
          <td>${u.getKeluhan()}</td>
          <td><a class="ui blue button" href="/AntreanKlinik/edit_antrean.jsp?e=${u.getIdAntrean()}"><i class="edit icon"></i></td>
          <td><a class="ui red button" href="/AntreanKlinik/RUDantrean?d=${u.getIdAntrean()}"><i class="remove icon"></i></td>
          
        </tr>
      </tbody>
      </c:forEach>
    </table>
    <a href="input_antrean.jsp" class="ui green button"><i class="plus icon"></i>Tambah Antrean</a>

