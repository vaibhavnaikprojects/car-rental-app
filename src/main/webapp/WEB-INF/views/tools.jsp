<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Tools</title>
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
    				<div class="panel-heading">Import Data from Excel Sheet</div>
    				<div class="panel-body">
    					<div class="row">
    						<div class="col-lg-offset-3 col-lg-5" style="padding-right: 0px">
    								<input type="file" id="file" class="filestyle" data-buttonBefore="true" data-btnClass="btn-default"  data-text="Find file">
    						</div>
    						<div class="col-lg-1" style="padding-left: 0px">
    							<button id="uploadTemplate" type="button" 
    							class="btn btn-primary btn-block" 
    							data-singleton="true" 
    							data-toggle="confirmation" data-placement="right"
    							data-btn-ok-label="Upload" data-btn-ok-icon="glyphicon glyphicon-share-alt"
						        data-btn-ok-class="btn-success"
						        data-btn-cancel-label="Cancel" data-btn-cancel-icon="glyphicon glyphicon-ban-circle"
						        data-btn-cancel-class="btn-default"
						        data-singleton="true"
						        data-title="Warning" data-content="This will delete all the present data. Are you sure?"
    							>upload</button>
    						</div>
    						<div id="message" class="col-lg-3">
    						</div>
    					</div>
    					<div class="row">
    						<div class="col-lg-offset-3 col-lg-3 text-right">
    							<a href="#" id="systemdataset"
    							data-singleton="true" 
    							data-toggle="confirmation" data-placement="bottom"
    							data-singleton="true"
    							data-btn-ok-label="Upload" data-btn-ok-icon="glyphicon glyphicon-share-alt"
						        data-btn-ok-class="btn-success"
						        data-btn-cancel-label="Cancel" data-btn-cancel-icon="glyphicon glyphicon-ban-circle"
						        data-btn-cancel-class="btn-default"
						        data-title="Warning" data-content="This will delete all the present data. Are you sure?"
    							>Use System Data</a>
    						</div>
    						<div class="col-lg-3">
    							<a href="#" id="downloadtemplate">Download Template</a>
    						</div>
    					</div>
    				</div>
    		</div>
    	</div>
    </div>
    </div>
    <script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap-filestyle.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap-confirmation.min.js"/>"></script>
	<script src="<c:url value="/resources/js/servicecalls/tools.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#toolsHeader').addClass("nav-active");
	});
	</script>
</body>