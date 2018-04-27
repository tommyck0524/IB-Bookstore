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
<title>IB_Bookstore</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
<script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.cycle.min.js"></script>
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

          <%if(session.getAttribute("username")!=null ){%>    
            <li class="last"><a href="logout">Logout</a>
            <%}else{%>
           <li class="last"><a href="login">Login</a>
            <%}%>
        <%if(session.getAttribute("username")!=null ){%>  
        <%String userrole = (String)session.getAttribute("userrole");%>
        <%if(userrole.equals("customer")){%> 
        <li><a href="#"> Member area</a>
          <ul>
            <li><a href="#"> Request for refund</a></li>
            <li><a href="#"> Account information</a></li>
          </ul>
        </li>
        <%}%>
        <%if(userrole.equals("admin")){%> 
        <li><a href="#"> Adminstration </a>
          <ul>
            <li><a href="#">Book Management</a></li>
            <li><a href="#">Authorize refund request</a></li>
          </ul>
        </li>
        <%}%>
         
        <li><a href="customer/purchase"> Purchase book </a>
            <%}%>
        <li class="active"><a href="browse">Browse a book</a>
        <li ><a href="home">Homepage</a>
      </ul>
       
      
    </div>
    <div id="logo">
                  
      <h1><a href="index.html"><strong>O</strong>p <strong>B</strong>ookStore</a></h1>
    </div>
    <br class="clear" />
  </div>
        
</div>
<div class="wrapper col3">
 <c:forEach var="book" items="${bookList}">
        <tr>
            <td> ${book.bookId} <td>
            <td> ${book.bookName} <td>
        </tr>
        
    </c:forEach>
</div>
<!-- ####################################################################################################### -->
    </body>
</html>
