<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="my.scheduler">
<head>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.13/angular.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.0.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.16/angular-route.js"></script>
<script type="text/javascript" src="../resources/js/menu.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script type="text/javascript">
	function submitMonth(event) {
		var target = event.target || event.srcElement;
		var month = event.target.innerHTML;
		document.getElementById('month').value = month;
		document.forms["schForm"].submit();
	}
</script>
</head>
<body>
	<form action="../HomePageServlet" method="post" name="schForm">
		<div ng-controller="DropdownCtrl">
			<div class="btn-group" dropdown dropdown-append-to-body>
				<button type="button" class="btn btn-primary dropdown-toggle"
					dropdown-toggle>
					Dropdown on Body <span class="caret"></span>
				</button>
				<ul id="myList" class="dropdown-menu" role="menu"
					onclick="submitMonth(event)">
					<li><a href="#">January</a></li>
					<li><a href="#">February</a></li>
					<li><a href="#">March</a></li>
					<li><a href="#">April</a></li>
					<li><a href="#">May</a></li>
					<li><a href="#">June</a></li>
					<li><a href="#">July</a></li>
					<li><a href="#">August</a></li>
					<li><a href="#">September</a></li>
					<li><a href="#">October</a></li>
					<li><a href="#">November</a></li>
					<li><a href="#">December</a></li>
				</ul>
			</div>
			<input id="month" type="hidden" value="" name="month">
	</form>
</body>
</html>