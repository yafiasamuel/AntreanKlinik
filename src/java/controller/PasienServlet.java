/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PasienDAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author ChrisTz
 */
@WebServlet(name = "PasienServlet", urlPatterns = {"/PasienServlet"})
public class PasienServlet extends HttpServlet {
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
    System.out.println("hello");
    String action = request.getParameter("action");
      
    String nama = request.getParameter("nama");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String tempatLahir = request.getParameter("tempatLahir");
    String tanggalLahir = request.getParameter("tanggalLahir");
    String jenisKelamin = request.getParameter("jenisKelamin");
    String status = request.getParameter("status");
    String pekerjaan = request.getParameter("pekerjaan");
    String nomorTelepon = request.getParameter("nomorTelepon");
    String alamat = request.getParameter("alamat");
    String foto = request.getParameter("foto");
    
    Pasien pasien = new Pasien(username, nama, password, tempatLahir, tanggalLahir, jenisKelamin, status, pekerjaan, nomorTelepon, alamat, foto);
//    PasienFacade pf = new PasienFacade();
    if("daftara".equalsIgnoreCase(action)){
    pf.create(pasien);
//      pf.create(pasien);
    }
    else if("Edit".equalsIgnoreCase(action)) {
      pf.edit(pasien);
    }
    else if("Delete".equalsIgnoreCase(action)) {
      pf.remove(pasien);
    }
    request.setAttribute("pasien", pasien);
    //request.setAttribute("allPasien", pasienDao.getAllPasien());
    request.getRequestDispatcher("register.jsp").forward(request, response);
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
