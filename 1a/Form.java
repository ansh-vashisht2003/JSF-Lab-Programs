package lab1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Form")
public class Form extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h2>Submit Your Details</h2>");
		out.println("<form method ='Post' action ='Form'>");
		out.println("Name: <input type='text' name='name'></br>");
		out.println("Password: <input type='password' name='password'></br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>Submitted details are: </h2>");
		out.println("Name: "+name+" Password: "+password);
		out.println("</body></html>");
	}
}
