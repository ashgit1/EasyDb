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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			<a class="navbar-brand" href="#"><font size="15px">Easy DB </font></a>
		</div>
	</div>
</nav>
<div class="container">
	<font size="5px"> 
	Database Name   : <%= dbMetaDataInfo.getDbName() %> 						  <br>
	Driver Name     : <%= dbMetaDataInfo.getDbMetadata().getDriverName() %>       <br> 
	Driver Version  : <%= dbMetaDataInfo.getDbMetadata().getDriverVersion() %>    <br>
	User Name       : <%= dbMetaDataInfo.getDbMetadata().getUserName() %>         <br>
	Product Name    : <%= dbMetaDataInfo.getDbMetadata().getDbProductName() %>    <br>
	Product Version : <%= dbMetaDataInfo.getDbMetadata().getDbProductVersion() %> <br>
	</font> 
	<%-- <h1> <%= connectionString%> </h1> --%>
	<%
		for(String tables : dbMetaDataInfo.getTableList()){
	%>	<input type="radio" name="table" value="<%=tables %>"> <%=tables %>
	<% }
	%>
	<input type="submit" class="btn btn-primary btn-lg" value="View Table" />
</div>
<br><br>
<div class="container">
	<footer>
		<p>
			&copy; <a href="https://www.facebook.com/ashishkgrich">Ashishkumar Gupta</a> 2016-2017
		</p>
	</footer>
</div>
</body>
</html>
