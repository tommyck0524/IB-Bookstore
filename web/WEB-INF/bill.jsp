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
        <title>Bill</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="resources/styles/bill.css">
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
            <div class="container">  
                <form id="contact" action="confirmBill" method="post">
       
                    <c:forEach var="item" items="${transactionList}">

                    </c:forEach>
                    <h3>Total:${total}</h3>
                    <h4>Please enter information below</h4>
                    <fieldset>
                        <input placeholder="Name" name="name" type="text" tabindex="1" required autofocus value=${name}>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Email" name="email" type="email" tabindex="2" required value=${email} >
                    </fieldset>
                    <fieldset>
                        <input placeholder="Credit card number" type="tel" tabindex="3" required>
                    </fieldset>
                    <fieldset>
                        <input placeholder="Your Phone number (optional)" type="text" tabindex="4" >
                    </fieldset>
                    <fieldset>
                        <textarea placeholder="Type your message here...." tabindex="5" required></textarea>
                    </fieldset>
                    <fieldset>
                        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                    </fieldset>
                    <input type="hidden" name="email" value=${email}
                </form>
            </div>



        </div>
        <!-- ####################################################################################################### -->
    </body>
</html>
