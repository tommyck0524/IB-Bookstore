<%-- 
    Document   : register
    Created on : Apr 22, 2018, 2:41:47 PM
    Author     : hochikeung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Success Page</title>
        <link rel="stylesheet" href="resources/styles/login.css" type="text/css" />\          
        <jsp:include page="header.jsp" />
    </head>
    <body>
        <div class="login-page">
        <div class="form">
        <h4> Registration Successful!</h4>
        <a href="home">
        <button>Return to Home Page</button>
        </a>
                </div>
        </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
