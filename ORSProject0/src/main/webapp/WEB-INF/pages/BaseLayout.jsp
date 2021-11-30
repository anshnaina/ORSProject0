<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--    favicon-->
<link rel="shortcut icon" href="/ORSProject0/resources/theam_wel/image/fav-icon.png"
	type="image/x-icon">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- bootstrap CDN  with jquery css -->

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet" href="resources/css/jquery-ui.css">
<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/jquery-1.12.4.js"></script>
<script src="../reources/js/jquery-ui.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/ORSProject0/resources/js/bootstrap.min.css">
<link rel="stylesheet" href="/ORSProject0/resources/js/font-awesome.min.css">

<!-- bootstrap end with jquery css-->


<style type="text/css">
#dcolor {
	font-size: 110%;
	color: #ffffff;
}

.btn-primary {
	height: 35px;
	width: 90px;
	background: lightseagreen;
	box-shadow: 0 0 1px #ccc;
	-webkit-transition: all 0.5s ease-in-out;
	border: 0px;
	color: #fff;
	border-color: none;
}

.btn-primary:hover {
	-webkit-transform: scale(1.1);
	background: #31708f;
}

.btn-success {
	height: 35px;
	width: 90px;
	box-shadow: 0 0 1px #ccc;
	-webkit-transition: all 0.5s ease-in-out;
	border: 0px;
	color: #fff;
	border-color: none;
}

.btn-success:hover {
	-webkit-transform: scale(1.1);
	background: green;
}

.btn-info {
	height: 35px;
	width: 90px;
	box-shadow: 0 0 1px #ccc;
	-webkit-transition: all 0.5s ease-in-out;
	border: 0px;
	color: #fff;
	border-color: none;
}

.btn-info:hover {
	-webkit-transform: scale(1.1);
	background: #33d6ff;
}

.btn-warning {
	height: 35px;
	width: 90px;
	box-shadow: 0 0 1px #ccc;
	-webkit-transition: all 0.5s ease-in-out;
	border: 0px;
	color: #fff;
	border-color: none;
}

.btn-warning:hover {
	-webkit-transform: scale(1.1);
	background: #ff9933;
}

.btn-danger {
	height: 35px;
	width: 90px;
	box-shadow: 0 0 1px #ccc;
	-webkit-transition: all 0.5s ease-in-out;
	border: 0px;
	color: white;
	border-color: none;
}

.btn-danger:hover {
	-webkit-transform: scale(1.1);
	background: #ff3333;
}

.panel {
	box-shadow: 9px 8px 7px #001a33;
	background: rgba(10, 10, 10, 0.44);
}

.text-primary {
	color: blue;
}

.text-danger {
	margin-left: 50px;
	color: #ff0000;
}

.table {
	bordercolor: blue;
	background-color: white;
}

.navbar-inverse {
	/*  background-color: #7986CB ; */
	border-color: black;
	color: white;
	/*  background-image: url("img/images (2)navar00.jpg");  */
	background: #001a33;
	background-repeat:;
}

element.style {
	color: #000;
}

body {
	padding-top: 70px;
}

#top {
	margin-bottom: 100px;
}

.glyphicon-edit {
	color: #800000;
}

.panel>.panel-heading {
	background-position: center;
	font-size: 30px;
	background: rgba(10, 10, 10, 0.44);
	color: #993333;
	font-family: cursive;
	/* margin-right:30px; */
	/* 	background: rgba(10, 10, 10, 0.44);
 */
	background-size: appworkspace;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
}

.dropdown-menu {
	background-color: #dedfe2;
}

.list-heading {
	background-color: #060613;
}

#error {
	font-size: 20px;
	position: center;
	color: red;
}

#success {
	font-size: 20px;
	position: center;
	color: green;
}
</style>

<script type="text/javascript">
	function selectAll(source) {
		checkboxes = document.getElementsByName('ids');

		for (var i = 0, n = checkboxes.length; i < n; i++) {
			checkboxes[i].checked = source.checked;
		}
	}

	$(document).ready(function() {
		$('[name="ids"]').click(function() {
			if (!($(this)[0].checked)) {
				$('[onclick="selectAll(this)"]')[0].checked = false;
			}
			;

		});

	});
</script>


<script type="text/javascript">
	$(function() {
		$(".dropdown").hover(function() {
			$('.dropdown-menu', this).stop(true, true).fadeIn("fast");
			$(this).toggleClass('open');
		}, function() {
			$('.dropdown-menu', this).stop(true, true).fadeOut("fast");
			$(this).toggleClass('open');
		});
	});
</script>

<script>

	function selectAll(source) {
		checkboxes = document.getElementsByName('ids');
		for (var i = 0, n = checkboxes.length; i < n; i++) {
			checkboxes[i].checked = source.checked;
		}
	}

	function selectone(so) {
		checkboxes = document.getElementById('mainbox');
		unbox = document.getElementsByName('ids');
		var box = false;
		for (var i = 0, n = unbox.length; i < n; i++) {
			if (unbox[i].checked == true) {
				box = true;
			} else {
				box = false;
				break;
			}
		}
		checkboxes.checked = box;
	}
</script>

</head>
<body>

	<div style="margin-bottom: 0px;">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-1">

				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="col-md-11" style="min-height: 526px; background-color:;">

				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
		</div>


	</div>

	<div style="clear: both;">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
	
</body>


</html>