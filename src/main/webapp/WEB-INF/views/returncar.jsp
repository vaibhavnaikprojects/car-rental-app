<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Return Car</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-lg-3">
					<div class="panel panel-primary">
						<div class="panel-heading">Select Customer</div>
							<div class="panel-body" style="height: 400px; overflow-y: auto; padding: 0px">
								<div id="customerProcessing" style="position: absolute; top: 50%; left: 45%">
									<i class="fa fa-spinner fa-spin fa-2x fa-fw"></i>
								</div>
							<div id="customerList" class="list-group"></div>
						</div>
					</div>
			</div>
			<div class="col-lg-3">
					<div class="panel panel-primary">
						<div class="panel-heading">Select Cars</div>
							<div class="panel-body"
										style="height: 400px; overflow-y: auto; padding: 0px">
										<div id="carProcessing"
											style="position: absolute; top: 50%; left: 45%">
											<i class="fa fa-spinner fa-pulse fa-spin fa-2x fa-fw"></i>
										</div>
										<div id="carList" class="list-group"></div>
									</div>
					</div>
			</div>
			<div class="col-lg-6">
					<div class="panel panel-primary">
						<div class="panel-heading">Rental Details </div>
							<div class="panel-body" style="height: 400px; overflow-y: auto; padding: 0px">
								<div id="rentalProcessing"
									style="position: absolute; top: 50%; left: 45%">
									<i class="fa fa-spinner fa-pulse fa-spin fa-2x fa-fw"></i>
								</div>
										<div class="col-lg-12">
										<div id="rentalDetails">
										<h4 id="receipt"></h4>
										<h4 id="startDate"></h4>
										<h4 id="endDate"></h4>
										<h4 id="noOfRental"></h4>
										<h4 id="amountDue"></h4>
										<button type="button" id="returnCar" class="btn btn-primary">Return Car</button>
										</div>
									</div>
							</div>
					</div>
			</div>
    	</div>
    </div>
    <script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script>
	$(document).ready(function(){
		var customerId=0;
		var rentalId=0;
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#returnHeader').addClass("nav-active");
		$('#rentalDetails').hide();
		$.ajax({
			url:'customers?filter=active',
			type:'get',
			success: function(data){
				console.log(data);
				$('#customerProcessing').hide();
				for(var i=0;i<data.length;i++){
					$('#customerList').append('<a href="#" id="'+data[i].id+'" class="list-group-item customerItems"><span class="badge">'+data[i].customerType+'</span>'+data[i].name+'</a>');
				}
				$('.customerItems').on('click',function(){
					$('.customerItems').removeClass('active');
					$('#rentalDetails').hide();
					$('#rentalProcessing').show();
					$(this).addClass('active');
					customerId=$(this).attr('id');
					$.ajax({
						url:'getRentedCars?customerId='+$(this).attr('id'),
						type:'get',
						success: function(data){
							console.log(data);
							$('#carList').html('');
							$('#carProcessing').hide();
							for(var i=0;i<data.length;i++){
								$('#carList').append('<a href="#" id="'+data[i].vehicleId+'" class="list-group-item carItems">'+
										'<div class="list-group-item-heading"><div class="row"><div class="col-lg-12"><h4 style="font-weight:bold">'+data[i].model+' <span style="font-size:10px">('+data[i].carType.carType+')</span></h4></div></div></div>'+
										'<div class="list-group-item-text"><div class="row"><div class="col-lg-4">Year: '+data[i].year+'</div><div class="col-lg-4">Vehicle No: '+data[i].vehicleNo+'</div><div class="owner" id="'+data[i].owner.ownerId+'" class="col-lg-4">Owner: '+data[i].owner.name+'</div></div>'+
										'<div class="row"><div class="col-lg-4 dailyRate">Daily Rate: '+data[i].carType.dailyRate+'</div><div class="col-lg-4 weeklyRate">Weekly Rate: '+data[i].carType.weeklyRate+'</div></div></div>'+
								'</a>');
							}
							$('.carItems').on('click',function(){
								$('.carItems').removeClass('active');
								$(this).addClass('active');
								$.ajax({
									url:'getRentalDetails?customerId='+customerId+'&vehicleId='+$(this).attr('id'),
									type : 'GET',
									success: function(data){
										console.log(data);
										$('#rentalDetails').show();
										$('#rentalProcessing').hide();
										rentalId=data.rentalId;
										$('#receipt').html('Reciept No: #'+data.rentalId);
										$('#startDate').html('Start Date: '+data.startDate);
										$('#endDate').html('Return Date: '+data.returnDate);
										$('#noOfRental').html('Duration: '+data.noOfRentalType+' '+data.rentalType);
										$('#amountDue').html('Amount Due: '+data.amountDue);
									},
									error: function(data){
										
									}
								});
							});
						},
						error:function(){
							$('#carProcessing').hide();
						}
					});
				});
			},
			error:function(){
				$('#customerProcessing').hide();
			}
		});
		$('#returnCar').on('click',function(){
			$.ajax({
				url: 'returnCar?rentalId='+rentalId,
				type : 'GET',
				success: function(data){
					location.href="returncar";
				}
			});
		});
	});
	</script>
</body>