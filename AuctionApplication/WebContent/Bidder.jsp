<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bidder</title>
<style>
	h1{
		color: green;
		text-align: center;
		border: 5px solid blue;
	}
</style>
</head>
<script>
	function myFunction() {
		document.getElementById("bidOutput").innerHTML = "Bidder details added Successfully!";
		return false;
	}
	
	</script>
	<style>
.hide {
	position: absolute;
	top: -1px;
	left: -1px;
	width: 1px;
	height: 1px;
}
</style>

<iframe name="hiddenFrame" class="hide"></iframe>
<body>

	<% String user = request.getParameter("user"); %>
	<h1>Welcome <%=user%></h1>
	
	<% String item =  (String)request.getAttribute("item");
	  if (item==null||item.isEmpty()|| item.equals(null)) {%>
		<h3>Hi Bidder,</h3>
		<h3>We don't have any item, please visit after some time</h3>
		<%
			} else {
		%>
		
		<form action="./BidderServlet" method="post" onsubmit="myFunction()"
		target="hiddenFrame">
		<div align="center">
		<input name="showItem" type="hidden" value="<%=item%>" />
		<label><%=item%></label>
		<p>Please Add your details to Bid the product</p>
			Name: <input name="username" type="text" /> <br /><br /> 
			Phone: <input name="phone" type="text" /> <br /><br />
		    Email:<input name="email" type="text" /> <br /><br />
		    Amount:<input name="amount" type="text" /> <br /><br />
		    Address: <input name="address" type="text" /> <br /><br />
			<p>
				<input type="submit" id="btnAdd" value="Submit" />
			</p>
			<div id="bidOutput"></div>
			<%}%>
		</form>
</body>
</html>