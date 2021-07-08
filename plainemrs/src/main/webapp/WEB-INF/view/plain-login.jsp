<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Plain EMRS Login</title>
		<style>
			.failed {
				color: red;
			}
		</style>
	</head>
	
	<body>
		<h3>Welcome! Please log in</h3>
			<form:form action="${pageContext.request.contextPath}/authenticate-the-user" method="POST">	
				
				<!-- Check for login error -->
				<c:if test="${param.test != null}"	>
					<i class="failed">Sorry, invalid username/password.</i>
				</c:if>
				
				<p>
					Username: <input type="text" name="username" />
				</p>
				
				<p>
					Password: <input type="password" name="password" />
				</p>
				
				<input type="submit" value="Login" />
				
			</form:form>
	</body>
</html>