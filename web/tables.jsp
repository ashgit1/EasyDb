<%@page import="java.util.ArrayList"%>
<%@page import="com.ashish.easydb.model.DatabaseMetaDataInfo"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tables Page</title>
<link rel="stylesheet" href="css/style.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Style for Datatable -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">
<!-- Style for Datatable Over -->

<script>
	$(document).ready(function() {
		$('#componentTable').DataTable();
	});
</script>

</head>

<body>
	<!-- This is the declaration section of the java Objects -->
	<%
		DatabaseMetaDataInfo dbMetaDataInfo = (DatabaseMetaDataInfo) session.getAttribute("dbMetaDataSession");
		String connectionString = dbMetaDataInfo.getConnectString();
	%>
	<!-- Declaration section of the java Objects Ends -->

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><font size="15px">Easy
						DB </font></a>
			</div>
		</div>
	</nav>
	<div class="container">
		<font size="5px"> Database Name : <%=dbMetaDataInfo.getDbName()%>
			<br> Driver Name : <%=dbMetaDataInfo.getDbMetadata().getDriverName()%>
			<br> Driver Version : <%=dbMetaDataInfo.getDbMetadata().getDriverVersion()%>
			<br> User Name : <%=dbMetaDataInfo.getDbMetadata().getUserName()%>
			<br> Product Name : <%=dbMetaDataInfo.getDbMetadata().getDbProductName()%>
			<br> Product Version : <%=dbMetaDataInfo.getDbMetadata().getDbProductVersion()%>
			<br><br>
		</font>
		<%-- <h1> <%= connectionString%> </h1> --%>
		<%
			for (String tables : dbMetaDataInfo.getTableList()) {
		%>
		<input type="radio" name="table" value="<%=tables%>">
		<%=tables%>
		<%
			}
		%>
		<input type="submit" class="btn btn-primary btn-lg" value="View Table" />
	</div>

	<div class="container">
		<TABLE BORDER="1" id="componentTable">
			<thead>
				<TR class="noExl">
					<TH>Name</TH>
					<TH>Profession</TH>
					<TH>Country</TH>
					<TH>Rankings</TH>
				</TR>
			</thead>
			<TR>
				<td>Ashish</td>
				<td>Cricket</td>
				<td>India</td>
				<td>2</td>
			</TR>
			<TR>
				<td>Federer</td>
				<td>Tennis</td>
				<td>Switzerland</td>
				<td>1</td>
			</TR>
			<TR>
				<td>Sachin</td>
				<td>Cricket</td>
				<td>India</td>
				<td>5</td>
			</TR>
			<TR>
				<td>Ronaldo</td>
				<td>Football</td>
				<td>Portugal</td>
				<td>4</td>
			</TR>
			<TR>
				<td>Schumacher</td>
				<td>Formula</td>
				<td>Germany</td>
				<td>6</td>
			</TR>
			<TR>
				<td>Tyson</td>
				<td>Boxing</td>
				<td>USA</td>
				<td>14</td>
			</TR>
			<TR>
				<td>Tiger</td>
				<td>Golf</td>
				<td>USA</td>
				<td>12</td>
			</TR>
			<TR>
				<td>Kaka</td>
				<td>Football</td>
				<td>Brazil</td>
				<td>8</td>
			</TR>
			<TR>
				<td>Jordan</td>
				<td>Basketball</td>
				<td>USA</td>
				<td>15</td>
			</TR>
			<TR>
				<td>Nadal</td>
				<td>Tennis</td>
				<td>Spain</td>
				<td>19</td>
			</TR>
			<TR>
				<td>HHH</td>
				<td>WWE</td>
				<td>USA</td>
				<td>2</td>
			</TR>
			<TR>
				<td>Djokivic</td>
				<td>Tennis</td>
				<td>Serbia</td>
				<td>3</td>
			</TR>
			<TR>
				<td>Messi</td>
				<td>Football</td>
				<td>Argentina</td>
				<td>4</td>
			</TR>
			<TR>
				<td>Rock</td>
				<td>WWE</td>
				<td>USA</td>
				<td>1</td>
			</TR>
			<TR>
				<td>Akram</td>
				<td>Cricket</td>
				<td>Pakistan</td>
				<td>7</td>
			</TR>

		</TABLE>
	</div>

	<br>
	<br>
	<div class="container">
		<footer>
			<p>
				&copy; <a href="https://www.facebook.com/ashishkgrich">Ashishkumar
					Gupta</a> 2016-2017
			</p>
		</footer>
	</div>
</body>
</html>
