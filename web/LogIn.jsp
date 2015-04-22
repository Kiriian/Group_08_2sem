<%-- 
    Document   : logIn
    Created on : 22-Apr-2015, 07:25:26
    Author     : Pernille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr>
        <h3>${validateMsg}</h3>
        <form name="logIn" action="LogInServlet" method="POST">
            <h2>Please log in<h2>
                    <br>
                    <br>
            Enter username: &nbsp <input type="text" name="username" value="" size="20" />
            <br>
            Enter password: &nbsp <input type="password" name="password" value="" size="20" />
            <br>
            <input type="submit" value="LogIn" name="LogInServlet" />
        </form>
        
        
    </body>
</html>
