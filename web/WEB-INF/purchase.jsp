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
<title>Purchase</title>
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
 
            <div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
                            <div class="table100 ver5 m-b-110">
                                                              <div class="table100-head">
                                                                      <table>
                                                                              <thead>
                                                                                      <tr class="row100 head">
                                                                                              <th class="cell100 column1">Book name</th>
                                                                                              <th class="cell100 column2">Price</th>
                                                                                              <th class="cell100 column3">Quantity</th>
                                                                                              <th class="cell100 column4">Total</th>
                                                                                              <th class="cell100 column5">Cancel</th>
                                                                                      </tr>
                                                                              </thead>
                                                                      </table>
                                                              </div>                                                             
                                                              <div class="table100-body js-pscroll">
                                                                      <table>
                                                                        


                                                                               <tbody>
                                                                                      <c:forEach var="item" items="${transactionList}">
                                                                                      <tr class="row100 body">
                                                                                              <td class="cell100 column1">${item.bookName}</td>
                                                                                              <td class="cell100 column2">${item.price}</td>
                                                                                              <td class="cell100 column3">${item.purchaseQuantity}</td>
                                                                                              <td class="cell100 column4"> ${item.total}</td>
                                                                                              <td class="cell100 column5">
                                                                                                  <form action="purchase" method="post">
                                                                                                      <input type="hidden" name="transactionId" value=${item.transactionId}>
                                                                                                      <input type="hidden" name="cancel" value="1">
                                                                                                      <button type="submit" value="cancel" >cancel</button>
                                                                                                  </form>
                                                                                                  
                                                                                              </td>
                                                                                              
                                                                                      </tr>
                                                                                       </c:forEach>


                                                                              </tbody>



                                                                      </table>
                                                              </div>
                            </div>
                        </div>
                </div>
                <div class="bot-container">
                    <form action="bill" method="post">
                        <button class="button" type="submit" value="Submit">Purchase now</button>
                    </form>
                    <form action="billLoyalty" method="post">
                        <button class="button" type="submit" value="Submit">Purchase with Loyality points</button>
                    </form>
                </div>
            </div>
 

</div>
<!-- ####################################################################################################### -->
            <jsp:include page="footer.jsp" />
    </body>
</html>
