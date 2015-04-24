<%-- 
    Document   : CreateUser
    Created on : 23-Apr-2015, 11:09:35
    Author     : Pernille
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
            <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
            <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
        </ul>
        <h1>Create user</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
        <h3>${validateMsg}


        </h3>
        <hr>
        <form name="Create user" action="CreateUserServlet" method="POST">
            Firstname: &nbsp <input type="text" name="firstname" value="" size="20" />
            <br>
            <br>
            Lastname: &nbsp <input type="text" name="lastname" value="" size="20" />
            <br>
            <br>
            Username: &nbsp <input type="text" name="username" value="" size="20" />
            <br>
            <br>
            Password: &nbsp <input type="password" name="password" value="" size="20" />
            <br>
            <br>
            Repeat password: &nbsp <input type="password" name="repeatPassword" value="" size="20" />
            <br>
            <br>
            <p>Enter partnerID only if the user is a partner</p>
            <br>
            PartnerId: &nbsp <input type="text" name="partnerID" value="0" size="20" />
            <br>
            <br>
            <p>Enter employeeID only if the user is a Dell employee</p>
            <br>
            EmployeeID: &nbsp <input type="text" name="employeeID" value="0" size="20" />
            <br>
            <br>
            User Type:
            <select name="userType">
                <option value="dell">Dell</option>
                <option value="partner">Partner</option></select>
            <input type="submit" value="Submit User" name="CreateUserServlet" />
        </form>


    </body>
</html>
