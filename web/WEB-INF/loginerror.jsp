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
        <title>Login Error Page</title>
        <link rel="stylesheet" href="resources/styles/login.css" type="text/css" />
    </head>
    <body>
        
    <div class="login-page">
    <div class="form">
    <form class="login-form" action="login" method="POST">
        <h4>The username/password is not valid. Please input again</h4>
      <input type="text" placeholder="username"  name="username" />
      <input type="password" placeholder="password" name="password"/>
      <button type="submit" value="Login" >login</button>
      <p class="message">Not registered? <a href="register">Create an account</a></p>
    </form>
  </div>
</div>
    </body>
</html>
