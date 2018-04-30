<%-- 
    Document   : paymentReceipt
    Created on : Apr 22, 2018, 2:44:58 PM
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
                <form class="login-form">
                    <h4>Your request has been done! Confirmation email has been sent to <%=request.getParameter("email")%></h4>
                    <a href="home"> click here to go back to home page <a/>

                </form>
            </div>
        </div>
            <jsp:include page="footer.jsp" />
    </body>
</html>
