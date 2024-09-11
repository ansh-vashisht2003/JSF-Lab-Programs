<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
</head>
<body>
<h2> Enter the employee information</h2>
<form action ="emplyeeResult.jsp" method="POST">
Employee ID: <input type="text" name="employeeid" required><br>
Name: <input type="text" name="name" required><br>
Age: <input type="number" name="age"required><br>
Department: <select name="department" required>
	<option value="">Select </option>
	<option value="HR">HR </option>
	<option value="Finance">Finance </option>
	<option value="IT">IT </option>
	<option value="Sales">Sales</option>
	</select><br>
Email: <input type="email" name="email">
<input type="submit" value="submit">

</form>

</body>