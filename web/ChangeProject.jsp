<%-- 
    Document   : ChangeProject
    Created on : 17-04-2015, 11:50:24
    Author     : martamiszczyk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:set var="user" value="${user}"></c:set>
        <c:choose>
            <c:when test="${user.getUserType() eq 'Partner'}">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">DELL</a>
                </div>
                <ul class="nav nav-tabs">
                    <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                    <li class="active"><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/UploadPOE.jsp">Submit POE</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/UploadClaim.jsp">Upload claim</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">DELL</a>
                </div>
                <ul class="nav nav-tabs">
                    <li><a href="http://localhost:8080/Group_08_2sem/Welcome.jsp">Welcome</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateProject.jsp">Create project</a></li>
                    <li class="active"><a href="http://localhost:8080/Group_08_2sem/SearchProject.jsp">Search and change project</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreatePartner.jsp">Create partner</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateUser.jsp">Create user</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateEmployee.jsp">Create employee</a></li>
                    <li><a href="http://localhost:8080/Group_08_2sem/CreateQuarter.jsp">Create quarter</a></li>
                </c:otherwise>
            </c:choose>
            <br>
            <br>
            <h1>View and Change Project ${project.getProjectID()}</h1><h5 align="right">Username:&nbsp ${user.getFirstname()} 

                <form name="Change project" action="UpdateChangeProjectServlet" method="POST">
            </h5> <input type="hidden" name="usertype" value='${user.getUserType()}' size="20" />
            <h4>${validateMsg}</h4>
            <hr> 
            <br>
            <div> Project id:<input type="text" name="projectID" value='${project.getProjectID()}' size="20" readonly="readonly" />
                <br>
                <br>
                Status:&nbsp <input type="text" name="" value='${project.getStatus()}'  size="20" readonly="readonly"/>
                &nbsp To change status use the dropdown: &nbsp <select name="status">
                    <option value="Project proposal">Project proposal</option>
                    <option value="Project approval">Project approval</option>
                    <option value="Execution">Execution</option>
                    <option value="POE uploaded">POE uploaded</option>
                    <option value="POE approval">POE approval</option>
                    <option value="Claim uploaded">Claim uploaded</option>
                    <option value="Claim approved">Claim approved</option>
                    <option value="Reimburse">Reimburse</option>
                </select>
                &nbsp &nbsp <a onclick="location.href ='ViewPOEServlet?projectid=${project.getProjectID()}'">View POE</a>
                <br>
                <br>
                Start date: 
                <input type="text" name="startDate" value='${project.getStartDate()}' size="20" />&nbsp &nbsp &nbsp
                End date: 
                <input type="text" name="endDate" value='${project.getEndDate()}' size="20" />
                <p1>Quarter:</p1>
                <input type="text" name="quarter" value='${project.getQuarter()}' size="20" />&nbsp &nbsp &nbsp
                <br>
                <br>
                <p1>Budget: 
                    <input type="text" name="budget" value='${project.getProjectBudget()}' size="20" />&nbsp &nbsp &nbsp
                    Cost: 
                    <input type="text" name="cost" value='${project.getCost()}' size="20" />&nbsp &nbsp &nbsp
                    Currency: 
                    <input type="text" name="currency" value='${project.getCurrency()}' size="20" readonly="readonly" />
                    <br>
                    <br>
                    Activity description:
                    <br>
                    <textarea name="activityDescription" rows="10" cols="40"  > ${project.getActivityDescription()}</textarea>
                    <br>
                    <br>
                    <p3>Comments: 
                        <br>
                        <textarea name="comments" rows="10" cols="40" >${project.getComments()}</textarea> </p3>
                    <br>
                    <br>
                    Target audience: 
                    <input type="text" name="targetAudience" value='${project.getTargetAudience()}' size="20" />
                    <br>
                    <br>
                    Objective & result: 
                    <br>
                    <textarea name="objectiveResult" rows="10" cols="40">${project.getObjectiveResult()}</textarea>
                    <br>
                    <br>
                    Required POE:
                    <input type="text" name="requiredPOE" value="" size="20"/>
                    <br>
                    <br> 
                    Employee ID:
                    <input type="text" name="employeeID" value='${project.getEmployeeID()}' />
                    <br>
                    <br>
                    Partner ID:
                    <input type="text" name="partnerID" value="1" size="20" readonly="readonly" />
                    <br>
                    <br>
                    <input type="submit" value="UpdateChangeProjectServlet" name="UpdateChangeProjectServlet" style="width: 10em;  height:5em;" />
                    </form>
                    </body>
                    </html>
