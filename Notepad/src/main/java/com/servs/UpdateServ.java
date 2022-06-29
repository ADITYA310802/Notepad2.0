package com.servs;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Note;
import com.helper.FactoryProv;

public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServ() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			Session s= FactoryProv.getFact().openSession();
			Transaction tx=s.beginTransaction();
			int noteId= Integer.parseInt(request.getParameter("NoteId").trim());
			Note note=s.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			response.sendRedirect("showNotes.jsp");
			
			tx.commit();
			s.close();
			
			response.sendRedirect("showNotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
