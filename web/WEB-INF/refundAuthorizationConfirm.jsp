<%-- 
    Document   : refundAuthorizationConfirm
    Created on : Apr 29, 2018, 3:53:57 PM
    Author     : hochikeung
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="resources/styles/login.css" type="text/css" />
                    <jsp:include page="header.jsp" />
    </head>
    <body>
        
    <div class="login-page">
    <div class="form">
    <form class="login-form" action="login" method="POST">
        <h4> The refund request has already been authorized.</h4>
        <a href="home">Return to home page</a>
    </form>
  </div>
</div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
