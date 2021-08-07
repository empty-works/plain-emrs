<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Systems</title>
</head>


<body>

<h2>Systems</h2>

<hr>

<p>
	Systems admin page!
	<br>
	<ul>
		<li><a href="${pageContext.request.contextPath}/user/show-add-user-form">Add User</a></li>
		<li>Edit User</li>
		<li>Delete User</li>
	</ul>
</p>

<hr>

<a href="${pageContext.request.contextPath}/">Back to Homepage</a>

</body>

</html>