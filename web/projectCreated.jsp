<%-- 
    Document   : projectCreated
    Created on : 13-Apr-2015, 09:31:24
    Author     : Pernille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="control.ProjectDTO"%>
<%ProjectDTO p=(ProjectDTO)request.getAttribute("CreateProject");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Created</title>
    </head>
    <body>
        
        <h1>Start date: <%= p.getStartDate()%></h1>
        <h1>End date: <%= p.getEndDate()%></h1>
        <h1>Budget: <%= p.getProjectBudget()%></h1>
        <h1>Currency <%= p.getCurrency()%></h1>
    </body>
</html>
