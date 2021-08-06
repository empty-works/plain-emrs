<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<!doctype html>
<html>
	<head>
		<title>Add User</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Reference Bootstrap files -->
		<link rel="stylesheet"
			 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	
	<body>
			
		<h2>Add User</h2>
		
		<!-- Create User Form -->
		<form:form action="${pageContext.request.contextPath}/user/process-add-user" 
				   modelAttribute="emrsUser">
				   
			<!-- Check for registration error -->
			<c:if test="${registrationError != null}">
				<i class="failed">${registrationError}</i>
			</c:if>
			
			<hr>
			
			<form:input path="givenName" placeholder="Given Name" />
				
			<hr>
			
			<form:input path="middleName" placeholder="Middle Name" />
			
			<hr>
			
			<form:input path="lastName" placeholder="Last Name" />
			
			<hr>
			
			<form:input path="city" placeholder="City" />
			
			<hr>
			
			<form:input path="state" placeholder="State" />
			
			<hr>

			<form:input path="country" placeholder="Country" />
			
			<hr>

			<form:input path="phoneNumber" placeholder="Phone Number" />
			
			<hr>

			<!-- Create user button -->
			<button type="submit" class="btn btn-primary">Add User</button>

		</form:form>

	</body>
</html>