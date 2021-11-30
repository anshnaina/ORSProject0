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
	
<title>College</title>
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
	<sf:form action="College" method="post" commandName="form">
							<sf:hidden path="id" />
							<sf:hidden path="createdBy"></sf:hidden>
							<sf:hidden path="modifiedBy"></sf:hidden>
							<sf:hidden path="createdDatetime"></sf:hidden>
							<sf:hidden path="modifiedDatetime"></sf:hidden>

	<div class="container-fluid">
		<div class="row" style="padding-bottom: 155px;">
			<div class="col-xs-12 col-md-6 col-sm-12 col-lg-4 col-md-offset-4">
				<div class="panel panel-primary"
					style="margin-top: 10px; background-color: #DCDCDC;">
					<div class="panel-heading" style="background-color: #e9967a00"
						align="center">

						<c:choose>
							<c:when test="${form.id>0}">
								<s:message code="college.label.updateCollege"></s:message>
							</c:when>
							<c:otherwise>
								<s:message code="college.label.addCollege"></s:message>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="panel-body">


						<div align="center">
						<c:if test="${not empty error }">
						<div class='container-fluid' style="height: 60px;">
							<div class="alert alert-danger" role="alert"
								style="width: 90%; margin-left: 0%; font-size: 150%">
								<Strong>${error}
								</Strong>
							</div>
							</div>
						</c:if>
						<c:if test="${not empty success }">
						<div class='container-fluid' style="height: 60px;">
							<div class="alert alert-success" role="alert"
								style="width: 90%; margin-left: 0%; font-size: 140%;">
								<Strong>${success}
								</Strong>
							</div>
							</div>
						</c:if>
						</div>
						
						<br>
						
					
							<div class="col-xs-12 col-sm-12 col-md-10 col-lg-12">


								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"   style="padding-top: 10px;">	
											<s:message code="label.name" />
									 <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-user"></i></span>
											<s:message code="college.placeholder.name" var="name"></s:message>
											<sf:input path="name" placeholder="${name}"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="name" cssClass="error" />
										</label>
									</div>
								</div>
								
								<!-- Address -->
								
									<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style=" width: 190px;">	
											<s:message code="label.address" />
									<span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-align-justify"></i></span>

											<s:message code="college.placeholder.address" var="address"></s:message>
											<sf:input path="address" placeholder="${address}"
												class="form-control" />
										</div>
										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="address" cssClass="error" />
										</label>
									</div>
								</div>
								
								<!-- state -->
								
									<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style=" width: 190px;">	
											<s:message code="label.state" />
									<span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-align-justify"></i></span>

											<s:message code="college.placeholder.state" var="state"></s:message>
											<sf:input path="state" placeholder="${state}"
												class="form-control" />
										</div>
										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="state" cssClass="error" />
										</label>
									</div>
								</div>
								
									
								<!-- city -->
								
									<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style=" width: 190px;">	
											<s:message code="label.city" />
									<span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-align-justify"></i></span>

											<s:message code="college.placeholder.city" var="city"></s:message>
											<sf:input path="city" placeholder="${city}"
												class="form-control" />
										</div>
										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="city" cssClass="error" />
										</label>
									</div>
								</div>
								
								<!-- Phone No -->
								
									<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style=" width: 190px;">	
											<s:message code="label.phoneNo" />
									<span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-align-justify"></i></span>
											<s:message code="college.placeholder.phone" var="phone"></s:message>	
											<sf:input path="phoneNo" placeholder="${phone}" class="form-control" />
											
										</div>
										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="phoneNo" cssClass="error" />
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
		<br> <br>



	<br>
	<br>
	</sf:form>
</body>

</html>
						
