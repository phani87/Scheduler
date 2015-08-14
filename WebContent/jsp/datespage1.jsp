<%@page import="java.io.Console"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="org.phani.scheduler.vo.*"%>
<%@ page import="org.phani.scheduler.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/SchedularUpdated/resources/js/menu1.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script
	src="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">

<script type="text/javascript"
	src="/SchedularUpdated/resources/js/dragSelect.js"></script>
<link rel="stylesheet" type="text/css"
	href="/SchedularUpdated/resources/css/dragSelect.css">
<link rel="stylesheet" type="text/css"
	href="/SchedularUpdated/resources/css/table.css">
<title>Something</title>
<style>
body {
	font-size: 140%;
}
</style>

<script>
	/* $(document).ready(function() {
	 $('#data').dataTable();
	 } ); */
</script>

<script type="text/javascript">
	function onSubmitTime() {
		var x = document.getElementsByClassName("highlighted");
		var arr = [];
		for (i = 0; i < x.length; i++) {
			var id = x[i].id;
			arr.push(id);

		}
		document.getElementById('hiddenArr').value = arr;
		document.forms["tableForm"].submit();

	}
</script>

</head>
<body>
	<% Map<Integer, MonthVo> monthMap = new HashMap(); 
	   monthMap = (HashMap<Integer, MonthVo>) request.getAttribute("entireMonth");
	   String month = (String) request.getAttribute("month");
	%>
	<table id="data" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Date</th>
				<th>Day</th>
				<th>9:00AM - 9:30 AM</th>
				<th>9:31 AM - 10:00 AM</th>
				<th>10:01 AM - 10:30 AM</th>
				<th>10:31 AM - 11:00 AM</th>
				<th>11:01 AM - 11:30 AM</th>
				<th>11:31 AM - 12:00 AM</th>
				<th>12:01 PM - 12:30 PM</th>
				<th>12:31 PM - 1:00 PM</th>
				<th>1:01 PM - 1:30 PM</th>
				<th>1:31 PM - 2:00 PM</th>
				<th>2:01 PM - 2:30 PM</th>
				<th>2:31 PM - 3:00 PM</th>
				<th>3:01 PM - 3:30 PM</th>
				<th>3:31 PM - 4:00 PM</th>
				<th>4:01 PM - 4:30 PM</th>
				<th>4:31 PM - 5:00 PM</th>
				<th>4:01 PM - 4:30 PM</th>
				<th>4:31 PM - 5:00 PM</th>
				<th>5:01 PM - 5:30 PM</th>
				<th>5:31 PM - 6:00 PM</th>

			</tr>
		</thead>
		<% for (Map.Entry<Integer, MonthVo> entry : monthMap.entrySet()) {%>
		<tbody>
			<tr>
			<% if ((entry.getValue().getDayName().equals("Saturday")) || (entry.getValue().getDayName().equals("Sunday"))){%>
				<td class="tableback"><%= entry.getKey()%></td>
				<td class="tableback"><%= entry.getValue().getDayName()%></td><%}else{ %>
				<td class=""><%= entry.getKey()%></td>
				<td class=""><%= entry.getValue().getDayName()%></td><%} %>
				<%for(int i =0; i < entry.getValue().getSlots().size()-1; i++){ %>
					<%if ((entry.getValue().getDayName().equals("Saturday")) || (entry.getValue().getDayName().equals("Sunday"))){ %>
					<td class="tableback"></td> <% }else{
						if(entry.getValue().getSlots().get(i).isSlotBooked()){%>
							<td id="<%= entry.getValue().getMonthNo()%>.<%= entry.getKey()%>.<%= entry.getValue().getSlots().get(i).getSlotNo()%>" class="tabsHighlighted"></td>
						<%}else{  %>
							<td id="<%= entry.getValue().getMonthNo()%>.<%= entry.getKey()%>.<%= entry.getValue().getSlots().get(i).getSlotNo()%>"></td>
						<%} %>
				<%-- <td id="<%= entry.getValue().getMonthNo()%>.<%= entry.getKey()%>.<%= entry.getValue().getSlots().get(i).getSlotNo()%>"></td> --%><%}} %>
			</tr>
		</tbody>
		<%}%>
	</table>
	<form action="/SchedularUpdated/SchedularSevlet" method="post" id="tableForm">
		<input type="button" value="submitTime" name="Submit Time" onclick="onSubmitTime()"> 
		<input type="hidden" name="hiddenArr" id="hiddenArr"> 
		<input type="hidden" name="month"  value="<%=month%>" id="month">
	</form>
</body>
</html>