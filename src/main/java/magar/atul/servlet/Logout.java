package magar.atul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //load logging page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	    //add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		out.println("<h1 style='color:green'>Logout Successfully</h1>");
		
		//cookie base logout
		HttpSession session = request.getSession(false);		
		session.invalidate();
		
		request.getRequestDispatcher("login.html").include(request, response);
		
		

	}
   //submit login page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
