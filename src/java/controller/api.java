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
import model.Antrean;
import model.Pasien;
import service.AntreanFacade;

/**
 *
 * @author Dytra
 */
public class api extends HttpServlet {

  @EJB
  AntreanFacade af;

  List<Antrean> la;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = response.getWriter()) {
      if (request.getParameterMap().containsKey("u")) {
        if(af.getCurrentAntrean().size() == 0) {
          out.print("habis");
        } else {
        la = af.getCurrentAntrean();
        Antrean currentAntrean = la.get(0);
        //ambil username pada get
        String getUser = request.getParameter("u");
        //ambil tanggal mengantre user sesuai username
        Antrean antre = af.getCurrentAntreanByUsername(getUser);
        String tanggalMengantre = antre.getTanggalAntrean();
        int nomorAntrean = antre.getNomorAntrean();
        int totalCurrentAntrean = af.getTotalCurrentAntrean(tanggalMengantre);
        int nomorDiperiksa = af.getNomorDiperiksa(tanggalMengantre);
        int sisaAntrean = nomorAntrean - nomorDiperiksa;
        Antrean pasien = (Antrean) af.getCurrentAntreanByUsername(getUser);
        out.print(nomorAntrean + "#");
        out.print(tanggalMengantre + "#");
        out.print(totalCurrentAntrean + "#");
        out.print(nomorDiperiksa + "#");
        out.print(sisaAntrean + "#");
        out.print(antre.getStatus());
        
        //forward
        request.setAttribute("nomorAntrean", nomorAntrean);
        request.setAttribute("tanggalMengantre", tanggalMengantre);
        request.setAttribute("totalCurrentAntrean", totalCurrentAntrean);
        request.setAttribute("nomorDiperiksa", nomorDiperiksa);
        request.setAttribute("sisaAntrean", sisaAntrean);
        }

      } else {
//        out.print(currentAntrean.getIdAntrean() + "#");
//        out.print(currentAntrean.getUsername() + "#");
//        out.print(currentAntrean.getNomorAntrean() + "#");
//        out.print(currentAntrean.getTanggalAntrean() + "#");
//        out.print(currentAntrean.getStatus() + "#");
//        out.print(currentAntrean.getKeluhan());
//        out.println();
      }

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

  public Antrean getCurrentIdAntrean() throws ServletException, IOException {
    la = af.getCurrentAntrean();
    return la.get(0);
  }

}
