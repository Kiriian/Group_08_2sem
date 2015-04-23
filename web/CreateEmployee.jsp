<%-- 
    Document   : CreateEmployee
    Created on : 23-Apr-2015, 16:04:25
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
    <body><br>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">DELL</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
            <li class="active"><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
        </ul>
        <h1>Create employee</h1>
        <h3>${validateMsg}

            <hr>
            <form name="Create employee" action="CreateEmployeeServlet" method="POST">

                Firstname: &nbsp <input type="text" name="firstname" value="" size="20" />
                <br>
                <br>
                Lastname: &nbsp <input type="text" name="lastname" value="" size="20" />
                <br>
                <br>
                Country: &nbsp <select name="country">
                    <option value="Denmark">Denmark</option>
                    <option value="Norway">Norway</option>
                    <option value="Sweeden">Sweeden</option>
                    <option value="Finland">Finland</option>
                    <option value="Iceland">Iceland</option>
                </select>
                <br>
                <br>
                EmployeeType: &nbsp <select name="employeeType">
                    <option value="Dell marketing">Dell marketing</option>
                    <option value="Dell MDF">Dell MDF</option>
                </select>
                <br>
                <br>
                <input type="submit" value="Submit employee" name="CreateEmployeeServlet" />
            </form>
    </body>
</html>
