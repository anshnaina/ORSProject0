<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css"/>">
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'mm/dd/yy',
			yearRange : "-57:-18",
			defaultDate : "01/01/2000",
		});
	});

	$(function() {
		$("#datesun").datepicker({
			beforeShowDay : function(dt) {
				return [ dt.getDay() == 0 ? false : true ] ///// to disable sunday
			},
			changeMonth : true,
			changeYear : true,
			stepMonths : 12,
			yearRange : '+0:+5',
			//yearRange:"+10:"
		});
	});

	$(function() {
		$("#datefac").datepicker({
			beforeShowDay : function(dt) {
				return [ dt.getDay() == 0 ? false : true ] ///// to disable sunday
			},
			changeMonth : true,
			changeYear : true,
			yearRange : "-57:+0",
			defaultDate : "01/01/2018"
		//defaultDate:"01/01/1999"
		});
	});

</script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background-color: rgba(28, 35, 49, 0.6);">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-left"
			style="background-color: #3030358f">
				<a class="navbar-brand" href="<c:url value="/Welcome" />"><img src="/ORSProject0/resources/image/main_logo.png" height=26 width=30></a>
			</a>
		</ul>

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
			</button>
			

		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav navbar-right" style="background:">
				<c:if test="${empty sessionScope.user}">
					<li><a href="<c:url value="/Login" />" id="dcolor"
						onclick="document.getElementById('id01').style.display='block'"
						style="width: auto;color: #e0ebeb; font-weight: bold;"><span
							class="glyphicon glyphicon-log-in"
							style="font-size: 20px; margin-right: 8px; "></span> <s:message
								code="header.login"></s:message></a></li>
					<li><a href="<c:url value="/UserRegistration" />" id="dcolor">
							<font style="color: #e0ebeb; font-weight: bold;"> <span
								class="glyphicon glyphicon-user"
								style="font-size: 20px; margin-right: 10px;"></span>
							<s:message code="header.userRegistration"></s:message></font>
					</a></li>
				</c:if>

				<c:if test="${not empty sessionScope.user}">
					<li class="dropdown"><a href="" id="dcolor"
						class="dropdown-toggle" data-toggle="dropdown role="
						button"
						aria-haspopup="true" aria-expanded="false"><span
							aria-hidden="true"></span><b> <span
								class="glyphicon glyphicon-user" aria-hidden="true"
								style="font-size: 18px; margin-right: 3px;"></span> <s:message
									code="header.hii"></s:message> <c:set var="name"
									value="${sessionScope.user.firstName}" /> <c:set var="role"
									value='${sessionScope.role.name}' /> <c:out
									value="${name} (${role}) "></c:out> <span class="caret"></span></a>

						</b></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/User/MyProfile" />"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"></span> <font
									style="font-family: cursive;"><b><s:message
												code="header.myProfile"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/User/ChangePassword" />">
									<span class="glyphicon glyphicon-cog" style="color: #0f0f0a"></span>
									<font style="font-family: cursive;"><b><s:message
												code="header.changePassword"></s:message></b></font>
							</a></li>
							
							<c:if test="${sessionScope.user.roleId == 1}">
							<li><a href="<c:url value="/resources/doc/index.html" />"
								target="blank"><span class="glyphicon glyphicon-file"
									aria-hidden="true" style="color: #734d26"></span> <font
									style="font-family: cursive;"><b><s:message
												code="header.javadoc"></s:message></b></font></a></li>
							</c:if>
												
							<li><a href="<c:url value="/Login" />"><font
									style="font-family: cursive; color: #800000;"><span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										<b><s:message code="header.logout"></s:message></b></font></a></li>
						</ul></li>

				</c:if>
			</ul>

			<ul class="nav navbar-nav">
				<%-- 		<li><a href="<c:url value="?lang=en"></c:url>" style=" padding-right: 0px; padding-left: 0px;"><b style="color:	#FFFFFF">English</b></font></a></li>
			<li><a href="<c:url value="?lang=hi"></c:url>"><b style="color:	#FFFFFF"><s:message code="label.hindi"></s:message></b></a></li> --%>

				<c:if test="${not empty sessionScope.user}">
					
					<c:if test="${sessionScope.user.roleId == 1}">
					
					<li></li>

					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message code="header.user"></s:message><span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/User" />"><span
									class="glyphicon glyphicon-user" style="color: #990000"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.addUser"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/User/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.userList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message code="header.role"></s:message><span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Role" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.addRole"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Role/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.roleList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.student"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Student" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"><b> <s:message
												code="header.addStudent"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Student/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.studentList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.college"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/College" />"> <span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.addCollege"></s:message></b></font>
							</a></li>
							<li><a href="<c:url value="/ctl/College/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.collegeList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.faculty"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Faculty" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"><b> <s:message
												code="header.addFaculty"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Faculty/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.facultyList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"> <s:message
								code="header.course"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Course" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.addCourse"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Course/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.courseList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.subject"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Subject" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"><b> <s:message
												code="header.addSubject"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Subject/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.subjectList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.timetable"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/TimeTable" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.addTimetable"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/TimeTable/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b> <s:message
												code="header.timetableList"></s:message></b></font></a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.marksheet"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Marksheet/GetMarksheet" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.getMarksheet"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Marksheet" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.addMarksheet"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Marksheet/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.marksheetList"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Marksheet/MeritList" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.marksheetMeritList"></s:message></b></font> </a></li>
						</ul></li>
			
					</c:if>
					
					<c:if test="${sessionScope.user.roleId == 2}">
					
					<li></li>

					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.college"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							
							<li><a href="<c:url value="/ctl/College/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.collegeList"></s:message></b></font></a></li>
						</ul>
					
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"> <s:message
								code="header.course"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							
							<li><a href="<c:url value="/ctl/Course/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.courseList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.subject"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							
							<li><a href="<c:url value="/ctl/Subject/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b><s:message
												code="header.subjectList"></s:message></b></font></a></li>
						</ul>
					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.timetable"></s:message><span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							
							<li><a href="<c:url value="/ctl/TimeTable/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span>
									<font style="font-family: cursive;"> <b> <s:message
												code="header.timetableList"></s:message></b></font></a></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.marksheet"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
							<li><a href="<c:url value="/ctl/Marksheet/GetMarksheet" />"><span
									class="glyphicon glyphicon-education" style="color: #993366"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.getMarksheet"></s:message></b></font></a></li>
							
							<li><a href="<c:url value="/ctl/Marksheet/search" />"><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.marksheetList"></s:message></b></font></a></li>
							<li><a href="<c:url value="/ctl/Marksheet/MeritList" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.marksheetMeritList"></s:message></b></font> </a></li>
						</ul></li>
						
						<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.user"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
						
							<li><a href="<c:url value="/ctl/User/search" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.userList"></s:message></b></font> </a></li>
						</ul></li>
			
			<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.role"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
						
							<li><a href="<c:url value="/ctl/Role/search" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.roleList"></s:message></b></font> </a></li>
						</ul></li>
						
						<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.faculty"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
						
							<li><a href="<c:url value="/ctl/Faculty/search" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.facultyList"></s:message></b></font> </a></li>
						</ul></li>
						
						<li class="dropdown"><a class="dropdown-toggle" id="dcolor"
						data-toggle="dropdown" href="#"><s:message
								code="header.student"></s:message> <span class="caret"></span></a>
						<ul class="dropdown-menu" style="background-color: wheat">
						
							<li><a href="<c:url value="/ctl/Student/search" />""><span
									class="glyphicon glyphicon-list-alt" style="color: #734d26"></span><font
									style="font-family: cursive;"> <b><s:message
												code="header.studentList"></s:message></b></font> </a></li>
						</ul></li>
			
			
					</c:if>
					

				</c:if>
		</div>


		</ul>

	</div>
	</nav>

	<%-- 	<table width=100%>
		
		<tr>
			<td colspan="2" style="text-align: left;">
			 <a class="btn btn-success" href="?lang=en">English</a> &nbsp; <a class="btn btn-primary" href="?lang=hi"><s:message code="label.hindi"></s:message> </a>
				
			</td>
		</tr>
		
	</table>
--%>

	<!-- language support dropdown  -->

	<div style="margin-right: 80px;width: 110px;" class="dropdown">
		<button class="btn btn-info"
			style="background-color: #3a3a46a6;; width: 100px;" type="button"
			data-toggle="dropdown">
			<font color="black"><b style="color: white"><s:message
						code="language.hindi"></s:message></b></font> <font color="white"><span
				class="caret"></span></font>
		</button>

		<ul class="dropdown-menu">
			<li><a href="<c:url value="?lang=en"></c:url>"><b
					style="color: black">English</b></a></li>
			<li><a href="<c:url value="?lang=hi"></c:url>"><b
					style="color: black"><s:message code="label.hindi">
						</s:message></b></a></li>
		</ul>
	</div>


</body>
</html>