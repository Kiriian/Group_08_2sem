<%-- 
    Document   : projectCreated
    Created on : 13-Apr-2015, 09:31:24
    Author     : Pernille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="control.ProjectDTO"%>
<%ProjectDTO p=(ProjectDTO)request.getAttribute("Project");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Created</title>
    </head>
    <body>
        
    <h5>Start date: <%= p.getStartDate()%></h5>
        <h5>End date: <%= p.getEndDate()%></h5>
        <h5>Budget: <%= p.getProjectBudget()%></h5>
        <h5>Currency: <%= p.getCurrency()%></h5>
        <h5>Partner ID: <%= p.getPartnerID() %></h5>
        <h5>Activity Description: <%= p.getActivityDescription() %></h5>
        <h5>Comments: <%= p.getComments() %></h5>
        <h5>Target Audience: <%= p.getTargetAudience() %></h5>
        <h5>Objective & Result: <%= p.getObjectiveResult() %></h5>
    </body>
</html>
