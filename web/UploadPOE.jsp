<%-- 
    Document   : UploadPOE
    Created on : 27-04-2015, 12:10:52
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
        <title>Upload POE</title>
    </head>
    <body>
        <h1>Upload POE</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} </h5>
        <br>
        <br>
        <div class="navbar-header">
            <a class="navbar-brand" href="#">DELL</a>
        </div>
        <ul class="nav nav-tabs">
            <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
            <li><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
            <li class="active"><a href="http://localhost:8080/Group_08_2sem/UploadPOE.jsp">Submit POE</a></li>
        </ul>
        <form name="Upload POE" action="uploadPOEServlet" method="POST" enctype="multipart/form-data">
            <h3>Note: You can only upload one file pr. project</h3>
            <h3>${validateMsg}</h3>
            <br>
            <br>
            ProjectID: &nbsp <input type="text" name="projectID" value="" size="20" />
            <br>
            <br>
            <input type="file" name="file" size="50" />
            <br>
            <br>
            <input type="submit" value="Upload File" />
            <br>
            <br>
        </form>
    </body>
</html>
