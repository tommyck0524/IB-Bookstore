<%-- 
    Document   : browse
    Created on : Apr 22, 2018, 2:42:14 PM
    Author     : hochikeung
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Purchase</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="resources/styles/purchase_util.css">
        <link rel="stylesheet" type="text/css" href="resources/styles/purchase_main.css">
        <link rel="stylesheet" type="text/css" href="resources/styles/purchase_reboot.scss">
        <script type="text/javascript">
        </script>
    </head>
    <body id="top">
        <% session.setAttribute("username", "sunny"); %>
        <% session.setAttribute("userrole", "customer"); %>
        <div class="wrapper col1">
            <div id="header">
                <div id="topnav">
                    <ul>       

                        <%if (session.getAttribute("username") != null) {%>    
                        <li class="last"><a href="logout">Logout</a>
                            <%} else {%>
                        <li class="last"><a href="login">Login</a>
                            <%}%>
                            <%if (session.getAttribute("username") != null) {%>  
                            <%String userrole = (String) session.getAttribute("userrole");%>
                            <%if (userrole.equals("customer")) {%> 
                        <li><a href="#"> Member area</a>
                            <ul>
                                <li><a href="#"> Request for refund</a></li>
                                <li><a href="#"> Account information</a></li>
                            </ul>
                        </li>
                        <%}%>
                        <%if (userrole.equals("admin")) {%> 
                        <li><a href="#"> Adminstration </a>
                            <ul>
                                <li><a href="#">Book Management</a></li>
                                <li><a href="#">Authorize refund request</a></li>
                            </ul>
                        </li>
                        <%}%>

                        <li class="active"><a href="purchase" > Purchase book </a>
                            <%}%>
                        <li><a href="browse">Browse a book</a>
                        <li ><a href="home">Homepage</a>
                    </ul>


                </div>
                <div id="logo">

                    <h1><a href="home"><strong>O</strong>p <strong>B</strong>ookStore</a></h1>
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
    </body>
</html>
