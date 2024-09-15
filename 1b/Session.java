package lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Session")
public class Session extends HttpServlet{
	private static final long serialVersionUID=1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);  //Retireving existing one do not create new one
		//Handle logout
		String logout=req.getParameter("logout");
		if("true".equals(logout)) {
			if(session!=null)
				session.invalidate();
			resp.sendRedirect("Session");  //redirect to login page
			return ;
		}
		//Checck if user is already loged im
		if(session !=null && session.getAttribute("username")!=null) {
			String username=(String) session.getAttribute("username");

			//Display welcome msg and session info
			out.println("<html><head><title>Welcome</title></head><body>");
			out.println("<h2> Welcome : "+username+"!</h2>");
			out.println("<p><a href='Session?logout=true'>Logout</a></p>");
			out.println("<h3> Session INfo: </h3>");
			out.println("<p> Session ID: "+session.getId()+"</p>");
			out.println("<p> Creation Time: "+new Date(session.getCreationTime())+"</p>");
			out.println("<p> Last Accessed Time: "+new Date(session.getLastAccessedTime())+"</p>");
			out.println("</bod></html>");

		}else {
			//if not logied then dispLAY THE FORM
			out.println("<html><head><title>LOGIN fORM</title></head><body>");
			out.println("<h2>LOGIN</h2>");
			out.println("<form method='post' action ='Session'>");
			out.println("Username: <input type='text' name='username'><br><br>");
			out.println("Password: <input type='password' name='password'><br><br>");
			out.println("<input type='Submit' value='login'>");
			out.println("</body><?html>");

		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if("admin".equals(username) && "password".equals(password)) {
			HttpSession session=req.getSession();  //Craetwe a session if there is none
			session.setAttribute("username", username); //Store username in session
			resp.sendRedirect("Session");

		}else {
			//Invalid credentials show error msg
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html><head><title>lOGIN</title><?head><body>");
			out.println("<h2>Invalid username or password. Try again later</h2>");
			out.println("<a href='Session'>Back to Login</a>");
			out.println("<body></html>");


		}
	}
}
