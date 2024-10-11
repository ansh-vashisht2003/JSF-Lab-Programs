<%@ page import="java.util.List, o.Student,o.StudentDAO"%>

<%

StudentDAO dao = new StudentDAO();

List<Student> students = dao.getAllStudents();

%>

<html>

<body>

	<h2>View Students</h2>

	<table border="1">

		<tr>

			<th>Roll No</th>

			<th>Name</th>

			<th>Email</th>

			<th>Age</th>

			<th>Actions</th>

		</tr>

		<%

		for (Student student : students) {

		%>

		<tr>

			<td><%=student.getRollNo()%></td>

			<td><%=student.getName()%></td>

			<td><%=student.getEmail()%></td>

			<td><%=student.getAge()%></td>

			<td><a

				href="updateStudent.jsp?rollNo=<%=student.getRollNo()%>">Edit</a>

				| <a href="deleteStudents.jsp?rollNo=<%=student.getRollNo()%>">Delete</a>

			</td>

		</tr>

		<%

}

%>

	</table>

	<a href="addStudent.jsp">Add Student</a>

</body>

</html>