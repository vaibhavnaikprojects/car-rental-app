<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Rent Car</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-lg-12">
      			<div class="panel panel-primary">
      			<div class="panel-body">
			      	<div class="row">
			      		<div class="col-lg-3">
			      			<div class="panel panel-primary">
			      				<div class="panel-heading">Select Customer</div>
			  					<div class="panel-body" style="height: 400px; overflow-y: auto;padding: 0px">
			  						<div id="customerProcessing" style="position: absolute;top: 50%;left: 45%"><i class="fa fa-spinner fa-spin fa-2x fa-fw"></i></div>
			  						<div id="customerList" class="list-group"></div>
			  					</div>
			  				</div>
			  			</div>
			      		<div class="col-lg-3">
			      			<div class="panel panel-primary">
			      				<div class="panel-heading">Rent Info</div>
			  					<div class="panel-body" style="height: 400px">
			  						<div class="form-horizontal">
										<div class="form-group"><div class="col-sm-12">
									      		<input type="text" class="form-control" id="customerName" name="customerName" placeholder="Customer Name"/>
									    </div></div>
									    <div class="form-group">
									    	<div class="col-sm-12">
									      		<select class="form-control" id="customerType" name="customerType">
									      			<option value="" selected="selected" disabled="disabled">Customer Type</option>
												    <option value="Individual">Individual</option>
												    <option value="Company">Company</option>
												</select>
									    	</div>
									  	</div>
										<div class="form-group"><div class="col-sm-12">
									      		<input type="text" class="form-control" id="customerPhone" name="customerPhone" placeholder="Customer Phone"/>
									    </div></div>
									    <div class="form-group">
									    	<div class="col-sm-12">
									      		<select class="form-control" id="rentalType" name="rentalType">
									      			<option value="" selected="selected" disabled="disabled">Rental Type</option>
												    <option value="Daily">Daily</option>
												    <option value="Weekly">Weekly</option>
												</select>
									    	</div>
									  	</div>
									    <div class="form-group"><div class="col-sm-12">
									    	<div class='input-group date' id='startDatetimepicker'>
									      		<input type="text" class="form-control" id="startDate" name="startDate" placeholder="Start Date"/>
									      		<span class="input-group-addon">
			                        				<span class="glyphicon glyphicon-calendar"></span>
			                    				</span>
			                				</div>
									    </div></div>
									    <div class="form-group"><div class="col-sm-12">
									    	<div class='input-group date' id='endDatetimepicker'>
									      		<input type="text" class="form-control" id="endDate" name="endDate" placeholder="End Date"/>
									      		<span class="input-group-addon">
			                        				<span class="glyphicon glyphicon-calendar"></span>
			                    				</span>
			                				</div>
									    </div></div>
									    <div class="form-group"><div class="col-sm-12">
									      		<input type="text" class="form-control" id="noOfRentalType" name="noOfRentalType" placeholder="No. Of Days/Weeks" readonly="readonly"/>
									    </div></div>
									 </div>
			  					</div>
			      			</div>
			      		</div>
			      		<div class="col-lg-6">
			      			<div class="panel panel-primary">
			      				<div class="panel-heading">Select Car</div>
			  					<div class="panel-body"  style="height: 400px; overflow-y: auto;padding: 0px">
			  						<div id="carProcessing" style="position: absolute;top: 50%;left: 45%"><i class="fa fa-spinner fa-pulse fa-spin fa-2x fa-fw"></i></div>
			  						<div id="carList" class="list-group"></div>
			  					</div>
			      			</div>
			      		</div>
				 	</div>
				 	<div class="row">
				 		<div class="col-lg-2 col-lg-offset-5">
				 			<button type="button" id="rentCar" name="rentCar" class="btn btn-block btn-primary">Rent Car</button>
				 		</div>
				 	</div>
				 	</div>
				 </div>
			</div>
		</div>
    </div>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/moment.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap-datetimepicker.min.js"/>"></script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#rentHeader').addClass("nav-active");
		console.log("test");
		$.ajax({
			url:'customers?filter=available',
			type:'get',
			success: function(data){
				console.log(data);
				$('#customerProcessing').hide();
				for(var i=0;i<data.length;i++){
					$('#customerList').append('<a href="#" class="list-group-item"><span class="badge">'+data[i].customerType+'</span>'+data[i].name+'</a>');
				}
			}
		});
		$.ajax({
			url:'cars?filter=available',
			type:'get',
			success: function(data){
				console.log(data);
				$('#carProcessing').hide();
				for(var i=0;i<data.length;i++){
					$('#carList').append('<a href="#" class="list-group-item">'+
						    '<div class="list-group-item-heading"><div class="row"><div class="col-lg-12"><h4 style="font-weight:bold">'+data[i].model+' <small>('+data[i].carType+')</small></h4></div></div></div>'+
						    '<div class="list-group-item-text"><div class="row"><div class="col-lg-6">Year: '+data[i].year+'</div><div class="col-lg-6">Vehicle No: '+data[i].vehicleNo+'</div></div>'+
						    '<div class="row"><div class="col-lg-6">Daily Rate: '+data[i].dailyRate+'</div><div class="col-lg-6">Weekly Rate: '+data[i].weeklyRate+'</div></div></div>'+
						  '</a>');
				}
			}
		});
	});
	</script>
</body>
</html>