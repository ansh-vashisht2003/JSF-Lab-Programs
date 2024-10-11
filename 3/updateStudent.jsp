<%@ page import="o.Student,o.StudentDAO"%>

<%

StudentDAO dao = new StudentDAO();

int rollNo = Integer.parseInt(request.getParameter("rollNo"));

Student student = new Student();

for (Student s : dao.getAllStudents()) {

	if (s.getRollNo() == rollNo) {

		student = s;

		break;

	}

}

if (request.getParameter("name") != null) {

	String name = request.getParameter("name");

	String email = request.getParameter("email");

	int age = Integer.parseInt(request.getParameter("age"));

	student.setName(name);

	student.setEmail(email);

	student.setAge(age);

	dao.updateStudent(student);

	out.println("Student updated successfully.");

}

%>

<html>

<body>

	<h2>Update Student</h2>

	<form action="updateStudent.jsp?rollNo=<%=student.getRollNo()%>"

		method="post">

		Name: <input type="text" name="name" value="<%=student.getName()%>"><br>

		Email: <input type="text" name="email"

			value="<%=student.getEmail()%>"><br> Age: <input

			type="text" name="age" value="<%=student.getAge()%>"><br>

		<input type="submit" value="Update Student">

	</form>


	<a href="viewStudents.jsp">View Students</a>

</body>

</html>