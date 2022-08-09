package magar.atul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Login() { }
	
   //load logging page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
	}
   //submit login page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//set content type
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
		
		//read data from form submit
		String userID = request.getParameter("userID");   //from html
		String useremail = request.getParameter("useremail");   //from html
    	String password = request.getParameter("password"); //from html
    	
    	if(useremail != null && !useremail.equals("") && !password.equals("")) {
    		if(useremail.equals("admin@gmail.com") && password.equals("123")) {
    			//create cookies
        		HttpSession session = request.getSession(true);
        		//add cookie
        		session.setAttribute("userID", userID);
        		session.setAttribute("useremail", useremail);
        		session.setAttribute("password", password);
        		
        		out.println("<h1 style='color:green'>Login Successful </h1>");
    		}else {
    			out.println("<h1 style='color:red'>Invalid Credentials * Login failed</h1>");
    		}	
    	}else {
    		out.println("<h1 style='color:red'>Login Failed * Required Fill are missing</h1>");
    	}
	}

}
