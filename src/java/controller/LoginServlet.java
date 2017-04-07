/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pasien;
import service.PasienFacade;

/**
 *
 * @author Dytra
 */
public class LoginServlet extends HttpServlet {

  @EJB
  private PasienFacade pf;

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

    Pasien res = pf.find(request.getParameter("username"));
    HttpSession session = request.getSession();
    session.setAttribute("username", request.getParameter("username"));
    String sessionUsername = session.getAttribute("username").toString();

    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet LoginServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
      out.println(sessionUsername);
      if (res == null) {
        out.println("it's null");
      } else {
        if (res.getPassword().equals(request.getParameter("password"))) {
          out.println("selamat datang");
          if (request.getParameter("username").equals("admin")) {
            session.setAttribute("username", request.getParameter("username"));
            out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://localhost:8080/AntreanKlinik/antreanController.jsp\">");
          } else {
            out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://localhost:8080/AntreanKlinik/lobbyPasien.jsp\">");
          }

        } else {
          out.println("username atau password salah");
        }
      }
      out.print("<br>");

      out.println("</body>");
      out.println("</html>");
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
