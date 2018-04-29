/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Manager;

import bookstore.JavaBeans.BookBean;
import bookstore.JavaBeans.Transaction;
import bookstore.dao.bookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
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
public class bookManagementPage extends HttpServlet {

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
        bookDao book = new bookDao(dbuser, dbpw, dburl);
        String action = request.getParameter("action");
        String bookName = request.getParameter("bookname");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String picture = request.getParameter("picture");
        
        if (action != null && action.equals("add")) {

            book.addBook(bookName, quantity, description, price, picture);

        }
        if (action != null && action.equals("modify")) {
            book.updateBookInfo(bookName, quantity, description, price, picture);
        }
        if (action != null && action.equals("delete")) {
            book.deleteBook(bookName);
        }
        try {
            ;
            //BookBean book = new BookBean(1,"HARRY", "https://images-na.ssl-images-amazon.com/images/I/51E7NvVLO9L._SX346_BO1,204,203,200_.jpg" );
            //BookBean book2 = new BookBean(2,"HARRY2", "https://images-na.ssl-images-amazon.com/images/I/51E7NvVLO9L._SX346_BO1,204,203,200_.jpg");

            List<BookBean> bookList = book.retriveBookList();
            //List<BookBean> bookList = new ArrayList<BookBean>();
            //bookList.add(book);
            //bookList.add(book2);
            request.setAttribute("bookList", bookList);
            request.setAttribute("test", "test");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/bookManagement.jsp");
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
