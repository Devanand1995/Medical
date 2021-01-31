<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!--  jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />
<link href="resources/style.css" rel="stylesheet" type="text/css">
<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<script>
	$(document).ready(
			function() {
				var date_input = $('input[name="date"]'); 
				var container = $('.bootstrap-iso form').length > 0 ? $(
						'.bootstrap-iso form').parent() : "body";
				var options = {
					format : 'yyyy/mm/dd',
					container : container,
					todayHighlight : true,
					autoclose : true,
				};
				date_input.datepicker(options);
			})
		function calculate_age(dob) { 
    var diff_ms = Date.now() - dob.getTime();
    var age_dt = new Date(diff_ms); 
  
    return Math.abs(age_dt.getUTCFullYear() - 1970);
}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid d-flex">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Doctor</a>
		</div>
		<ul class="nav navbar-nav float-left navbar-right">
			<li class="active"><a href="#">Home</a></li>
			<li class="nav-link"><a href="#">View</a></li>
			<li class="nav-link"><a href="#">List</a></li>
			<li class="nav-link"><a href="#">Offer</a></li>

		</ul>
	</div>
	</nav>
	<div align="center">


		<form:form class="form-horizontal" action="book" method="post"
			modelAttribute="patient" enctype="multipart/form-data">
			<h2>Appointment Booking</h2>
			<form:hidden class="pt" path="pid" />
			<div class="pt form-group">
				<label class="control-label col-sm-4" for="p_name">Name:</label>
				<div class="col-sm-8">
					<form:input class="form-control" path="p_name" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4" for="p_dob">Date of
					Birth:</label>
				<div class="col-sm-8">
					<form:input class="form-control" type="date" name="dob" path="p_dob" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4" for="age">Age</label>
				<div class="col-sm-8">
				
					<input class="form-control" type="text" value="" name="age">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Blood Group:</label>
				<div class="col-sm-8">
					<form:select class="form-control" path="blood_group">
						<form:option value="O+" label="O+" />
						<form:option value="O-" label="O-" />
						<form:option value="A+" label="A+" />
						<form:option value="A-" label="A-" />
						<form:option value="B+" label="B+" />
						<form:option value="B-" label="B-" />
						<form:option value="AB+" label="AB+" />
						<form:option value="AB-" label="AB-" />
					</form:select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Address</label>
				<div class="col-sm-8">
					<form:textarea class="form-control" path="address" rows="5" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Mobile Number</label>
				<div class="col-sm-8">
					<form:input type="number" min="0" class="form-control" path="mobile_number" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Email</label>
				<div class="col-sm-8">
					<form:input class="form-control" type="email" path="email" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Date Of Appointment</label>
				<div class="col-sm-8">
					<form:input class="form-control" type="date"
						path="date_of_appointment" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4">Upload</label>
				<div class="col-sm-8">
					<form:input class="form-control" type="file" accept="application/pdf" path="upload" />
				</div>
			</div>
			
			<input class="btn btn-primary" type="submit" role="button" value="Save">

		</form:form>
	</div>

</body>
</html>
