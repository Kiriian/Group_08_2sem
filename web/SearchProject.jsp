<%-- 
    Document   : SearchProject
    Created on : 13-04-2015, 15:30:35
    Author     : martamiszczyk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Project</h1><h3 align="right"> Username: </h3>
        <hr>
        Status:<select name="status">
            <option>Project proposal</option>
            <option>Submittet</option>
            <option>Execution</option>
            <option>Request POE</option>
            <option>Approval</option>
            <option>Claim sent</option>
        </select>
        Partner Name: <input type="text" name="PartnerName" value="" />
        Quarter: 
    </body>
</html>
