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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>
        <fieldset>
            <legend>Please fill in the information below to register</legend>
            <form method="POST" action="register">
            <p>Username <input type="text" name="username"></p>
            <p>Password <input type="password" name="password"></p>
            <p>Confirm password <input type="password" name="confirm_password"></p>
            <p>Email address <input type="text" name="email"></p>
            <p>Address <input type="text" name="address"></p>
            <input type="submit" value="Login"/>
            </form>
        </fieldset>
    </body>
</html>
