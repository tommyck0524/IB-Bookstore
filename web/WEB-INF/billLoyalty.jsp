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
<title>Bill Loyalty</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/styles/purchase_util.css">
<link rel="stylesheet" type="text/css" href="resources/styles/purchase_main.css">
<link rel="stylesheet" type="text/css" href="resources/styles/purchase_reboot.scss">
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
            <div class="container">  
                <form id="contact" action="ConfirmBillLoyalty" method="post">
       
                    <h3>Total:${total}</h3>
                    <h4>Please be reminded that item purchased with loyalty points cannot be refunded</h4>         
                    <fieldset>
                        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                    </fieldset>
                    <input type="hidden" name="email" value=${email}
                </form>
            </div>

        </div>       
            <jsp:include page="footer.jsp" />
        <!-- ####################################################################################################### -->
    </body>
</html>
