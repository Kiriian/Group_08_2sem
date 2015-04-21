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
    </head>
    <body>
        <h1>Create Partner</h1>
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
