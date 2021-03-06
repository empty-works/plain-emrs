<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>

<head>
	<title>EMRS Login</title>
	<style>
		.failed {
			color: red;
		}
	</style>
</head>

<body>
	<h3>EMRS Login</h3>
	<h5>Please enter username and password.</h5>
		<form:form action="${pageContext.request.contextPath }/authenticate-the-user"
					method="POST">
					
			<!-- Check for login error -->
			
			<c:if test="${param.error != null}">
				<i class="failed">Sorry, you entered an invalid username/password.</i>
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