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
<title>Change Password</title>
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
			<div class="row" style="height: 650px;">
				<div class="col-xs-12 col-md-6 col-sm-12 col-lg-4 col-md-offset-4">
					<div class="panel panel-primary"
						style="margin-top: 10px; background-color: #DCDCDC;">
						<div class="panel-heading" style="background-color: #e9967a00"
							align="center">


							<s:message code="changepassword.leble"></s:message>

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

								<s:message code="label.oldPassword" var="oldPassword" />
								<s:message code="label.newPassword" var="newPassword" />
								<s:message code="label.confirmPassword" var="confirmPassword" />
								
								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6" style="padding-top: 10px;
										style="width: 180px;"> <s:message
											code="label.oldPassword" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-lock"></i></span>

											<sf:password path="oldPassword"
												placeholder="${oldPassword}" class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="oldPassword" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6">
										<s:message code="label.newPassword" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-lock"></i></span>

											<sf:password path="newPassword" placeholder="${newPassword}"
												class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="newPassword" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" style="margin-left: 10%;">
									<label align="left" class="control-label text-info col-md-6"
										style="width: 180px;"> <s:message
											code="user.label.confirmPassword" /> <span
										style="color: red;">*</span>
									</label>

									<div class="col-md-12" style="margin-bottom: 10px;">
										<div class="input-group">
											<span class="input-group-addon"> <i
												class="glyphicon glyphicon-lock"></i></span>

											<sf:password path="confirmPassword"
												placeholder="${confirmPassword}" class="form-control" />
										</div>

										<label class="control-label text-danger" for="inputError1">
											<sf:errors path="confirmPassword" cssClass="error" />
										</label>
									</div>
								</div>

								<div class="form-group" align="center">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-left: 40px; height: 70px;">

									

											<br>
											<button type="submit" class="btn btn-success"
												name="operation" value="Save">
												<span class="glyphicon glyphicon-ok-sign"></span>
												<s:message code="op.save"></s:message>
											</button>
											<button type="submit" class="btn btn-primary" style="width: 159px;"
												name="operation" value="Change my profile">
												<span class="glyphicon glyphicon-edit"></span>
												<s:message code="button.changeMyProfile"></s:message>
											</button>

										<br>

								</div>
							</div>
					</div>
				</div>
				
				</div>
				</div>
				
	</sf:form>
	
	<br>

</body>

</html>
	