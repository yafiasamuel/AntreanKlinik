/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PasienDAO;
import dao.PasienDAOLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pasien;
import service.PasienFacade;

/**
 *
 * @author Dytra
 */
@WebServlet(name = "PasienServlet", urlPatterns = {"/PasienServlet"})
public class PasienServlet extends HttpServlet {
  @EJB
  private PasienDAOLocal pasienDao;
 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String action = request.getParameter("action");
    String id_pasienStr = request.getParameter("id_pasien");
    int id_pasien = id_pasienStr.equals("") ? 0 : Integer.parseInt(id_pasienStr);
    String nama = request.getParameter("nama");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String tempat_lahir = request.getParameter("tempat_lahir");
    String tanggal_lahir = request.getParameter("tanggal_lahir");
    String jenis_kelamin = request.getParameter("jenis_kelamin");
    String status = request.getParameter("status");
    String pekerjaan = request.getParameter("pekerjaan");
    String nomor_telepon = request.getParameter("nomor_telepon");
    String alamat = request.getParameter("alamat");
    String foto = request.getParameter("foto");
    
    Pasien pasien = new Pasien(id_pasien, nama, username, password, tempat_lahir, tanggal_lahir, jenis_kelamin, status, pekerjaan, nomor_telepon, alamat, foto);
//    PasienFacade pf = new PasienFacade();
    if(action.equalsIgnoreCase("Add")){
      pasienDao.addPasien(pasien);
//      pf.create(pasien);
      
    }
    else if(action.equals("Edit")) {
      pasienDao.editPasien(pasien);
    }
    else if(action.equals("Delete")) {
      pasienDao.deletePasien(id_pasien);
    } else if(action.equals("Search")) {
      pasien = pasienDao.getPasien(id_pasien);
    }
    request.setAttribute("pasien", pasien);
    request.setAttribute("allPasien", pasienDao.getAllPasien());
    request.getRequestDispatcher("pasieninfo.jsp").forward(request, response);
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
