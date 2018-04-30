<%-- 
    Document   : register
    Created on : Apr 22, 2018, 2:41:47 PM
    Author     : hochikeung
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registerion Error</title>
        <link rel="stylesheet" href="resources/styles/login.css" type="text/css" />
                    <jsp:include page="header.jsp" />
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <c:choose>
                <c:when test="${error=='usernameDup'}">
                    <p>This username has already been used. Please choose another one.</p>
                </c:when>
                <c:when test="${error=='emailDup'}">
                    <p>This email has already been used. Please choose another one.</p>
                </c:when>
                <c:when test="${error=='blankfield'}">
                    <p>Not all fields are filled in. Please check again.</p>
                </c:when>
                <c:when test="${error=='differentpw'}">
                    <p>The confirm password is not consistent with the password. Please enter again.</p>
                </c:when>
                <c:otherwise>
                </c:otherwise>
                </c:choose>
        <form action="register" class="register-form" method="POST">
            <input type="text" name="username" placeholder="username">
         <input type="password" name="password" placeholder="password">
         <input type="password" name="confirm_password" placeholder="confirm_password">
         <input type="text" name="email" placeholder="email">
         <button type="submit" value="Register" >Register</button>
        </form>
        
                </div>
        </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
