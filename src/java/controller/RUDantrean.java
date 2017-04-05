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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Antrean;
import service.AntreanFacade;

/**
 *
 * @author Yafia
 */
@WebServlet(name = "RUDantrean", urlPatterns = {"/RUDantrean"})
public class RUDantrean extends HttpServlet {

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
            String id_antrean = request.getParameter("e");
            Integer id = Integer.parseInt(id_antrean);
            Antrean p = af.find(id);
            request.setAttribute("p", p);
        } else if (request.getParameterMap().containsKey("d")) {

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                String id_antrean = request.getParameter("d");
                Integer id = Integer.parseInt(id_antrean);
                Antrean a = af.find(id);
                af.remove(a);
            }
            String url = request.getContextPath() + "/listAntrean.jsp";
//      response.sendRedirect(url);
        } else {
            List<Antrean> la = af.findAll();
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
        String id_antrean = request.getParameter("id");
        Integer id = Integer.parseInt(id_antrean);
        String username = request.getParameter("username");
        String nomor_antrean = request.getParameter("nomor");
        int nomor = Integer.parseInt(nomor_antrean);
        String tanggal_antrean = request.getParameter("tanggal_antrean");
        String status = request.getParameter("status");
        String keluhan = request.getParameter("keluhan");
        
        Antrean antrean = new Antrean(id,username, nomor, tanggal_antrean, status, keluhan);
        
        af.edit(antrean);

        try (PrintWriter out = response.getWriter()) {
            out.println(id);
            out.println(username);
            out.println(nomor);
            out.println(tanggal_antrean);
            out.println(status);
            out.println(keluhan);
        }
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
