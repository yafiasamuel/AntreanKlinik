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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pasien;
import service.PasienFacade;

/**
 *
 * @author Dytra
 */
public class PasienManager extends HttpServlet {

  @EJB
  PasienFacade pf;

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
    response.setContentType("text/html;charset=UTF-8");
    if (request.getParameterMap().containsKey("e")) {
      
      
      String username = request.getParameter("e");
      Pasien p = pf.find(username);
      request.setAttribute("p", p);
    }
    else if(request.getParameterMap().containsKey("d")) {
      

      response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
        String username = request.getParameter("d");
        out.print(username);
      }
      String url = request.getContextPath() + "/listPasien.jsp";
//      response.sendRedirect(url);
    } else {
      List<Pasien> la = pf.findAll();
      request.setAttribute("ole", la);
    }
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
