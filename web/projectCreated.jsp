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
        
        <p1>Start date: <%= p.getStartDate()%></p1>
        <p2>End date: <%= p.getEndDate()%></p2>
        <p3>Budget: <%= p.getProjectBudget()%></p3>
        <p4>Currency: <%= p.getCurrency()%></p4>
        <p5> Contact Information</p5>
        <p6>Partner ID: <%= p.getPartnerID() %></p6>
        <p7>First Name: <%= p.getFirstname() %></p7>
        <p8>Last name: <%= p.getLastname() %></p8>
        <p9>Phone: <%= p.getPhone() %></p9>
        <p10>Activity Description: <%= p.getActivityDescription() %></p10>
        <p11>Comments: <%= p.getComments() %></p11>
        <p12>Target Audience: <%= p.getTargetAudience() %></p12>
        <p13>Objective & Result: <%= p.getObjectiveResult() %></p13>
    </body>
</html>
