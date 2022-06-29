<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="refFiles.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Enter your Note</h1>
		<br>
		<!-- Form for adding -->
		<form action="SaveNoteServ" method="post">
			<div class="form-group">
				<label for="title">Give a title to your note</label> <input
					name="title" required type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here">
			</div>
			<div class="form-group">
				<label for="note">Enter your note here</label>
				<textarea name="content" required id="note" placeholder="Start Typing"
					class="form-control" style="height: 250px"></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add Note</button>
			</div>

		</form>
	</div>


</body>
</html>