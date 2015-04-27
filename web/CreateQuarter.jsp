<%-- 
    Document   : CreateQuarter
    Created on : 27-04-2015, 20:15:47
    Author     : Jeanette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Create quarter</title>
    </head>
    <body>
        <br>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">DELL</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
            <li ><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
            <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
        </ul>
        <h1>Create quarter</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
        <h3>${validateMsg}</h3>
        <br>
        <hr>
        <br>
        <form name="Create quarter" action="CreateQuarterServlet">
            Quarter name: &nbsp <input type="text" name="quarterName" value="" size="20" />
            <br>
            <br>
            Quarter budget: &nbsp <input type="text" name="quarterBudget" value="" size="20" />
            <br>
            <br>
            <input type="submit" value="Create quarter" name="Create quarter" />
        </form>
    </body>
</html>
