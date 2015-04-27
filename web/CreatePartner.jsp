<%-- 
    Document   : CreatePartner
    Created on : 21-04-2015, 10:21:17
    Author     : Jeanette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
            <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
        </ul>
        <h1>Create Partner</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
        <h3>${validateMsg}</h3>
        <hr>
        
        <br>
        <br>
        <form name="Create Partner" action="CreatePartnerServlet" method="POST">
            PartnerID: &nbsp <input type="text" name="partnerID" value="" size="20" disabled="disabled" />
            <br>
            <br>
            Country: &nbsp <select name="country">
                <option value="denmark">Denmark</option>
                <option value="norway">Norway</option>
                <option value="finland">Finland</option>
                <option value="sweden">Sweden</option>
                <option value="iceland">Iceland</option>
            </select>
            <br>
            <br>
            Partner Name: &nbsp <input type="text" name="partnerName" value="" size="20" />
            <br>
            <br>
            Partner type: &nbsp; <select name="partnerType">
                <option value="partner">Partner</option>
                <option value="distributer">Distributer</option>
            </select>
            <br>
            <input name="Create Partner" type="submit" value="CreatePartnerServlet" />
        </form>
    </body>
</html>
