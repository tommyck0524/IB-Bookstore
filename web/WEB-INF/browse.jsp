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
 <c:forEach var="book" items="${bookList}">
        <a href="#0" class="cd-cart">
		<span>0</span>
	</a>

	<ul class="cd-gallery">
		<li>
			<div class="cd-single-item">
				<a href="#0">
					<ul class="cd-slider-wrapper">
						
						<li class="selected"><img class="product" src=${book.picture}></li>
						
					</ul>
				</a>

				

				<button class="cd-customization-trigger">Customize</button>
			</div> <!-- .cd-single-item -->

			<div class="cd-item-info">
				<b>${book.bookName}</b>
				<em> $${book.price}</em>
			</div> <!-- cd-item-info -->
                        <form action="browse" method="post">
                            <input type="hidden" name ="bookname" value=${book.bookName}>
                            <input type="hidden" name ="price" value=${book.price}> 
                            <p> quantity<input type="text" name="quantity"></p>
                            <button type="submit" value="add to chart"> add to chart </button>
                        </form>
		</li>
    </c:forEach>
      
<script src="resources/js/jquery-2.1.4.js"></script>
<script src="resources/js/main.js"></script> <!-- Resource jQuery -->
		

	</ul> <!-- cd-gallery -->
</div>
<!-- ####################################################################################################### -->
    </body>
</html>
