/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dytra
 */
public class SessionManager extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session;

    session = request.getSession();
    if (session.getAttribute("username") == null) { //jika blum login
      response.sendRedirect("login.jsp");
      try (PrintWriter out = response.getWriter()) {
        out.print("<script>alert('belum login!');</script>");
        out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://localhost:8080/AntreanKlinik/login.jsp\">");
      }
    } else {
      if (request.getParameterMap().containsKey("admin")) { //jka membuka halaman admin
        if (!session.getAttribute("username").equals("admin")) { //jka yg login bukan admin
          try (PrintWriter out = response.getWriter()) {
            out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://localhost:8080/AntreanKlinik/lobbyPasien.jsp\">"); //redirect ke halaman lobby
          }
        }
      } else {

        request.setAttribute("username", session.getAttribute("username"));
      }
    }

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
