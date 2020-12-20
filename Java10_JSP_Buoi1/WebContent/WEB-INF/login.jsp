<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css">
</head>

<body>

	<%
		String path = request.getContextPath();
	%>
	<%
		String message = (String) request.getAttribute("message");
	%>

	<%
		if (message != null) {
	%>
	<p><%=message%></p>
		<%
			}
		%>
		<section>
			<div class="box">
				<div class="form">
					<h2>Login</h2>
					<form action="<%=path %>/login" method="POST">
						<div class="inputBx">
							<input name="username" type="text" placeholder="Username">
							<img src="user.png">
						</div>
						<div class="inputBx">
							<input name="password" type="password" placeholder="Password">
							<img src="lock.png">
						</div>
						<label class="remember"><input type="checkbox">
							Remember Me</label>
						<div class="inputBx">
							<input type="submit" value="Login">
						</div>
					</form>
					<p>
						Forget <a href="#">Password</a>
					</p>
					<p>
						Need an <a href="#">Account</a>
					</p>
				</div>
			</div>
		</section>
</body>
</html>