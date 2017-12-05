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
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
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
							<div class="col-lg-5">
								<h4 id="rentSuccess"></h4>
							</div>
							<%-- <div class="col-lg-5 col-lg-offset-5">
								<h4 style="font-weight: bold;">
									Current Date: <span id="currentDate">${applicationDate}</span>
								</h4>
							</div>
							<div class="col-lg-2">
								<button type="button" id="changeDate"
									class="btn btn-default btn-block"
									data-target="#applicationDateModal" data-toggle="modal">Change
									Date</button>
							</div> --%>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<div class="panel panel-primary">
									<div class="panel-heading">Select Customer</div>
									<div class="panel-body"
										style="height: 400px; overflow-y: auto; padding: 0px">
										<div id="customerProcessing"
											style="position: absolute; top: 50%; left: 45%">
											<i class="fa fa-spinner fa-spin fa-2x fa-fw"></i>
										</div>
										<div id="customerList" class="list-group"></div>
									</div>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="panel panel-primary">
									<div class="panel-heading">Rent Info</div>
									<div class="panel-body" style="height: 400px">
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-sm-12">
													<select class="form-control" id="rentalType"
														name="rentalType">
														<option value="" selected="selected" disabled="disabled">Rental
															Type</option>
														<option value="Daily">Daily</option>
														<option value="Weekly">Weekly</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<div class='input-group date' id='startDatetimepicker'>
														<input type="text" class="form-control" id="startDate"
															name="c" placeholder="Start Date" /> <span
															class="input-group-addon"> <span
															class="glyphicon glyphicon-calendar"></span>
														</span>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<input type="text" class="form-control" id="noOfRentalType"
														name="noOfRentalType" placeholder="No. Of Days/Weeks" />
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<div class='input-group date' id='endDatetimepicker'>
														<input type="text" class="form-control" id="endDate"
															name="endDate" placeholder="End Date" readonly="readonly" />
														<span class="input-group-addon"> <span
															class="glyphicon glyphicon-calendar"></span>
														</span>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<input type="text" class="form-control" id="amountDue"
														name="amountDue" readonly="readonly" placeholder="Estimated Amount" />
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-8">
													<h5 id="messageCar"></h5>
												</div>
												<div class="col-sm-4">
													<button type="button" id="selectCarBtn"
														class="btn btn-default">Get Car</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-primary">
									<div class="panel-heading">Select Car</div>
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
						</div>
						<div class="row">
							<div class="col-lg-5">
								
							</div>
							<div class="col-lg-2">
								<button type="button" id="rentCar" name="rentCar"
									class="btn btn-block btn-primary">Rent Car</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="applicationDateModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Select Current Date</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<div class="form-group">
									<div class="col-sm-12">
										<div class='input-group date' id='endDatetimepicker'>
											<input type="text" class="form-control" id="applicationDate"
												placeholder="Select Application Date" /> <span
												class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="closeSelect" type="button" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<button id="addApplicationDateBtn" type="button"
						class="btn btn-primary" data-dismiss="modal">Submit</button>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/moment.js"/>"></script>
	<script
		src="<c:url value="/resources/js/application/bootstrap-datetimepicker.min.js"/>"></script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#rentHeader').addClass("nav-active");
		/* if($('#currentDate').html()=="")
			$('#applicationDateModal').modal('show'); */
	});
	$('#addApplicationDateBtn').on('click',function(){
		console.log($('#applicationDate').val());
		$.ajax({
			url:'applicationDate?applicationDate='+$('#applicationDate').val(),
			async: false,
			type:'get',
			success: function(data){
			}
		});
		$('#currentDate').html($('#applicationDate').val());
	});
	$('#selectCarBtn').on('click',function(){
		var rentalType=$('#rentalType').val();
		var startDate=$('#startDate').val();
		var no=$('#noOfRentalType').val();
		if(rentalType!=null && startDate!=null && no!=null ){
			if(rentalType=='Daily'){
				var sDate = new Date(startDate);
				var resultDate= new Date();
				resultDate.setDate(sDate.getDate() + parseInt(no));
				$('#endDate').datetimepicker({
				    date: resultDate,
				    format: 'MM/DD/YYYY'
				});
			}
			else{
				var result1 = new Date(startDate);
				result1.setDate(result1.getDate() + parseInt(no*7));
				$('#endDate').datetimepicker({
				    date: result1,
				    format: 'MM/DD/YYYY'
				});
			}
			$.ajax({
				url:'rentcars?startDate='+startDate+'&endDate='+$('#endDate').val(),
				type:'get',
				success: function(data){
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
						if($('#rentalType').val()=="Daily"){
							var rate=$(this).find('.dailyRate').html().split(':')[1].trim();
							console.log(rate);
							$('#amountDue').val(rate*parseInt($('#noOfRentalType').val()));
						}
						else{
							var rate=$(this).find('.weeklyRate').html().split(':')[1].trim();
							console.log(rate);
							$('#amountDue').val(rate*parseInt($('#noOfRentalType').val()));	
						}
					});
				},
				error:function(){
					$('#carProcessing').hide();
				}
			});
		}
		else{
			$('#messageCar').html('Invalid Data');
		}
	});
	
	$('#rentCar').on('click',function(){
		var customerId=$(".customerItems.active").attr('id');
		var vehicleId=$(".carItems.active").attr('id');
		var rentalType=$('#rentalType').val();
		var startDate=$('#startDate').val();
		var no=$('#noOfRentalType').val();
		var endDate=$('#endDate').val();
		var ownerId=$(".carItems.active").find('.owner').attr('id');
		$.ajax({
			url:encodeURI('rentingcar?customerId='+customerId+'&vehicleId='+vehicleId+'&rentalType='+rentalType+'&startDate='+startDate+'&endDate='+endDate+'&no='+no+'&ownerId='+ownerId+'&amountDue='+$('#amountDue').val()),
			type:'get',
			success: function(data){
				$('#rentSuccess').html("Car Rented, Be there on time!!");
				$('#rentalType').val('');
				$('#startDate').val('');
				$('#noOfRentalType').val('');
				$('#endDate').val('');
				$('.customerItems').removeClass('active');
				$('#carList').html('');
				$('#carProcessing').show();
			}
		});
	});
	</script>
</body>
</html>