<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProv"%>
<%@page import="com.Entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@include file="refFiles.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Here are all your notes!</h1>
		<div class="row">
			<div class="col-12">
				<%
				Session s = FactoryProv.getFact().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4" style="max-width: 100px"
						src="images/post-it.png" alt="Card image cap">
					<div class="card-body mx-4">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text">
							<%=note.getContent()%>
						</p>
						<div class="container text-center">
							<a href="DeleteServ?note_id=<%=note.getNoteId()%>" class="btn btn-danger">Delete</a> 
							<a href="updation.jsp?note_id=<%=note.getNoteId()%>" class="btn btn-info">Update</a>
						</div>

					</div>
				</div>

				<%
				}

				s.close();
				%>

			</div>
		</div>


	</div>
</body>
</html>