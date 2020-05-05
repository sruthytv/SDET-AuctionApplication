<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<element>
		<body>
			<h1>Welcome</h1>
			<!-- 	<form action="http://localhost:8080/web-application/login" method="post"> -->
			<!-- 	<form action="/web-application/login" method="post"> -->
			<form action="./Welcome" method="post">
				<!-- <form action="//www.html.am/html-codes/forms/html-form-tag-action.cfm"
					target="result" method="get"> -->
				<p>Please Select the User Type</p>
				<input type="radio" name="user" value="Bidder" required>
				Bidder
				<input type="radio" name="user" value="Seller" >
				Seller
				<p>
					<input type="submit" value="Submit">
				</p>

			</form>
		</body>
	</element>
</html>