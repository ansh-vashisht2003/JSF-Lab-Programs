package o;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
public void addStudent(Student student) {
String sql = "INSERT INTO students (RollNo, Name, Email, Age) VALUES (?, ?, ?, ?)";
try (Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
preparedStatement.setInt(1, student.getRollNo());
preparedStatement.setString(2, student.getName());
preparedStatement.setString(3, student.getEmail());
preparedStatement.setInt(4, student.getAge());
preparedStatement.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
}

public List<Student> getAllStudents() {
List<Student> students = new ArrayList<>();
String sql = "SELECT * FROM students";
try (Connection connection = DBConnection.getConnection();
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sql)) {
while (resultSet.next()) {
Student student = new Student();
student.setRollNo(resultSet.getInt("RollNo"));
student.setName(resultSet.getString("Name"));
student.setEmail(resultSet.getString("Email"));
student.setAge(resultSet.getInt("Age"));
students.add(student);
}
} catch (SQLException e) {
e.printStackTrace();
}
return students;
}

public void updateStudent(Student student) {
String sql = "UPDATE students SET Name = ?, Email = ?, Age = ? WHERE RollNo = ?";
try (Connection connection = DBConnection.getConnection();

PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
preparedStatement.setString(1, student.getName());
preparedStatement.setString(2, student.getEmail());
preparedStatement.setInt(3, student.getAge());
preparedStatement.setInt(4, student.getRollNo());
preparedStatement.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
}

public void deleteStudent(int rollNo) {
String sql = "DELETE FROM students WHERE RollNo = ?";
try (Connection connection = DBConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
preparedStatement.setInt(1, rollNo);
preparedStatement.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
}
}