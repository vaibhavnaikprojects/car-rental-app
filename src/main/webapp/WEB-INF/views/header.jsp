<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <nav class="navbar navbar-default header-color" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed nav-button" data-toggle="collapse" data-target="#navbar-header-app" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="navbar-brand" style="color: white">Car Rental</span>
        </div>
        <div id="navbar-header-app" class="navbar-collapse collapse">
          <ul id="header-navbar" class="nav navbar-nav navbar-left header-color">
            <li id="rentHeader"><a href="rentcar" style="text-decoration: none; color: white"><i class="fa fa-car"></i> Rent Car</a></li>
            <li id="returnHeader"><a href="returncar" style="text-decoration: none; color: white"><i class="fa fa-truck"></i> Return Car</a></li>
            <li id="catalogHeader"><a href="catalog" style="text-decoration: none; color: white"><i class="fa fa-search"></i> Catalog</a></li>
            <li id="reportHeader"><a href="reports" style="text-decoration: none; color: white"><i class="fa fa-book"></i> Reports</a></li>
            <li id="toolsHeader"><a href="tools" style="text-decoration: none; color: white"><i class="fa fa-cog"></i> Tools</a></li>
            <li id="infoHeader"><a href="info" style="text-decoration: none; color: white"><i class="fa fa-info-circle"></i> Info</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          </ul>
        </div>
        </div>
    </nav>