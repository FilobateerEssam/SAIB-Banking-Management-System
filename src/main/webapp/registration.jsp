<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form </title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

</head>
<body>

	<input type="hidden" id= "Status"  value="<%= request.getAttribute("Status") %>"> 

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="RegisterServlet" class="register-form"
							id="register-form">
							<div class="form-group">
							
							<!-- NAME  -->
							
								<label for="Full Name : "><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input type="text" name="full_name" id="name" placeholder="Your Full Name"  required="required"/>
							</div>
							
							<!-- Email   -->
							
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required="required" />
							</div>
							
							
								<!-- Account   -->
							
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="number" name="account" id="account" required="required"
									placeholder="Your Account" />
							</div>
							
							
							
									<!-- PIN   -->
							<div class="form-group">
								<label for="Pin"><i class="zmdi zmdi-lock"></i></label> <input required="required"
									type="password" name="pin" id="pin" placeholder="Your Pin" />
									
								<i class="bi bi-eye-slash" id="togglePassword"></i>	
									
 							</div>
							
							<script>
							 const togglePassword = document.querySelector("#togglePassword");
						        const password = document.querySelector("#pin");
						
						        togglePassword.addEventListener("click", function () {
						            // toggle the type attribute
						            const type = pin.getAttribute("type") === "pin" ? "text" : "pin";
						            password.setAttribute("type", type);
						            
						            // toggle the icon
						            this.classList.toggle("bi-eye");
						        });
		  
		  
    </script>
							
							
							
									<!-- RE PIN   -->
							
							<div class="form-group">
								<label for="re-pin"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pin" id="re_pin" required="required"
									placeholder="Repeat your pin" />
															
								 
									
							</div>
							
		
		 
		
								
								<!-- Agree (Remember Me) Checkbox -->
							
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term" required="required"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							
							<!-- Submit Button   -->
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					
					
					<div class="signup-image">
						<figure>
							<img src="images/index.png" alt="sing up image" style="margin-top: 120px">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	
	<!-- Message After Register if Success or Not -->
	
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>




	<script type="text/javascript">
		var Status= document.getElementById("Status").value;
		if (Status == "Success") {
			swal("Congrats" , "Account Created Successfully","success");
		}
		else if (Status == "failed")
			swal("Sorry" , "Account Not Created","error");
			 
		else if (Status == "Not_Equal")
			swal("Sorry" , "Your Confirm Pin Not True","error");
		
		else if (Status == "invalide_String")
			swal("Sorry" , "You Should Enter Name Not Numbers and Length should be over 9  Characters","error");
		
		
	</script>

</body>
 </html>