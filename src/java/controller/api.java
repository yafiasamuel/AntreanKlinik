/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Antrean;
import service.AntreanFacade;

/**
 *
 * @author Dytra
 */
public class api extends HttpServlet {

  @EJB
  AntreanFacade af;

  List<Antrean> la;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    la = af.getCurrentAntrean();
    Antrean currentAntrean = la.get(0);

    try (PrintWriter out = response.getWriter()) {

      out.print(currentAntrean.getIdAntrean() + "#");
      out.print(currentAntrean.getUsername() + "#");
      out.print(currentAntrean.getNomorAntrean() + "#");
      out.print(currentAntrean.getTanggalAntrean() + "#");
      out.print(currentAntrean.getStatus() + "#");
      out.print(currentAntrean.getKeluhan());
      out.println();

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
//    request.setAttribute("result", "this is result");
//    request.getRequestDispatcher("/antreanController.jsp");
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

  public Antrean getCurrentIdAntrean() throws ServletException, IOException {
    la = af.getCurrentAntrean();
    return la.get(0);
  }

}
