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
        
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="j_username" id="j_username"/></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="j_password" id="j_password"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
        <form/>
    </body>
</html>
