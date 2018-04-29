/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.JavaBeans.BookBean;
import bookstore.JavaBeans.Transaction;
import bookstore.dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bookstore.dao.bookDao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hochikeung
 */
public class browseBookPage extends HttpServlet {

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
        String bookName = request.getParameter("bookname");
        String price_param = request.getParameter("price");
        String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpw = getServletContext().getInitParameter("dbpw");
            String dburl = getServletContext().getInitParameter("dburl");
        String purchaseQuantity_param = request.getParameter("quantity");
     
        if(bookName!=null && bookName!="" && purchaseQuantity_param!=null && !(purchaseQuantity_param.equals(""))) {
            Double price =  Double.parseDouble(price_param); 
            int purchaseQuantity = Integer.parseInt(purchaseQuantity_param); 
             HttpSession session = request.getSession();
             List<Transaction> transactionList = (List<Transaction>) session.getAttribute("transactionList");
             if(transactionList==null) {
                  transactionList = new ArrayList<>();
             } 
             Timestamp timestamp = new Timestamp(System.currentTimeMillis());              
             int transactionId = (int)timestamp.getTime();               
             Transaction tr = new Transaction(transactionId,bookName,price,purchaseQuantity);               
             transactionList.add(tr);
                         
             session.setAttribute("transactionList", transactionList);
        }
            try {
                     bookDao bookDao = new bookDao(dbuser, dbpw, dburl);;
                     //BookBean book = new BookBean(1,"HARRY", "https://images-na.ssl-images-amazon.com/images/I/51E7NvVLO9L._SX346_BO1,204,203,200_.jpg" );
                     //BookBean book2 = new BookBean(2,"HARRY2", "https://images-na.ssl-images-amazon.com/images/I/51E7NvVLO9L._SX346_BO1,204,203,200_.jpg");

                     List<BookBean> bookList = bookDao.retriveBookList();
                     //List<BookBean> bookList = new ArrayList<BookBean>();
                     //bookList.add(book);
                     //bookList.add(book2);
                     request.setAttribute("bookList", bookList);
                     request.setAttribute("test", "test");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/browse.jsp");
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
