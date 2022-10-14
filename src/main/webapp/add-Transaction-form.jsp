<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
			<caption>
			<h2>Transaction Operation</h2>
		 	</caption>
		 
	<br>
	<br>
	<br>
	 
		<h3>Add Transaction</h3>
		<hr>
		
	<br>
	<br>
	<br>
		
		<form action="Controller_Servlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			 
					
					   <fieldset class="form-group">
						 <label>Your Account :</label> 
						 <input type="text" name= "account"  class="form-control"
						  required="required" />
				</fieldset>
				 
					
		 <fieldset class="form-group">
						 <label>Account Receiver:</label> 
						 .
						 
						 
						 <input type="text" name= "Account_Receiver" class="form-control"
						  required="required" />
				</fieldset>
				 

					<fieldset class="form-group">
						 <label>Amount Sent</label>  
						 <input type="text" name="amount_Send"class="form-control"
						  required="required" />
				</fieldset>

					 
				 
						 <label></label> 
						 <button type="submit"  class="btn btn-success"/>Save</button>
			 
					
			 
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="index.jsp">Back to List</a>
		</p>
	</div>
</body>

</html>






