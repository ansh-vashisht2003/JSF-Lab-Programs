<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Information</title>
</head>
<body>
<h2>Employee Information Result:</h2>
<%
    // Retrieve form data
    String employeeid = request.getParameter("employeeid");
    String name = request.getParameter("name");
    String ageStr = request.getParameter("age");
    String department = request.getParameter("department");
    String email = request.getParameter("email");
    //Naming for errors
    String emailerror = "";
    String employeeiderror = "";
    String nameerror = "";
    String departmenterror = "";
    String ageerror = "";
    //by deafulat we are saving it as valid
    boolean isvalid = true;
    if (employeeid == null || employeeid.trim().isEmpty()) {
        employeeiderror = "Employee ID is required";
        isvalid = false;
    }
    if (name == null || !name.matches("^[a-zA-Z\\s]+$")) {
        nameerror = "Name should have only letters and spaces";
        isvalid = false;
    }
    int age = 0;
    try {
        age = Integer.parseInt(ageStr);
        if (age < 18 || age > 65) {
            ageerror = "Age must be between 18 and 65";
            isvalid = false;
        }
    } catch (NumberFormatException e) {
        ageerror = "Age must be a valid numeric number";
        isvalid = false;
    }
    if (department == null || department.trim().isEmpty()) {
        departmenterror = "Department is required";
        isvalid = false;
    } else if (!department.matches("HR|Finance|IT|Sales")) {
        departmenterror = "Department must be HR or Finance or IT or Sales";
        isvalid = false;
    }
    if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
        emailerror = "Email ID is not valid";
        isvalid = false;
    }
    String nameAndDepartment = "";
    int birthyear = 0;
    String formattedEmail = "";
    if (isvalid) {
        // Process data
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        birthyear = currentYear - age;
        nameAndDepartment = name + " (" + department + ")";
        formattedEmail = email.toLowerCase(); 
%>
<table border="1">
<tr>
    <th>Employee ID</th>
    <td><%= employeeid %></td>
</tr>
<tr>
    <th>Name and Department</th>
    <td><%= nameAndDepartment %></td>
</tr>
<tr>
    <th>Birth Year</th>
    <td><%= birthyear %></td>
</tr>
<tr>
    <th>Formatted Email ID</th>
    <td><%= formattedEmail %></td>
</tr>
</table>
<% }if (!isvalid) { %>
    <h3>Validated Errors:</h3>
    <ul>
        <% if (!employeeiderror.isEmpty()) { %><li>
        <b>Employee ID: </b> <%= employeeiderror %></li><% } %>
        <% if (!nameerror.isEmpty()) { %><li>
        <b>Name: </b> <%= nameerror %></li><% } %>
        <% if (!ageerror.isEmpty()) { %><li>
        <b>Age: </b> <%= ageerror %></li><% } %>
        <% if (!departmenterror.isEmpty()) { %><li>
       <b>Department: </b> <%= departmenterror %></li><% } %>
        <% if (!emailerror.isEmpty()) { %><li>
        <b>Email: </b> <%= emailerror %></li><% } %>
    </ul>
    <a href="Employeehtml.jsp" >Back to index</a>
<% } %>
</body>
</html>