<%-- 
    Document   : login
    Created on : Apr 22, 2018, 2:41:55 PM
    Author     : hochikeung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login Page</title>
    </head>
    <body>
        
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
        </form>
    </body>
</html>
