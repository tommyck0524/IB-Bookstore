<%-- 
    Document   : registererror
    Created on : Apr 26, 2018, 3:44:36 PM
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
        <h1>The inputs are incorrect. Please try again.</h1>
          <fieldset>
            <legend>Please fill in the information below to register</legend>
            <form method="POST" action="register">
            <p>Username <input type="text" name="username"></p>
            <p>Password <input type="password" name="password"></p>
            <p>Confirm password <input type="password" name="confirm_password"></p>
            <p>Email address <input type="text" name="email"></p>
            <p>Address <input type="text" name="address"></p>
            </form>
        </fieldset>
    </body>
</html>
