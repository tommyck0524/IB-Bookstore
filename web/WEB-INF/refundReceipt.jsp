<%-- 
    Document   : refundReceipt
    Created on : Apr 22, 2018, 2:45:15 PM
    Author     : hochikeung
--%>

<%@page import="bookstore.JavaBeans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Refund Receipt</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
<script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.cycle.min.js"></script>
<script type="text/javascript">
$(function() {
    $('#featured_slide').after('<div id="fsn"><ul id="fs_pagination">').cycle({
        timeout: 5000,
        fx: 'fade',
        pager: '#fs_pagination',
        pause: 1,
        pauseOnPagerHover: 0
    });
});
</script>
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
            <li><a href="#">Book Management</a></li>
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
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="featured_slide">
    <div class="featured_box">
    

      <img src="resources/img/slideshow1.jpg" alt="" /> </div>
    <div class="featured_box">
      <
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
  </div>
</div>
        <h1>Your request with ID ${rrb.RID} is sent to manager for processing.</h1>
        Purchase ID: ${rrb.PID}
        <a href="home">Return to home page.</a>
    </body>
</html>
