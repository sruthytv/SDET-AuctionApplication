<%@ page language="java" import="java.util.*"
	import="java.util.Iterator" import="com.auction.service.SellerService"
	import="com.auction.Bidder"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller</title>
<style>
h1 {
	color: green;
	text-align: center;
	border: 5px solid blue;
}
</style>
</head>
<script>
	function myFunction() {
		document.getElementById("myDiv").innerHTML = "Item added Successfully!";
		return false;
	}

	 function submitForm(x){
	 document.getElementById("bidDiv").style.display = "block";
	 /* document.getElementsByName("result"); */
	 document.forms[0].submit();
	   // return false;
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
	<form action="./Seller" method="post" onsubmit="myFunction()"
		target="hiddenFrame">

		<%
			String user = request.getParameter("user");
		%>
		<h1>
			Welcome
			<%=user%></h1>
		<%
			List eList = (ArrayList) request.getAttribute("data");
			
			if ((eList.size()==0||eList==null||eList.isEmpty()||eList.equals(null))) {
				 String item =  (String)request.getAttribute("item");
				if(item==null){ 
		%>
		<p>Please Create an Item to Bid</p>
		Item Name: <input name="item" type="text" /> <br />
		<br /> <input type="submit" id="btnSubmit" value="Create Item">

		<br />
		<div id="myDiv"></div>
</form>
		<%
				}else{%>
					<h3>No more Bids to show now.</h3>
				<%}} else {
		%>
		<div align="center">
			<table border="1" cellpadding="5">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Amount</th>
					<th>Address</th>
				</tr>
				<%
					for (int j = 0; j < eList.size(); j++) {
							List innerList = (ArrayList) eList.get(j);
				%>
				<tr>
					<%
						for (int i = 0; i < innerList.size(); i++) {
					%>
					<td><%=innerList.get(i)%></td>
					<%}%>
				</tr>
				<%}%>
			</table>
			
			<div><input type="submit" value="Close the Bid" name="closebid" onClick='submitForm(this)'/></div> 
		</div>
		
	 <div id="bidDiv" align="center" style="text-align: center; display: none">
 <%SellerService bidAmount= new SellerService();
        Bidder bid= bidAmount.highestBidAmount();
         String Name= bid.getName();
        int Amount= bid.getAmount();
        String Address=bid.getAddress();
        String Phone=bid.getPhone();
        String Email=bid.getEmail();
        String getItem= bid.getItem();%>

      <h2>The Winner is</h2>
         <table name= "result" border="1" align="center">
         <tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>Item</th>
				</tr>
			<tr>
				<td><%=Name%></td>
				<td><%=Amount%></td>
				<td><%=Phone%></td>
				<td><%=Email%></td>
				<td><%=Address%></td>
				<td><%=getItem%></td>
			</tr>
			</table> 
</div>  
<%	}	%> 
	
</body>
</html>