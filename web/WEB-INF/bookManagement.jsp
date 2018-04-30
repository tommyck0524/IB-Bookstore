<%-- 
    Document   : browse
    Created on : Apr 22, 2018, 2:42:14 PM
    Author     : hochikeung
--%>
<%@page import="bookstore.JavaBeans.UserBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<title>IB_Bookstore Book Browser</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
<link rel="stylesheet" href="resources/styles/browse_reset.css" type="text/css" />
<link rel="stylesheet" href="resources/styles/browse_style.css" type="text/css" />
<script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.cycle.min.js"></script>
<script src="js/modernizr.js"></script> <!-- Modernizr -->
<script type="text/javascript">
</script>
            <jsp:include page="header.jsp" />
</head>
<body id="top">
<div class="wrapper col1">
  <div id="header">
    <div id="topnav">
     <ul>       

          <%if(session.getAttribute("userbean")!=null ){%>    
            <li class="last"><a href="logout">Logout</a>
            <%}else{%>
           <li class="last"><a href="login">Login</a>
           <li><a href="register">Register</a>
            <%}%>
            <% UserBean userbean = (UserBean)session.getAttribute("userbean");%>
        <%if(session.getAttribute("userbean")!=null){%>  
           <% String userrole = userbean.getRole();%>
        <%if(userrole.equals("customer")){%> 
        <li><a href="#"> Member area</a>
          <ul>
            <li><a href="refund"> Request for refund</a></li>
            <li><a href="#"> Account information</a></li>
          </ul>
        </li>
        <%}%>
        <%if(userrole.equals("admin")){%> 
        <li><a href="#"> Adminstration </a>
          <ul>
            <li><a href="bookManagement">Book Management</a></li>
            <li><a href="refundAuth">Authorize refund request</a></li>
          </ul>
        </li>
        <%}%>
        <li><a href="purchase"> Purchase book </a>
            <%}%>
        <li><a href="browse">Browse a book</a>
        <li class="active"><a href="home">HomePage</a>
      </ul>
       
      
    </div>
    <div id="logo">
      <h1><a href="index.html"><strong>O</strong>p <strong>B</strong>ookStore</a></h1>
    </div>
        <div>
            <%if(session.getAttribute("userbean")!=null ){%>
            <% String username = userbean.getUsername();%>
            <p>Welcome,<%=username%></p>
            <%}%>
        </div>
    <br class="clear" />
  </div>
</div>
        <div class="wrapper col3">

            <div class="limiter">
                <div class="container-table100">
                    <div class="wrap-table100">
                        <div class="table100 ver5 m-b-110">
                            <div class="table100-head">
                                <table>
                                    <thead>
                                        <tr class="row100 head">
                                            <th class="cell100 column5">Book name</th>
                                            <th class="cell100 column2">Quantity</th>
                                            <th class="cell100 column3">Description</th>
                                            <th class="cell100 column4">Price</th>
                                            <th class="cell100 column1">Picture</th>
                                            <th class="cell100 column3">Modify</th>
                                            <th class="cell100 column3">Delete</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>                                                             
                            <div class="table100-body js-pscroll">
                                <table>



                                    <tbody>
                                        <c:forEach var="book" items="${bookList}">
                                            <tr class="row100 body">
                                        <form action="bookManagement" method="post">     
                                            <td class="cell100 column5"><input class="readonly" type="text" name="bookname" readonly value=${book.bookName} ></td>
                                            <td class="cell100 column2"><input type="text" name="quantity" value=${book.quantity}></td>
                                            <td class="cell100 column3"><input type="text" name="description" value=${book.description}></td>
                                            <td class="cell100 column4"><input type="text" name="price" value=${book.price}> </td>
                                            <td class="cell100 column1"><input type="text" name="picture" value=${book.picture}> </td>
                                            <td class="cell100 column3">

                                                <input type="hidden" name="action" value="modify">
                                                <button type="submit" value="cancel" >modify</button>

                                            </td>
                                        </form>
                                        <td class="cell100 column3">
                                            <form action="bookManagement" method="post">
                                                <input type="hidden" name="bookname" value=${book.bookName}>
                                                <input type="hidden" name="action" value="delete">
                                                <button type="submit" value="submit" >delete</button>
                                            </form>

                                            </tr>
                                        </c:forEach>


                                        </tbody>



                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="limiter">
                    <div class="container-table100">
                        <div class="wrap-table100">
                            <div class="table100 ver5 m-b-110">
                                <div class="table100-head">
                                    <table>
                                        <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column5">Book name</th>
                                                <th class="cell100 column2">Quantity</th>
                                                <th class="cell100 column3">Description</th>
                                                <th class="cell100 column4">Price</th>
                                                <th class="cell100 column1">Picture</th>
                                                <th class="cell100 column3">Add</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>                                                             
                                <div class="table100-body js-pscroll">
                                    <table>



                                        <tbody>

                                            <tr class="row100 body">
                                        <form action="bookManagement" method="post">
                                            <td class="cell100 column5"><input type="text" name="bookname" ></td>
                                            <td class="cell100 column2"><input type="text" name="quantity" ></td>
                                            <td class="cell100 column3"><input type="text" name="description" ></td>
                                            <td class="cell100 column4"><input type="text" name="price" > </td>
                                            <td class="cell100 column1"><input type="text" name="picture" > </td>
                                            <td class="cell100 column3">
                                                <input type="hidden" name="action" value="add">
                                                <button type="submit" value="cancel" >Add</button>
                                            </td>
                                        </form>

                                        </tr>



                                        </tbody>



                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>


            </div>
            <!-- ####################################################################################################### -->
            <jsp:include page="footer.jsp" />
    </body>
</html>
