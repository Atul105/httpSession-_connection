package magar.atul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //load logging page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		//read cookies
		HttpSession session = request.getSession(false);
		
		String useremail = (String) session.getAttribute("useremail");
		String userID = (String) session.getAttribute("userID");
		String password = (String) session.getAttribute("password");
	    
		if(session != null && useremail != null) {
			if(useremail.equals("admin@gmail.com")) {
				out.println("<h1 style='color:green'>Welcome back "+useremail+ "</h1>");
				out.println("<h1 style='color:green'>SessionID '"+userID +"'</h1>");
				out.println("<h1 style='color:green'>Password '"+password +"'</h1>");
				
			}else {
				out.println("<h1 style='color:red'>Invalid Credentials</h1>");
				request.getRequestDispatcher("login.html").include(request, response);
			}
		}else {
			out.println("<h1 style='color:red'>Invalid access * Plz Login to see profile</h1>");
		}
			
		}
		
	
   //submit login page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
