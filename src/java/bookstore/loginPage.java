/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import Models.LoginModel;
import bookstore.JavaBeans.UserBean;
import bookstore.dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class loginPage extends HttpServlet {

        
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
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dbuser = getServletContext().getInitParameter("dbuser");
        String dbpw = getServletContext().getInitParameter("dbpw");
        String dburl = getServletContext().getInitParameter("dburl");

        String status = (String) request.getParameter("redirect");
        if(status!=null)
        if (status.equals("redirect")) {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/login.jsp");
            dis.forward(request, response);
        }
           
            

        try {
            userDao userdao = new userDao(dburl,dbuser,dbpw);
            boolean valid = userdao.userIsValid(username, password);

            if (valid) {
                String role = userdao.checkRole(username);
                HttpSession session = request.getSession();
                String UID = userdao.getAttribute("UID",username);
                String email = userdao.getAttribute("email",username);
                UserBean userbean = new UserBean(UID,username,password,role,email);
                session.setAttribute("userbean",userbean);
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/home.jsp");
                dis.forward(request, response);
            } else {
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/loginerror.jsp");
                dis.forward(request, response);
            }
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
