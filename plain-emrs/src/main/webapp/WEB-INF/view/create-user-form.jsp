<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<!doctype html>
<html>
	<head>
		<title>Create User</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
			
		<h2>Create User</h2>
		
		<!-- Create User Form -->
		<form:form action="${pageContext.request.contextPath}/create-user/process-user-creation" 
				   modelAttribute="emrsUser">
				   
			<!-- Check for registration error -->
			<c:if test="${registrationError != null}">
				<i class="failed">${registrationError}</i>
			</c:if>
			
			<hr>
			
			<!-- Username -->
			<form:input path="userName" placeholder="username" />
				
			<hr>
			
			<form:password path="password"	placeholder="password" />
			
			<hr>
			
			<form:input path="emailAddress" placeholder="email address" />
			
			<hr>
			
			<!-- Create user button -->
			<button type="submit" class="btn btn-primary">Create</button>

		</form:form>

	</body>
</html>