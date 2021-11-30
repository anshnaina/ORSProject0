<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

#mySidenav a {
	margin-top: 0px;
	position: absolute;
	left: -47px;
	transition: 0.3s;
	padding: 10px;
	width: 150px;
	text-decoration: none;
	font-style: italic;
	text-align: right;
	color: white;
	border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
	left: 0;
}

.leftSideBarParent {
	margin-left: 1% !important;
}

#user {
	top: 30px;
	background-color: #004466;
}

#role {
	top: 80px;
	background-color: #334d4d;
}

#college {
	top: 130px;
	background-color: #009999;
}

#student {
	top: 180px;
	background-color: #004466;
}

#faculty {
	top: 230px;
	background-color: #334d4d;
}

#course {
	top: 280px;
	background-color: #009999;
}

#subject {
	top: 330px;
	background-color: #004466;
}

#marksheet {
	top: 380px;
	background-color: #334d4d;
}

#timetable {
	top: 430px;
	background-color: #009999;
}
</style>

<style type="text/css">
@media ( min-width : 200px) and (max-width: 1024px) {
	.dis {
		display: block;
		display: none;
		text-decoration: underline;
	}
}
</style>
</head>
<body>
<%-- <div class="leftSideBarParent">
<div id="mySidenav" class="sidenav dis">
 <c:if test="${not empty sessionScope.user && sessionScope.user.roleId==1}">
  
  <a href="<c:url value="/ctl/User/search"></c:url>" id="user" ><s:message	code="header.userList"/> </a>
  <a href="<c:url value="/ctl/Role/search"></c:url>" id="role"><s:message	code="header.roleList"/> </a>
  <a href="<c:url value="/ctl/College/search"></c:url>" id="college"><s:message	code="header.collegeList"/> </a>
  <a href="<c:url value="/ctl/Student/search"></c:url>" id="student"><s:message	code="header.studentList"/> </a>
  <a href="<c:url value="/ctl/Faculty/search"></c:url>" id="faculty"><s:message	code="header.facultyList"/> </a>
  <a href="<c:url value="/ctl/Course/search"></c:url>" id="course"><s:message	code="header.courseList"/> </a>
  <a href="<c:url value="/ctl/Subject/search"></c:url>" id="subject"><s:message	code="header.subjectList"/> </a>
  <a href="<c:url value="/ctl/Marksheet/search"></c:url>" id="marksheet"><s:message	code="header.marksheetList"/> </a>
  <a href="<c:url value="/ctl/TimeTable/search"></c:url>" id="timetable"><s:message	code="header.timetableList"/> </a>

</c:if>
</div>
</div> --%>

     
</body>
</html> 