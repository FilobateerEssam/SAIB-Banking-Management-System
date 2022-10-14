<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<input type="hidden" id= "Status"  value="<%= request.getAttribute("Status") %>"> 

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/index.png" alt="sing up image" style="margin-top: 150px">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign In</h2>
						<form method="post" action="LoginServlet" class="register-form"
							id="login-form">
							
							<!-- Account Number -->
							
							<div class="form-group">
								<label for="Account"><i
									class="zmdi zmdi-lock"></i></label> <input required="required"
									type="number" name="account" id="account"
									placeholder="Your Account" />
							</div>
							
							<!-- pin -->
							
							<div class="form-group">
								<label for="pin"><i class="zmdi zmdi-lock"></i></label> <input required="required"
									type="password" name="pin" id="pin"
									placeholder="Enter pin" />
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
							
							
							
							<!-- Remember Me -->
							
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							
							<!-- Submit -->
							
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						
						
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
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
		if (Status == "failed")
			swal("Sorry" , "Invalid Account / Pin","error");
		 
			 
	
	</script>
	
	
	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>