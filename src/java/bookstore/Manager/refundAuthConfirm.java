/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Manager;

import bookstore.JavaBeans.RefundRequestBean;
import bookstore.dao.purchaseHistoryDao;
import bookstore.dao.refundRequestDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hochikeung
 */
public class refundAuthConfirm extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String dbuser = getServletContext().getInitParameter("dbuser");
        String dbpw = getServletContext().getInitParameter("dbpw");
        String dburl = getServletContext().getInitParameter("dburl");
        HttpSession session = request.getSession();
        String RID = request.getParameter("RID");
        String PID = request.getParameter("PID");
        try{
        refundRequestDao rrd = new refundRequestDao(dburl,dbuser,dbpw);
        purchaseHistoryDao phd = new purchaseHistoryDao(dburl,dbuser,dbpw);
        rrd.deleteRequest(RID);
        phd.deleteRequest(PID);
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/refundAuthorizationConfirm.jsp");
        dis.forward(request, response);
        } catch (ClassNotFoundException e) {
           out.println("<div style='color: red'>" + e.toString() + "</div>");
        } catch (SQLException e) {
           out.println("<div style='color: red'>" + e.toString() + "</div>");
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
