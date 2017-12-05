<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Vaibhav Naik">
	<title>Car Rental::Info</title>
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
    			<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a  data-toggle="tab" href="#problemStatement">Problem Statement</a></li>
					<li role="presentation"><a data-toggle="tab" href="#eerDiagram">EER Diagram</a></li>
					<li role="presentation"><a data-toggle="tab" href="#schemadiagram">Schema Diagram</a></li>
					<li role="presentation"><a data-toggle="tab" href="#createStatements">Create Statements</a></li>
					<li role="presentation"><a data-toggle="tab" href="#aboutme">About Me</a></li>
				</ul>
				<div class="tab-content">
					<div id="problemStatement" class="tab-pane fade in active">
						<div class="panel panel-primary">
    				<div class="panel-body" style="height: 500px;overflow-y:auto;text-align: justify;">
    					<p>In this project, you will design and implement a database for keeping track of information about a car rental company. You will first design an EER schema diagram for this database application. Then, you will map the EER schema into a relational database schema and implement it on ORACLE (you can also use MySQL if you have your own version). Finally, you will load some data into your database, and create some queries and update transactions.</p>
						<p>Assume that the following requirements were collected for this application:</p>
						<ol>
							<li>The database keeps track of CUSTOMERs. Customers can be individuals or companies. Each CUSTOMER has a unique IdNo (assume this is a unique integer generated by the system for each new CUSTOMER, such as 1, 2, 3,...), a Name (assume this is string consisting of an single initial and last name only for simplicity, such as "J.Smith" or "R.Wong", for individual or company name), and a Phone (a string of 12 characters such as "817-272-3000").</li>
							<li>The database keeps track of CARs available for rental, which are categorized based on their type. There are six main types: COMPACT, MEDIUM, LARGE, SUV (Sports Utility Vehice), TRUCK, and VAN. Each type of car has its own DailyRate and WeeklyRate (assume all cars of the same type have the same rental rates). For simplicity, we will assume that there is only one rental location.</li>
							<li>Each CAR has a VehicleID (a unique number for each car - assume it is a number 1001, 1002, 1003,...), Model (Chevy, Toyota, Ford,...), and Year (2015, 2014,...).</li>
							<li>Each car is either owned by the rental company, a bank or an individual owner who leased the vehicle to the company on a long term basis. Choose suitable attributes for these different type of owners to identify the right owner of a vehicle.</li> 
							<li>The database will keep track of the current (active) RENTALs as well as scheduled RENTALs of each CAR. The are two types of RENTAL: DAILY and WEEKLY. For each DAILY RENTAL, the information kept will include the specific CAR and CUSTOMER as well as the NoOfDays, StartDate, and ReturnDate (the ReturnDate can be calculated from the StartDate and NoOfDays). For each WEEKLY RENTAL, the information kept will include the specific CAR and CUSTOMER as well as the NoOfWeeks, StartDate, and ReturnDate (the ReturnDate can be calculated from the StartDate and NoOfWeeks). Each rental will also have the AmountDue for the rental, which is a derived value that can be calculated from the other information.</li>
							<li>The database will also keep track of which CARs are available for rental during which periods.</li>
						</ol>
						<p>You will first design an EER schema diagram based upon the RENTALs database requirements specified above, and create an EER schema diagram and documentation report describing your design choices. As part of this assignment, you should identify any missing or incomplete requirements, and explicitly state them in your documentation. You should also explicitly state any assumptions you made that were not part of the requirements listed above.</p>
						<p>The second part of the assignment will be to map the EER schema design to a relational database schema, and create the tables corresponding to the relational schema using the ORACLE DBMS (or MySQL). You will add to your report a listing of the CREATE TABLE statements. Specify as many constraints (key, referential integrity) as you can in the relational schema. You should state the choices you made during the EER-to-relational mapping, and the reasons for your choices.</p>
						<p>The third part of the project is to load some data into the database, and apply certain update transactions and retrieval queries. You will create your own data. Include at least 10 customers, and at least 20 cars of different types.</p>
						<p>The following are the tasks for the third part of the project:</p>
						<ol>
							<li>Load some initial data (as discussed above) into the database tables that you created in Part 2 of the assignment. You can either write a loading program, or use SQL/PLUS (insert command), or use SQL/FORMS. Your data should be kept in files so that it can easily be reloaded during debugging. The data format should be designed by you. (Note: You can also use the transactions created by you in item 3 below to load some of the data).</li>
							<li>Write queries to retrieve and print all the data you entered. Try to print the data so that it is easy to understand (for example, print appropriate headings, such as: Customers, Compact Cars, SUVs, Current Rentals, etc.).</li>
							<li>Write a query that will prepare a report for weekly earnings by owner, by car type and per car unit that owner owns within that car type.</li>
							<li>Write the following database update transactions using either PRO*C or JAVA/JDBC or PHP or some other programming language or scripting language.</li>
							<li>The first transaction is to add information about a new CUSTOMER.</li>
							<li>The second transaction is to add all the information about a new CAR.</li>
							<li>The third transaction is to add all the information about a new RENTAL reservation (this must find a free car of the appropriate type for the rental period).</li>
							<li>The fourth transaction is to handle the return of a rented car. This transaction should print the total customer payment due for the rental, and enter it in the database.</li>
							<li>The fifth transaction is to enter or update the rental rates (daily and weekly) for a type of car.</li>
							<li>Each transaction should have a user friendly interface to enter the information needed by the transaction. This can either be a Web-based interface, a command line interface, or a forms interface.</li>
							<li>Test your transactions by adding a few new customers, cars, reservations, by changing some rental rates and reservations rates.</li>
						</ol>    					
    				</div>
    					</div>
					</div>
					<div id="eerDiagram" class="tab-pane fade">
						<div class="panel panel-primary">
		    				<div class="panel-body" style="text-align: center;">
		    					<img src="<c:url value="/resources/images/EER Diagram.jpg"/>" width="80%" height="90%" />
		    				</div>
		    			</div>
					</div>
					<div id="schemadiagram" class="tab-pane fade">
						<div class="panel panel-primary">
		    				<div class="panel-body">
		    					<img src="<c:url value="/resources/images/schemaDiagram.jpg"/>" width="80%" height="70%"/>
		    				</div>
		    			</div>
					</div>
					
					<div id="createStatements" class="tab-pane fade">
						<div class="panel panel-primary">
		    				<div class="panel-body">
		    					<div class="row">
		    						<div class="col-lg-6">
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Customer Type</div>
		    								<div class="panel-body">
		    									CREATE TABLE CUSTOMERTYPE(<br/>
													customerTypeId INT NOT NULL AUTO_INCREMENT,<br/>
													customerType VARCHAR(10) NOT NULL,<br/>
													CONSTRAINT PK_CUSTOMERTYPE PRIMARY KEY (customerTypeId)<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Customer</div>
		    								<div class="panel-body">
		    									CREATE TABLE CUSTOMER(<br/>
													id INT NOT NULL AUTO_INCREMENT,<br/>
													name VARCHAR(50) NOT NULL,<br/>
													customerTypeId INT NOT NULL,<br/>
													phone VARCHAR(12) NOT NULL,<br/>
													status VARCHAR(10) NOT NULL,<br/>
													joiningDate DATE,<br/>
													leavingDate DATE,<br/>
													CONSTRAINT PK_CUSTOMER PRIMARY KEY(id),<br/>
													CONSTRAINT FK_CUSTOMER_CUSTOMERTYPE FOREIGN KEY(customerTypeId) REFERENCES CUSTOMERTYPE(customerTypeId) ON UPDATE CASCADE ON DELETE CASCADE<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Car Type Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE CARTYPE(<br/>
													carTypeId INT NOT NULL AUTO_INCREMENT,<br/>
													carType VARCHAR(20) NOT NULL,<br/>
													dailyRate DOUBLE NOT NULL,<br/>
													weeklyRate DOUBLE NOT NULL,<br/>
													CONSTRAINT PK_CARTYPE PRIMARY KEY(carTypeId)<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Car Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE CAR(<br/>
													vehicleId INT NOT NULL AUTO_INCREMENT,<br/>
													model VARCHAR(50) NOT NULL,<br/>
													year INT NOT NULL,<br/>
													vehicleNo VARCHAR(50) NOT NULL,<br/>
													carTypeId INT NOT NULL,<br/>
													status VARCHAR(10) NOT NULL,<br/>
													joiningDate DATE,<br/>
													leavingDate DATE,<br/>
													rentalLocation VARCHAR(50) NOT NULL,<br/>
													ownerId INT NOT NULL,<br/>
													CONSTRAINT PK_CAR PRIMARY KEY (vehicleId),<br/>
													CONSTRAINT FK_CAR_CARTYPE FOREIGN KEY(carTypeId) REFERENCES CARTYPE(carTypeId) ON UPDATE CASCADE ON DELETE CASCADE,<br/>
													CONSTRAINT FK_CAR_OWNER FOREIGN KEY(ownerId) REFERENCES OWNER(ownerId) ON UPDATE CASCADE ON DELETE CASCADE<br/>
												);

		    								</div>
		    							</div>
		    						</div>
		    						<div class="col-lg-6">
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Owner Type Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE OWNERTYPE(<br/>
													ownerTypeId INT NOT NULL AUTO_INCREMENT,<br/>
													ownerType VARCHAR(50) NOT NULL,<br/>
													CONSTRAINT PK_CUSTOMERTYPE PRIMARY KEY(ownerTypeId)<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Owner Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE OWNER(<br/>
													ownerId INT NOT NULL AUTO_INCREMENT,<br/>
													ownerTypeId INT NOT NULL,<br/>
													name VARCHAR(50) NOT NULL,<br/>
													address VARCHAR(200) NOT NULL,<br/>
													status VARCHAR(10) NOT NULL,<br/>
													joiningDate DATE,<br/>
													leavingDate DATE,<br/>
													CONSTRAINT PK_OWNER PRIMARY KEY(ownerId),<br/>
													CONSTRAINT FK_OWNER_OWNERTYPE FOREIGN KEY (ownerTypeId) REFERENCES OWNERTYPE(ownerTypeId) ON UPDATE CASCADE ON DELETE CASCADE<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Rental Type Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE RENTALTYPE(<br/>
													rentalTypeId INT NOT NULL AUTO_INCREMENT,<br/>
													rentalType VARCHAR(20) NOT NULL,<br/>
													CONSTRAINT PK_RENTALTYPE PRIMARY KEY(rentalTypeId)<br/>
												);
		    								</div>
		    							</div>
		    							<div class="panel panel-primary">
		    								<div class="panel-heading">Rental Table</div>
		    								<div class="panel-body">
		    									CREATE TABLE RENTAL(<br/>
													rentalId INT NOT NULL AUTO_INCREMENT,<br/>
													startDate DATE NOT NULL,<br/>
													endDate DATE NOT NULL,<br/>
													noOfRentalType INT NOT NULL DEFAULT 0,<br/>
													amountDue DOUBLE NULL DEFAULT 0,<br/>
													status VARCHAR(10) NOT NULL,<br/>
													createdDate DATE NOT NULL,<br/>
													closingDate DATE NULL,<br/>
													rentalTypeId INT NOT NULL,<br/>
													vehicleId INT NOT NULL,<br/>
													ownerId INT NOT NULL,<br/>
													customerId INT NOT NULL,<br/>
													CONSTRAINT PK_RENTAL PRIMARY KEY (rentalId),<br/>
													CONSTRAINT FK_RENTAL_RENTALTYPE FOREIGN KEY (rentalTypeId) REFERENCES RENTALTYPE(rentalTypeId) ON UPDATE CASCADE ON DELETE NO ACTION,<br/>
													CONSTRAINT FK_RENTAL_CUSTOMER FOREIGN KEY (customerId) REFERENCES CUSTOMER(id) ON UPDATE CASCADE ON DELETE NO ACTION,<br/>
													CONSTRAINT FK_RENTAL_CAR FOREIGN KEY (vehicleId) REFERENCES CAR(vehicleId) ON UPDATE CASCADE ON DELETE NO ACTION,<br/>
													CONSTRAINT FK_RENTAL_OWNER FOREIGN KEY (ownerId) REFERENCES OWNER(ownerId) ON UPDATE CASCADE ON DELETE NO ACTION<br/>
												);
		    								</div>
		    							</div>
		    						</div>
		    					</div>	
		    				</div>
		    			</div>
					</div>
					<div id="aboutme" class="tab-pane fade">
						<div class="panel panel-primary">
		    				<div class="panel-body">
		    					<div class="row">
		    						<div class="col-lg-12">
		    							<h3 class="text-center">Vaibhav Naik</h3>
		    						</div>
		    					</div>
		    					<div class="row" style="padding-top: 20px">
		    						<div class="col-lg-2 col-lg-offset-2">
		    							<h4>UTA ID</h4>
		    							<h5>1001518044</h5>
		    						</div>
		    						<div class="col-lg-2">
		    							<h4>Email</h4>
		    							<h5><a href="mailto:vaibhav.naik@mavs.uta.edu">vaibhav.naik@mavs.uta.edu</a></h5>
		    						</div>
		    						<div class="col-lg-2">
		    							<h4>Phone</h4>
		    							<h5>682-414-9593</h5>
		    						</div>
		    						<div class="col-lg-2">
		    							<h4>Web</h4>
		    							<h5><a href="http://www.vaibhavsnaik.com" target="_blank">www.vaibhavsnaik.com</a></h5>
		    						</div>
		    					</div>
		    					<div class="row" style="padding-top: 20px">
		    						<div class="col-lg-12 text-center">
		    							<span style="margin-right: 20px"><a href="https://www.linkedin.com/in/vaibhav-naik/" target="_blank"><i class="fa fa-linkedin-square fa-3x"></i></a></span>
		    							<span style="margin-right: 20px"><a href="https://github.com/vaibhavnaikprojects" target="_blank"><i class="fa fa-github fa-3x"></i></a></span>
		    							<span><a href="https://www.facebook.com/vaibhavsnaik09" target="_blank"><i class="fa fa-facebook-square fa-3x"></i></a></span>
		    						</div>
		    					</div>
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
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#infoHeader').addClass("nav-active");
	});
	</script>
</body>