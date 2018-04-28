/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import Models.RegisterModel;
import bookstore.JavaBeans.UserBean;
import bookstore.dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class registrationPage extends HttpServlet {

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
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/register.jsp");
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String email = request.getParameter("email");
        
        String dbuser = getServletContext().getInitParameter("dbuser");
        String dbpw = getServletContext().getInitParameter("dbpw");
        String dburl = getServletContext().getInitParameter("dburl");

       if (!password.equals(confirm_password)) {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/registererror.jsp");
            dis.forward(request, response);
        }
        
        try{
        userDao userdao = new userDao();
        boolean insertSuccess = userdao.insertSuccess(username,password,email,dbuser,dbpw,dburl);
        if (insertSuccess){
                HttpSession session = request.getSession();
                String userrole = "customer";
                UserBean userbean = new UserBean(username,password,userrole);
                session.setAttribute("userbean",userbean);
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/registerSuccess.jsp");
                dis.forward(request, response);
        }else{
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/registererror.jsp");
                dis.forward(request, response);
        }
        }catch (ClassNotFoundException e) {
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
