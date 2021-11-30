<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TimeTable</title>
<style type="text/css">
body {
	background-image: url("/ORSProject0/resources/theam_wel/image/0.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}
</style>
</head>
<body>

	<sf:form action="TimeTable" method="post" commandName="form">
		<sf:hidden path="id" />
		<sf:hidden path="createdBy"></sf:hidden>
		<sf:hidden path="modifiedBy"></sf:hidden>
		<sf:hidden path="createdDatetime"></sf:hidden>
		<sf:hidden path="modifiedDatetime"></sf:hidden>
		<br>

		<div class="container-fluid">
			<div class="row" style="height: 700px;">
				<div class="col-xs-12 col-md-6 col-sm-12 col-lg-4 col-md-offset-4">
					<div class="panel panel-primary"
						style="margin-top: 10px; background-color: #DCDCDC;">
						<div class="panel-heading" style="background-color: #e9967a00"
							align="center">

							<c:choose>
								<c:when test="${form.id>0}">
									<s:message code="timetable.label.updateTimeTable"></s:message>
								</c:when>
								<c:otherwise>
									<s:message code="timetable.label.addTimeTable"></s:message>
								</c:otherwise>
							</c:choose>
						</div>

						<div class="panel-body">


							<div align="center">
								<c:if test="${not empty error }">
									<div class='container-fluid' style="height: 60px;">
										<div class="alert alert-danger" role="alert"
											style="width: 90%; margin-left: 0%; font-size: 150%">
											<Strong>${error} </Strong>
										</div>
									</div>
								</c:if>
								<c:if test="${not empty success }">
									<div class='container-fluid' style="height: 60px;">
										<div class="alert alert-success" role="alert"
											style="width: 90%; margin-left: 0%; font-size: 140%;">
											<Strong>${success} </Strong>
										</div>
									</div>
								</c:if>
							</div>

							<br>

							<div class="col-xs-12 col-sm-12 col-md-10 col-lg-12">

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"width: 180px;" style="padding-top: 13px;">
										<s:message code="course.label.name" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-book"></i></span>

											<sf:select STYLE="width: 100%" size="0" path="courseId"
												class="form-control">
												<sf:option value="" label="Select">
											---<s:message code="label.select"></s:message>---
											</sf:option>
												<sf:options items="${courseList}" itemValue="id"
													itemLabel="courseName" />
											</sf:select>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="courseId" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"width: 180px;">
										<s:message code="subject.label.name" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-book"></i></span>

											<sf:select STYLE="width: 100%" size="0" path="subjectId"
												class="form-control">
												<sf:option value="" label="Select">
											---<s:message code="label.select"></s:message>---
											</sf:option>
												<sf:options items="${subjectList}" itemValue="id"
													itemLabel="subjectName" />
											</sf:select>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="subjectId" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"width: 180px;">
										<s:message code="timetable.label.examTime" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i></span>

											<sf:select STYLE="width: 100%" size="0" path="examTime"
												class="form-control">
												<sf:option value="" label="Select">
											---<s:message code="label.select"></s:message>---
											</sf:option>

												<sf:option value="7:00 AM TO 10:00 AM"
													label="7:00 AM TO 10:00 AM">
													<s:message code="TimeTable.examTime.1st"></s:message>
												</sf:option>
												<sf:option value="10:00 AM TO 1:00 PM"
													label="10:00 AM TO 1:00 PM">
													<s:message code="TimeTable.examTime.2st"></s:message>
												</sf:option>
												<sf:option value="1:00 PM TO 3:00 PM"
													label="1:00 PM TO 3:00 PM">
													<s:message code="TimeTable.examTime.3st"></s:message>
												</sf:option>
												<sf:option value="3:00 PM TO 6:00 PM"
													label="3:00 PM TO 6:00 PM">
													<s:message code="TimeTable.examTime.4st"></s:message>
												</sf:option>

											</sf:select>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="examTime" cssClass="error" />
										</label>
									</div>
								</div>
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"> <s:message
											code="timetable.label.examDate" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i></span>
										<s:message code="timeTable.placeholder.examDate" var="examDate"></s:message>
											<sf:input path="examDate" placeholder="${examDate}" readonly="true" id="datesun"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="examDate" cssClass="error" />
										</label>
									</div>
								</div>
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"width: 180px;">
										<s:message code="timetable.label.semester" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-pencil"></i></span>

											<sf:select STYLE="width: 100%" size="0" path="semester"
												class="form-control">
												<sf:option value="" label="Select">
											---<s:message code="label.select"></s:message>---
											</sf:option>

							<sf:option value="1st" label="1st" ><s:message code="TimeTable.semester.1st"/></sf:option>
							<sf:option value="2nd" label="2nd"><s:message code="TimeTable.semester.2st"/></sf:option>
							<sf:option value="3rd" label="3rd"><s:message code="TimeTable.semester.3st"/></sf:option>
							<sf:option value="4th" label="4th" ><s:message code="TimeTable.semester.4st"/></sf:option>
							<sf:option value="5th" label="5th" ><s:message code="TimeTable.semester.5st"/></sf:option>
							<sf:option value="6th" label="6th" ><s:message code="TimeTable.semester.6st"/></sf:option>
							<sf:option value="7th" label="7th" ><s:message code="TimeTable.semester.7st"/></sf:option>
							<sf:option value="8th" label="8th" ><s:message code="TimeTable.semester.8st"/></sf:option>

											</sf:select>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="semester" cssClass="error" />
										</label>
									</div>
								</div>
								
								



							</div>


							<div class="form-group" align="center">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

									<c:choose>
										<c:when test="${form.id>0}">

											<br>
											<button type="submit" class="btn btn-success"
												name="operation" value="Update">
												<span class="glyphicon glyphicon-check"></span>
												<s:message code="op.update"></s:message>
											</button>
											<button type="submit" class="btn btn-primary"
												name="operation" value="Cancel">
												<span class="glyphicon glyphicon-remove"></span>
												<s:message code="op.cancle"></s:message>
											</button>

										</c:when>
										<c:otherwise>
											<br>
											<button type="submit" class="btn btn-primary"
												name="operation" value="Save">
												<span class="glyphicon glyphicon-check"></span>
												<s:message code="op.save"></s:message>
											</button>
											&emsp;
											<button type="submit" class="btn btn-warning"
												name="operation" value="Reset">
												<span class="glyphicon glyphicon-refresh"></span>
												<s:message code="op.reset"></s:message>
											</button>

										</c:otherwise>
									</c:choose>


								</div>
							</div>
						</div>
					</div>
				</div>
	</sf:form>

	<br>

</body>

</html>