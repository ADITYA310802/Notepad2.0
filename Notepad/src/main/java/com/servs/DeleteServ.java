package com.servs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Note;
import com.helper.FactoryProv;

public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int nId=Integer.parseInt(request.getParameter("note_id").trim());
			
			Session s= FactoryProv.getFact().openSession();
			Transaction tx=s.beginTransaction();
			Note note=(Note)s.get(Note.class,nId);
			s.remove(note);
			response.sendRedirect("showNotes.jsp");
			
			tx.commit();
			s.close();
			
		}catch(Exception e)
		{
			
		}
	}

}
