package com.cook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>cookie pg2</title>");
		pw.println("</head>");
		pw.println("<body>");
		Cookie[] cookies = req.getCookies();

		boolean f = false;
		String name = "";
		if (cookies == null) {
			pw.println("<h1>You are a new user! Please login first</h1>");
			pw.println("<h3><a href='index.html'>Home</a></h3>");
			return;
		}

		else {
			for (Cookie c : cookies) {
				String tname = c.getName();
				if (tname.equals("user_name")) {
					f = true;
					name = c.getValue();
				}
			}
		}
		if (f) {
			pw.println("<h1>Hey " + name + ", welcome back to computer.</h1>");

		} else {
			pw.println("<h1>You are a new user! Please login first</h1>");
			pw.println("<h3><a href='index.html'>Home</a></h3>");
		}

		pw.println("</body>");
		pw.println("</html>");

	}

}
