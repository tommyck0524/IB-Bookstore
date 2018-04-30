<%-- 
    Document   : refund
    Created on : Apr 28, 2018, 6:15:00 PM
    Author     : hochikeung
--%>

<%@page import="bookstore.JavaBeans.UserBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<title>Refund</title>
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
 <c:forEach var="purchase" items="${PBList}">
        <a href="#0" class="cd-cart">
		<span>0</span>
	</a>

	<ul class="cd-gallery">
		<li>
			<div class="cd-single-item">
				<a href="#0">
					<ul class="cd-slider-wrapper">
						<li><img src="img/thumb-1.jpg" alt="Preview image"></li>
						<li class="selected"><img class="product" src="https://images-na.ssl-images-amazon.com/images/I/916RAIVJSBL.jpg" alt="Preview image"></li>
						<li><img src="img/thumb-3.jpg" alt="Preview image"></li>
					</ul>
				</a>

				<div class="cd-customization">
					<div class="color selected-2" data-type="select">
						<ul>
							<li class="color-1">color-1</li>
							<li class="color-2 active">color-2</li>
							<li class="color-3">color-3</li>
						</ul>
					</div>
					
					<div class="size" data-type="select">
						<ul>
							<li class="small active">Small</li>
							<li class="medium">Medium</li>
							<li class="large">Large</li>
						</ul>
					</div>

					<button class="add-to-cart">
						<em>Add to Cart</em>
						<svg x="0px" y="0px" width="32px" height="32px" viewBox="0 0 32 32">
							<path stroke-dasharray="19.79 19.79" stroke-dashoffset="19.79" fill="none" stroke="#FFFFFF" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" d="M9,17l3.9,3.9c0.1,0.1,0.2,0.1,0.3,0L23,11"/>
						</svg>
					</button>
				</div> <!-- .cd-customization -->

				<button class="cd-customization-trigger">Customize</button>
			</div> <!-- .cd-single-item -->

			<div class="cd-item-info">
                            
                            <form method="POST" action="refundReceipt">
				Purchase ID:${purchase.PID}
				User ID:${purchase.UID}
                                Book ID:${purchase.BID}
                                <input type="hidden" name="PID" value=${purchase.PID}>
                                <input type="submit" value="Refund">
                                </form>
			</div> <!-- cd-item-info -->
		</li>
    </c:forEach>
                                   

<script src="resources/js/jquery-2.1.4.js"></script>
<script src="resources/js/main.js"></script> <!-- Resource jQuery -->
		

	</ul> <!-- cd-gallery -->
</div>
<!-- ####################################################################################################### -->
    </body>
</html>
