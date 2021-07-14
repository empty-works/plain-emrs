<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>

<head>
	<title>Plain EMRS</title>
</head>

<body>
	<h2>Plain EMRS</h2>
	<hr>

	<p>	
	Welcome to Plain EMRS 
	</p>
	
	<hr>
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">

		<!-- Add a link to point to /systems... this is for the admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin Options</a>
		</p>	

		<hr>

	</security:authorize>
	
	<security:authorize access="hasRole('DOCTOR')">

		<!-- Add a link to point to /medical-staff... this is for the medical staff-->
		
		<p>
			<a href="${pageContext.request.contextPath}/medical-staff">Leadership Meeting</a>
			(Only for medical staff)
		</p>	
		
		<hr>

	</security:authorize>
	
	<!-- Add a logout button -->	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		
		<input type="submit" value="Logout" />
		
	</form:form>
	
</body>

</html>