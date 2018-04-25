<%-- 
    Document   : home
    Created on : Apr 22, 2018, 2:41:25 PM
    Author     : hochikeung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="topnav">
         <a href="">Home</a>
         <a href="browse">Browse Books</a>
         <a href="purchase">Purchase Books</a>
         <a href="login">Login</a>
         <a href="register">Register</a>

         </div>   
        <div class ="greeting">
            <%if(request.getRemoteUser()!=null){%>
            Welcome to IB Book Store,
            <%=request.getRemoteUser()%>
            !
            <%}else{%>
            Welcome to IB Book Store, Guest!
            <%}%>
         </div>
                         
    </body>
   
</html>
