<%@ page import="o.StudentDAO" %>

<%

int rollNo = Integer.parseInt(request.getParameter("rollNo"));

StudentDAO dao = new StudentDAO();

dao.deleteStudent(rollNo);

out.println("Student deleted successfully.");

%>

<html>

<body>

<a href="viewStudents.jsp">View Students</a></body></html>