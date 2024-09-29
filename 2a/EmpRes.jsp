<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Information</title>
</head>
<body>
	<h2>Employee Information Result:</h2>
	<%
	//Retriev form data
	String emplyeeid = request.getParameter("employeeId");
	String name = request.getParameter("name");
	String ageStr = request.getParameter("age");
	String department = request.getParameter("department");
	String email = request.getParameter("email");

	//Process data
	int age = Integer.parseInt(ageStr);
	Calendar calendar = Calendar.getInstance();
	int currentYear = calendar.get(Calendar.YEAR);
	int birthyear = currentYear - age;
	String nameAndDeoartment = name + "(" + department + ")";
	//Format email
	String formattedEmail = email.toLowerCase();
	%>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<td><%=emplyeeid%></td>
		</tr>
		<tr>
			<th>Name and Department</th>
			<td><%=nameAndDeoartment%></td>
		</tr>
		<tr>
			<th>Birth Year</th>
			<td><%=birthyear%></td>
		</tr>
		<tr>
			<th>Formatted email id</th>
			<td><%=formattedEmail%></td>
		</tr>
	</table>
	<a href="Empform.jsp" >Back to index</a>
</body>
</html>
