<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error : 404</title>
<style>
body {
	background-image: url("/ORSProject0/resources/image/error1.jpg");
	background-size: cover;
	background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
}
.welcome {
  	margin-top:160px;
</style>
</head>
<body>
	<form action="" method="post">
		<table align="center"  class=welecome>
			<tr>
				<b><font color="Blue"><h1 align="center" class="welcome">ERROR 404 : RESOURCE NOT FOUND</h1></font></b>
				<h1 align="Center">
				<img src="/ORSProject0/resources/theam_wel/image/customLogo.png" width="318" height="127" border="0">
				</h1>
				<b><font color="red"><h1 align="center">Oops! Your are Searching for Water but Here is Deseart</h1></font></b>
				<td><%-- <input type="submit" name="operation"
					value="<%=ErrorCtl.OP_BACK%>"></td> --%>
					<input style="width:100px;height:30px;" type="button" value="Back" onclick="history.back()">
			</tr>
		</table>
	</form>

</body>
</html>