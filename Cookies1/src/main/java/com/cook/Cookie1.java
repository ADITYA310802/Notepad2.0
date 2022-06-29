package com.cook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie1 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		PrintWriter pw=res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>cookie pg2</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		String s= req.getParameter("name");
		pw.println("<h1>Hey "+s+", welcome to computer.</h1>");
		
		pw.println("<h3><a href='cook2'>Go to next page</a></h3>");
		
		Cookie c=new Cookie("user_name",s);
		res.addCookie(c);
		
		pw.println("</body>");
		pw.println("</html>");
		
	}

}
