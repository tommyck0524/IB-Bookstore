/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Customer;

import bookstore.JavaBeans.BookBean;
import bookstore.JavaBeans.Transaction;
import bookstore.dao.bookDao;
import bookstore.dao.purchaseHistoryDao;
import bookstore.dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
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
public class ConfirmBillPage extends HttpServlet {

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

        try {
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpw = getServletContext().getInitParameter("dbpw");
            String dburl = getServletContext().getInitParameter("dburl");

            HttpSession session = request.getSession();
            List<Transaction> trs = (List<Transaction>) session.getAttribute("transactionList");
            purchaseHistoryDao pr = new purchaseHistoryDao(dburl,dbuser,dbpw);
            userDao user = new userDao(dburl,dbuser,dbpw);
            bookDao book = new bookDao(dbuser, dbpw, dburl);
            //gather transaction info
            String username = (String) session.getAttribute("username");
            int userId = user.getUserIdByUserName(username);
            int refund = 1;
            //
            for (Transaction tr : trs) {
                int bookId = book.getBookIdByBookName(tr.getBookName());
                int quantity = tr.getPurchaseQuantity();
                double total = tr.getTotal();
                pr.insertPurchaseRecord(userId, bookId, quantity, refund, total);
            }
            session.removeAttribute("transactionList");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/billConfirm.jsp");
            dis.forward(request, response);
        } catch (Exception e) {
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
