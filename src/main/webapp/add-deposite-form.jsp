<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Form</title>
<link type="text/css" rel="stylesheet" href="css/style2.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Transaction Operation</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Transaction</h3>
		
		<form action="Controller_Servlet" method="GET">
		
			<input type="hidden" name="command" value="ADD_D" />
			<input type="hidden" name="Account" value="${TheClints.Account}" />
			<table>
				<tbody>
					<tr>
						<td><label>Amount:</label></td>
						<td><input type="text" name="current_balance" 
								   value="${TheClints.current_balance}" /></td>
					</tr>

				 
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="index.jsp">Back to List</a>
		</p>
	</div>
</body>

</html>






