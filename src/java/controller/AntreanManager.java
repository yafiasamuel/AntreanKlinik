/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Antrean;
import service.AntreanFacade;

public class AntreanManager extends HttpServlet {

  @EJB
  AntreanFacade af;
  List<Antrean> la;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

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
    response.setContentType("text/html;charset=UTF-8");
    //get parameter
    String a = request.getParameter("a");

    //get session_username
    HttpSession session = request.getSession();
    String username = session.getAttribute("username").toString();

    //getCurrentAntrean
    try (PrintWriter out = response.getWriter()) {
      if (a.equals("next")) {

        beforeEdit(username);
        afterEdit(username);

        Antrean currentAntrean = la.get(0);
        la = af.getCurrentAntrean();
        
        out.print(currentAntrean.getIdAntrean() + "#");
        out.print(currentAntrean.getUsername() + "#");
        out.print(currentAntrean.getNomorAntrean() + "#");
        out.print(currentAntrean.getTanggalAntrean() + "#");
        out.print(currentAntrean.getStatus() + "#");
        out.print(currentAntrean.getKeluhan());
      } else if(a.equals("skip")) {
        Antrean antrean = (Antrean) af.getSingleCurrentAntrean();
        antrean.setStatus("skip");
        //ubah status ke skip
        af.edit(antrean);
        //ubah antrean selanjutnya mejadi diperiksa
        afterEdit(username);
        //tampilkan antrean sekarang
        antrean = (Antrean) af.getSingleCurrentAntrean();
        out.print(antrean.getIdAntrean() + "#");
        out.print(antrean.getUsername() + "#");
        out.print(antrean.getNomorAntrean() + "#");
        out.print(antrean.getTanggalAntrean() + "#");
        out.print(antrean.getStatus() + "#");
        out.print(antrean.getKeluhan());
        
        
        
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
    try (PrintWriter out = response.getWriter()) {

      if (request.getParameter("skip").equals("Skip")) {
        out.println("skiping");
      }
    }
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

  private int beforeEdit(String username) {

    //getcurrent antrean from api
    la = af.getCurrentAntrean();
    Antrean currentAntrean = la.get(0);
    Integer idAntrean = currentAntrean.getIdAntrean();
    //object edit
    Antrean editAntrean = new Antrean();
    editAntrean.setIdAntrean(idAntrean);
    editAntrean.setKeluhan(currentAntrean.getKeluhan());
    editAntrean.setNomorAntrean(currentAntrean.getNomorAntrean());
    editAntrean.setTanggalAntrean(currentAntrean.getTanggalAntrean());
    editAntrean.setUsername(currentAntrean.getUsername());
    editAntrean.setStatus("selesai");

//    begin edit
    af.edit(editAntrean);
    return (editAntrean.getIdAntrean());
  }

  private int afterEdit(String username) {
    //getcurrent antrean from api
    la = af.getAllCurrentAntrean();

    Antrean currentAntrean = la.get(0);
    Integer idAntrean = currentAntrean.getIdAntrean();

    //object edit
    Antrean editAntrean = new Antrean();
    editAntrean.setIdAntrean(idAntrean);
    editAntrean.setKeluhan(currentAntrean.getKeluhan());
    editAntrean.setNomorAntrean(currentAntrean.getNomorAntrean());
    editAntrean.setTanggalAntrean(currentAntrean.getTanggalAntrean());
    editAntrean.setUsername(currentAntrean.getUsername());
    editAntrean.setStatus("diperiksa");
//    begin edit
    af.edit(editAntrean);
    return idAntrean;
  }
  
  private int periksaEdit(String username) {
    //getcurrent antrean from api
    la = af.getAllCurrentAntrean();

    Antrean currentAntrean = la.get(0);
    Integer idAntrean = currentAntrean.getIdAntrean();

    //object edit
    Antrean editAntrean = new Antrean();
    editAntrean.setIdAntrean(idAntrean);
    editAntrean.setKeluhan(currentAntrean.getKeluhan());
    editAntrean.setNomorAntrean(currentAntrean.getNomorAntrean());
    editAntrean.setTanggalAntrean(currentAntrean.getTanggalAntrean());
    editAntrean.setUsername(username);
    editAntrean.setStatus("diperiksa");
//    begin edit
    af.edit(editAntrean);
    return idAntrean;
  }

}
