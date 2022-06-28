<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.helper.*,com.Entities.*,org.hibernate.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="refFiles.jsp"%>
<title>Update notes</title>
</head>
<body>
	<div class="container-fluid p-0">

		<%@include file="navbar.jsp"%>
		<br>
		<h1>Update your Note</h1>
			<%
			int nId = Integer.parseInt(request.getParameter("note_id").trim());
			Session s = FactoryProv.getFact().openSession();
			Note note = (Note) s.get(Note.class, nId);
			String tit= note.getTitle();
			
			%>
		<!-- Form for adding -->
		<form action="UpdateServ" method="post">
		<input value="<%=nId%>" name="NoteId" type="hidden">
			<div class="form-group">
				<label for="title">Give a title to your note</label> <input
					name="title" required type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here" value="<%= tit %>"/>
			</div>
			<div class="form-group">
				<label for="note">Enter your note here</label>
				<textarea name="content" required id="note"
					placeholder="Start Typing" class="form-control"
					style="height: 250px"><%= note.getContent() %></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Update Note</button>
			</div>

		</form>
	</div>

</body>
</html>