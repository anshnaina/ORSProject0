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
<title>My Profile</title>
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
	
		<sf:form method="post" commandName="form">
		<sf:hidden path="id" />
		<sf:hidden path="createdBy"></sf:hidden>
		<sf:hidden path="modifiedBy"></sf:hidden>
		<sf:hidden path="createdDatetime"></sf:hidden>
		<sf:hidden path="modifiedDatetime"></sf:hidden>
		<br>

		<div class="container-fluid">
			<div class="row" style="height: 800px;">
				<div class="col-xs-12 col-md-6 col-sm-12 col-lg-4 col-md-offset-4">
					<div class="panel panel-primary"
						style="margin-top: 10px; background-color: #DCDCDC;">
						<div class="panel-heading" style="background-color: #e9967a00"
							align="center">

							
									<s:message code="label.myProfile"></s:message>
			
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

								<s:message code="user.placeholder.firstName" var="firstName"></s:message>
								<s:message code="user.placeholder.lastName" var="lastName"></s:message>
								<s:message code="user.placeholder.login" var="login"></s:message>
								<s:message code="user.placeholder.mobileNo" var="mobileNo"></s:message>
								<s:message code="user.placeholder.dob" var="dob"></s:message>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style="padding-top: 10px;"
										> <s:message
											code="user.label.login" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-log-in"></i></span>

											<sf:input path="login" placeholder="${login}"
												class="form-control" readonly="true"/>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="login" cssClass="error" />
										</label>
									</div>
								</div>
			
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"
										> <s:message
											code="user.label.firstName" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-user"></i></span>

											<sf:input path="firstName" placeholder="${firstName}"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="firstName" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"
										> <s:message
											code="user.label.lastName" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-user"></i></span>

											<sf:input path="lastName" placeholder="${lastName}"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="lastName" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"
										style="width: 180px;"> <s:message
											code="user.label.gender" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="fa fa-transgender"></i></span>

											<sf:select STYLE="width: 100%" size="0" path="gender"
												class="form-control">
												<sf:option value="" label="Select">
													---<s:message code="label.select"></s:message>---
												</sf:option>
												<sf:option value="Female">
													<s:message code="label.female" />
												</sf:option>
												<sf:option value="Male">
													<s:message code="label.male" />
												</sf:option>

											</sf:select>
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="gender" cssClass="error" />
										</label>
									</div>
								</div>
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"
										> <s:message
											code="user.label.mobileNo" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-phone"></i></span>

											<sf:input path="mobileNo" placeholder="${mobileNo}"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="mobileNo" cssClass="error" />
										</label>
									</div>
								</div>
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"> <s:message
											code="user.label.dob" /> <span style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-calendar"></i></span>

											<sf:input path="dob" placeholder="${dob}" readonly="true" id="datepicker"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="dob" cssClass="error" />
										</label>
									</div>
								</div>
								
							</div>


							<div class="form-group" align="center">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-left: 50px;">

									

											<br>
											<button type="submit" class="btn btn-success"
												name="operation" value="Update">
												<span class="glyphicon glyphicon-ok-sign"></span>
												<s:message code="op.update"></s:message>
											</button>
											<button type="submit" class="btn btn-primary" style="width: 159px;"
												name="operation" value="Change Password">
												<span class="glyphicon glyphicon-edit"></span>
												<s:message code="button.changePassword"></s:message>
											</button>

										<br>

								</div>
							</div>
						</div>
					</div>
				</div>
				
	</sf:form>
	
	<br>

</body>

</html>
	