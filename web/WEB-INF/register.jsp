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
        <title>Register Page</title>
        <link rel="stylesheet" href="resources/styles/login.css" type="text/css" />
    </head>
    <body>
        <div class="login-page">
        <div class="form">
        <h4> Register </h4>
        <form action="register" class="register-form" method="POST">
            <input type="text" name="username" placeholder="username">
         <input type="password" name="password" placeholder="password">
         <input type="password" name="confirm_password" placeholder="confirm_password">
         <input type="text" name="email" placeholder="email">
         <button type="submit" value="Register" >Register</button>
        </form>
        
                </div>
        </div>
    </body>
</html>
