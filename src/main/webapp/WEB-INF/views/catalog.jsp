<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Catalog</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/ui.jqgrid-bootstrap.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-lg-12">
    			<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a  data-toggle="tab" href="#carCatalog">Car Catalog</a></li>
					<li role="presentation"><a data-toggle="tab" href="#ownerCatalog">Owner Catalog</a></li>
					<li role="presentation"><a data-toggle="tab" href="#customerCatalog">Customer Catalog</a></li>
				</ul>
				<div class="tab-content">
					<div id="carCatalog" class="tab-pane fade in active">
						<div class="panel panel-primary">
							<div class="panel-body center-block">
								<table id="carjqGrid" class="center-block"></table>
		    					<div id="carjqGridPager"></div>
	    					</div>
    					</div>
						</div>
						<div id="ownerCatalog" class="tab-pane fade">
							<div class="panel panel-primary">
								<div class="panel-body">
									<table id="ownerjqGrid"></table>
		    						<div id="ownerjqGridPager"></div> 
		    					</div>
		    				</div> 
						</div>
						<div id="customerCatalog" class="tab-pane fade">
							<div class="panel panel-primary">
								<div class="panel-body">
									<table id="customerjqGrid"></table>
		    						<div id="customerjqGridPager"></div> 
		    					</div>
		    				</div> 
						</div>
				</div>
    		</div>
    	</div>
    </div>
    <script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/grid.locale-en.js"/>"></script>
    <script src="<c:url value="/resources/js/application/jquery.jqGrid.min.js"/>"></script>
    <script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script>
	$.jgrid.defaults.width = '100%';
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#catalogHeader').addClass("nav-active");
	});
	</script>
	<script src="<c:url value="/resources/js/servicecalls/catalog.js"/>"></script>
	<style type="text/css">
		#carjqGridPager tbody, td{
			font-size: 12px !important;
		}
		#ownerjqGrid{
			font-size: 12px !important;
		}
		#customerCatalog{
			font-size: 12px !important;
		}
	</style>
</body>