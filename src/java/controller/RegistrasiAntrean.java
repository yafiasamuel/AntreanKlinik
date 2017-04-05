/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Antrean;
import service.AntreanFacade;

/**
 *
 * @author Dytra
 */
public class RegistrasiAntrean extends HttpServlet {

  @EJB
  AntreanFacade af;

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
    HttpSession session = request.getSession();
    String username = session.getAttribute("username").toString();
    String status = "";
    try (PrintWriter out = response.getWriter()) {
      
      String tanggalAntrean = request.getParameter("tanggalAntrean");
      String keluhan = request.getParameter("keluhan");
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet RegistrasiAntrean</title>");
      out.println("</head>");
      out.println("<body>");
      //jika sudah mendaftar
      if (af.getNumberOfAntreanByUser(username) >= 1) {
        out.println("<h1>Anda telah mendaftar!</h2>");
      } else {
        if(af.getAntreanByTanggal(tanggalAntrean) == 0) {
          status = "diperiksa";
        } else {
          status = "mengantre";
        }
        int nomorAntrean = af.generateNomorAntrean(tanggalAntrean) + 1;
        Antrean antrean = new Antrean(username, nomorAntrean, tanggalAntrean, status, keluhan);
        af.create(antrean);
        out.println("<h1>Terima Kasih Telah Mendaftar </h1>");
      }
      out.println(username);
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
