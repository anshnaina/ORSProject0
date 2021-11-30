<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- bootstrap library -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image:
		url('/ORSProject0/resources/theam_wel/image/0.jpg');
	background-size: cover;
	background-repeat: no-repeat;
}

.p1 {
	padding-top: 200px;
}

.btn {
	background: #ffc61a;
	border-radius: 100px;
	padding: 5px 10px;
	color: #fff;
	text-decoration: none;
	font-size: 0.75em;
	margin: 0 15px;
}

/* Hover state animation applied here */
.btn:hover {
	background-color: #ffecb3;
	-webkit-animation: hover 1200ms linear 2 alternate;
	animation: hover 1200ms linear 2 alternate;
}

/* Active state animation applied here */
.btn:active {
	-webkit-animation: active 1200ms ease 1 alternate;
	animation: active 1200ms ease 1 alternate;
	background: #cc6600;
}
/* .btn {
  background-color: #ffc61a;
  border: none;
  transition: 0.3s;
}

.btn:hover {
  background-color: #ffecb3;
} */
</style>
</head>
<body class="img-fluid">

	<div class="p1">
		<h1 align="Center">
			<img src="resources/theam_wel/image/customLogo.png" width="300" height="150"
				border="0">
		</h1>
		<h1 align="Center">
			<a href='<c:url value="/Welcome"></c:url>' class="btn btn-lg ">Online Result System</a>
		</h1>
	</div>

</body>
</html>
