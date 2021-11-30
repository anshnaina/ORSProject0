<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
html {
	height: 100%;
	box-sizing: border-box;
}

*, *:before, *:after {
	box-sizing: inherit;
}

body {
	position: relative;
	margin: 0;
	min-height: 100%;
}

.footer {
	position: fixed;
	right: 0;
	bottom: 0;
	color: gainsboro;
	left: 0;
	display: block;
	/*  padding: 0.5rem; */
	box-shadow: 0px 0px 0px 0px #244a4a;
	text-align: center;
	z-index: 2500;
}
</style>

<title></title>
</head>
<body>

	<div class="footer"
		style="background-color: rgba(28, 35, 49, 0.85); height: 40px;">
		<p style="font-size: 16px; padding-top: 10px;">
			<s:message code="footer.copyright"></s:message> &copy;
			<script>
				document.write(new Date().getFullYear())
			</script>
		</a>
			<s:message code="footer.raystech"></s:message></b>
		</p>
	</div>

</body>
</html>

<script type="text/javascript">
	function showError(id) {
		document.getElementById(id).style.display = "block";
	}
	function hideError(id) {
		document.getElementById(id).style.display = "none";
	}
</script>