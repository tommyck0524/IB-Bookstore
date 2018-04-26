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
        <a href="">Home</a>
         <a href="browse">Browse Books</a>
          <%if(session.getAttribute("username")!=null){%>
            <a href="logout">Logout</a>
            
            <%}else{%>
           <a href="login">Login</a>
            <%}%>
         <a href="register">Register</a>
         <hr>            
            <%if(session.getAttribute("username")!=null){%>
            Welcome to IB Book Store,
            <%=session.getAttribute("username")%>
            !
            <%}else{%>
            Welcome to IB Book Store, Guest!
            <%}%>
                         
    </body>
   
</html>
