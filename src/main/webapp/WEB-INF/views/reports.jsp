<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Reports</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	<link
	href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-lg-12">
    			<ul class="nav nav-tabs nav-justified">
    				<li role="presentation" class="active"><a  data-toggle="tab" href="#carReports">Car Type Reports</a></li>
					<li role="presentation"><a data-toggle="tab" href="#ownerReports">Owner Reports</a></li>
					<li role="presentation"><a data-toggle="tab" href="#customerReports">Owner Car Reports</a></li>
				</ul>
				<div class="tab-content">
					<div id="carReports" class="tab-pane fade in active">
						<jsp:include page="reportCar.jsp"></jsp:include>
					</div>
					<div id="ownerReports" class="tab-pane fade">
						<jsp:include page="reportOwner.jsp"></jsp:include>
					</div>
					<div id="customerReports" class="tab-pane fade">
						<jsp:include page="reportCustomer.jsp"></jsp:include>
					</div>
				</div>
    		</div>
    	</div>
    </div>
    <script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/moment.js"/>"></script>
	<script
		src="<c:url value="/resources/js/application/bootstrap-datetimepicker.min.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#reportHeader').addClass("nav-active");
		$.ajax({
			url:'owners',
			type:'get',
			success: function(gridData){
				for(i=0;i<gridData.length;i++){
					$('#owners').append('<option value="'+gridData[i].ownerId+'">'+gridData[i].name+'</option');
					$('#ownerCars').append('<option value="'+gridData[i].ownerId+'">'+gridData[i].name+'</option');
				}
			}
		});
		$('#ownerCars').on('change',function(){
			ownerId=$('#ownerCars').val();
			console.log(ownerId);
			$('#cars').html('');
			$.ajax({
				url:'ownercars?ownerId='+ownerId,
				type:'get',
				success: function(gridData){
					console.log(gridData);
					for(var i=0;i<gridData.length;i++)
						$('#cars').append('<option value="'+gridData[i].vehicleId+'">'+gridData[i].model+'</option');
				}
			});
		});
		$.ajax({
			url:'rate',
			type:'get',
			success: function(gridData){
				for(i=0;i<gridData.length;i++)
					$('#carTypes').append('<option value="'+gridData[i].carTypeId+'">'+gridData[i].carType+'</option');
			}
		});
		$('#carTypeStartDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#carTypeEndDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#ownerStartDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#ownerEndDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#ownerCarStartDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#ownerCarEndDatetimepicker').datetimepicker({
			format: 'MM/DD/YYYY'
		});
		$('#carTypeReport').on('click',function(){
			var sDate = new Date($('#carTypeStartDate').val());
			var resultDate= new Date();
			resultDate.setDate(sDate.getDate() + parseInt(7));
			$('#carTypeEndDate').datetimepicker({
			    date: resultDate,
			    format: 'MM/DD/YYYY'
			});
			$('#carTypeTotalAmount').html('');
			$('#carTypeList').html('');
			$.ajax({
				url: 'carTypeReport?startDate='+$('#carTypeStartDate').val()+'&endDate='+$('#carTypeEndDate').val()+'&carTypeId='+$('#carTypes').val(),
				type: 'GET',
				success: function(data){
					console.log(data);
					var amount=0;
					for(var i=0;i<data.length;i++){
						$('#carTypeList').append('<a href="#" id="'+data[i].vehicleId+'" class="list-group-item carItems">'+
								'<div class="list-group-item-heading"><div class="row"><div class="col-lg-12"><h4 style="font-weight:bold">'+data[i].car.model+' <span style="font-size:10px">('+data[i].car.vehicleNo+')</span></h4></div></div></div>'+
								'<div class="list-group-item-text"><div class="row"><div class="col-lg-4">Rental Duration: '+data[i].noOfRentalType+'</div><div class="col-lg-4">Rental Type: '+data[i].rentalType+'</div><div class="owner" id="'+data[i].owner.ownerId+'" class="col-lg-4">Owner: '+data[i].owner.name+'</div></div>'+
								'<div class="row"><div class="col-lg-4 dailyRate">Amount: '+data[i].amountDue+'</div><div class="col-lg-4 weeklyRate">Dates: '+data[i].startDate+' - '+data[i].returnDate+'</div></div></div>'+
						'</a>');
						amount+=data[i].amountDue;
					}
					$('#carTypeTotalAmount').html("Total Amount: "+amount);
				},
				error: function(){
					
				}
			});
		});
		$('#ownerReport').on('click',function(){
			var sDate = new Date($('#ownerStartDate').val());
			var resultDate= new Date();
			resultDate.setDate(sDate.getDate() + parseInt(7));
			$('#ownerEndDate').datetimepicker({
			    date: resultDate,
			    format: 'MM/DD/YYYY'
			});
			$('#ownerList').html('');
			$('#ownerTotalAmount').html('');
			$.ajax({
				url: 'ownerReport?startDate='+$('#ownerStartDate').val()+'&endDate='+$('#ownerEndDate').val()+'&ownerId='+$('#owners').val(),
				type: 'GET',
				success: function(data){
					console.log(data);
					var totalOwnner=0;
					for(var i=0;i<data.length;i++){
						$('#ownerList').append('<a href="#" id="'+data[i].vehicleId+'" class="list-group-item carItems">'+
								'<div class="list-group-item-heading"><div class="row"><div class="col-lg-12"><h4 style="font-weight:bold">'+data[i].car.model+' <span style="font-size:10px">('+data[i].car.vehicleNo+')</span></h4></div></div></div>'+
								'<div class="list-group-item-text"><div class="row"><div class="col-lg-4">Rental Duration: '+data[i].noOfRentalType+'</div><div class="col-lg-4">Rental Type: '+data[i].rentalType+'</div><div class="owner" id="'+data[i].owner.ownerId+'" class="col-lg-4">Owner: '+data[i].owner.name+'</div></div>'+
								'<div class="row"><div class="col-lg-4 dailyRate">Amount: '+data[i].amountDue+'</div><div class="col-lg-4 weeklyRate">Dates: '+data[i].startDate+' - '+data[i].returnDate+'</div></div></div>'+
						'</a>');
						totalOwnner+=data[i].amountDue;
					}
					$('#ownerTotalAmount').html('Total Amount: '+totalOwnner);
				},
				error: function(){
					
				}
			});
		});
		$('#ownerCarReport').on('click',function(){
			var sDate = new Date($('#ownercarTypeStartDate').val());
			var resultDate= new Date();
			resultDate.setDate(sDate.getDate() + parseInt(7));
			$('#ownercarTypeEndDate').datetimepicker({
			    date: resultDate,
			    format: 'MM/DD/YYYY'
			});
			$('#carOwnerList').html('');
			$('#carOwnerTotalAmount').html('');
			$.ajax({
				url: 'ownerCarReport?startDate='+$('#ownercarTypeStartDate').val()+'&endDate='+$('#ownercarTypeEndDate').val()+'&ownerId='+$('#ownerCars').val()+'&carId='+$('#cars').val(),
				type: 'GET',
				success: function(data){
					console.log(data);
					var amount=0;
					for(var i=0;i<data.length;i++){
						$('#carOwnerList').append('<a href="#" id="'+data[i].vehicleId+'" class="list-group-item carItems">'+
								'<div class="list-group-item-heading"><div class="row"><div class="col-lg-12"><h4 style="font-weight:bold">'+data[i].car.model+' <span style="font-size:10px">('+data[i].car.vehicleNo+')</span></h4></div></div></div>'+
								'<div class="list-group-item-text"><div class="row"><div class="col-lg-4">Rental Duration: '+data[i].noOfRentalType+'</div><div class="col-lg-4">Rental Type: '+data[i].rentalType+'</div><div class="owner" id="'+data[i].owner.ownerId+'" class="col-lg-4">Owner: '+data[i].owner.name+'</div></div>'+
								'<div class="row"><div class="col-lg-4 dailyRate">Amount: '+data[i].amountDue+'</div><div class="col-lg-4 weeklyRate">Dates: '+data[i].startDate+' - '+data[i].returnDate+'</div></div></div>'+
						'</a>');
						amount+=data[i].amountDue;
					}
					$('#carOwnerTotalAmount').html('Total Amount: '+amount);
				},
				error: function(){
					
				}
			});
		});
	});
	
	</script>
</body>