package com.servs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Note;
import com.helper.FactoryProv;

public class SaveNoteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServ() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			Note note = new Note(title, content, new Date());
			// System.out.println(note.getNoteId()+" "+note.getTitle()+"
			// "+note.getContent()+" "+note.getAddedDate());

			// hibernate save

			Session s = FactoryProv.getFact().openSession();
			Transaction tx = s.beginTransaction();

			s.persist(note);

			tx.commit();

			s.close();

			
			response.sendRedirect("showNotes.jsp");
//			response.setContentType("text/html");
//
//			PrintWriter out = response.getWriter();
//			out.println("<h2 style='text-align:center'>Your note is added Successfully</h2>");
//			out.println("<h2 style='text-align:center'><a href='showNotes.jsp'>View all notes</a></h2>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
