<%-- 
    Document   : error
    Created on : Apr 25, 2018, 11:33:25 PM
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
         <a href="purchase">Purchase Books</a>
         <a href="login">Login</a>
         <a href="register">Register</a>
         <hr>
         <p>The username or password are not correct. Please input again.</p>
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
        <form/>
    </body>
</html>
