<%-- 
    Document   : refundAuthorizationConfirm
    Created on : Apr 29, 2018, 3:53:57 PM
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
<link rel="stylesheet" href="resources/styles/browse_reset.css" type="text/css" />
<link rel="stylesheet" href="resources/styles/browse_style.css" type="text/css" />
<script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.cycle.min.js"></script>
<script src="js/modernizr.js"></script> <!-- Modernizr -->
<script type="text/javascript">
</script>
</head>
    <body id="top">
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
                  
      <h1><a href="home"><strong>O</strong>p <strong>B</strong>ookStore</a></h1>
    </div>
    <br class="clear" />
  </div>
        
</div>
        The refund request has already been authorized.
        <a href="home">Return to home page</a>
        
