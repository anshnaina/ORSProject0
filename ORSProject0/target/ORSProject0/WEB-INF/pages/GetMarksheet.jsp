<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Marksheet</title>
<style type="text/css">
body {
	background-image: url("/ORSProject0/resources/theam_wel/image/0.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}

td, tr, th {
	background-color: white;
}
</style>
</head>

<body>

	<sf:form method="Post" commandName="form">

		<br>
		<div class="container">
			<div class="row">
				<div class="panel"
					style="background-color: rgba(218, 222, 210, 0.85); margin-bottom: 150px;">
					<div class="panel-body">
						<div align="center">

							<H2>
								<span class="glyphicon glyphicon-list"></span><b> <b><s:message code="header.getMarksheet"></s:message>
					</b> </b>
							</H2>
							<hr style="height: 2px; color: #000000;">
						</div>

						<div class="text-center">


						<div class="text-center col-md-offset-4">
							<h2 style="position: absolute;; margin-top: 10px;">
								<font color="green"><i style="margin-left: 25px;"> <b
										class="error">${success}</b></i></font>
							</h2>
						</div>


						<div class="text-center col-md-offset-4">
							<h2 style="position: absolute; margin-top: 10px;">
								<font color="brown"><i style="margin-left: 25px;"> <b
										class="error">${error}</b></i></font>
							</h2>
						</div>

						</div>

						<br> <br> <br>


						<div class="container-fluid text-center">
							<div class="form-inline">
								<div class="form-group  text-center">
								<s:message code="marksheet.placeholder.rollNo" var="rollNo"></s:message>
									<label class="control-label" for="rollNo"> <s:message code="label.rollNo" />. :</label> 
									<sf:input path="rollNo" class="form-control" id="rollNo"
											name="rollNo" placeholder="${rollNo }" />
									
										<br>
									     <label class="control-label text-danger" for="inputError1">
											<sf:errors path="rollNo" cssClass="error" />
										</label>
									
								</div>

								&emsp;&emsp;


								<div class="form-group">
									<button type="submit" name="operation"
										class=" form-control btn btn-primary" value="Go">
										<span class="glyphicon glyphicon-search"></span> <s:message code="button.go" />
									</button>
									
									<a class="btn btn-warning"
										href="<c:url value="/ctl/Marksheet/GetMarksheet"></c:url>"><span
										class="glyphicon glyphicon-refresh"></span> <s:message
											code="button.reset"></s:message> </a>

								</div>
							</div>
							<hr>
							<br> <br>

							<c:if test="${(error==null)&&(not empty form.rollNo)}">
								<div class="box-body table-responsive">
									<table class="table  table-bordered table-striped">
										<tbody>
											<tr>
												<td colspan="4" bgcolor="#BFC9CA" align="center"><b><i
														style="font-size: x-large;"><s:message
																code="getMarksheet.marksheet"></s:message></i></b></td>
											</tr>
											<tr>
												<td style="text-align: center;"><s:message
														code="label.rollNo"></s:message> :</td>
												<td colspan="3"><c:out value="${form.rollNo}" /></td>
											</tr>
											<tr>
												<td style="text-align: center;"><s:message
														code="label.name"></s:message> :</td>
												<td colspan="3" class="space"><c:out
														value="${form.name}" /></td>
											</tr>
											<tr>
												<td style="text-align: center;"><b><s:message
															code="getMarksheet.lable.subjectName"></s:message> :</b></td>
												<td style="text-align: center;"><b><s:message
															code="getMarksheet.lable.maxMarks"></s:message> :</b></td>
												<td style="text-align: center;"><b><s:message
															code="getMarksheet.lable.minMarks"></s:message> :</b></td>
												<td style="text-align: center;"><b><s:message
															code="getMarksheet.lable.obtainedMarks"></s:message> :</b></td>
											</tr>
											<tr>
												<td style="text-align: center;"><s:message
														code="label.physics" /></td>
												<td style="text-align: center;">100</td>
												<td style="text-align: center;">35</td>
												<td style="text-align: center;"><c:choose>
														<c:when test="${form.physics>=33}">
															<c:out value="${form.physics}"></c:out>
														</c:when>
														<c:otherwise>
															<c:out value="${form.physics}"></c:out>
															<font color="red"><b>*</b></font>
														</c:otherwise>
													</c:choose></td>
											</tr>
											<tr>
												<td style="text-align: center;"><s:message
														code="label.chemistry" /></td>
												<td style="text-align: center;">100</td>
												<td style="text-align: center;">35</td>
												<td style="text-align: center;"><c:choose>
														<c:when test="${form.chemistry>=33}">
															<c:out value="${form.chemistry}"></c:out>
														</c:when>
														<c:otherwise>
															<c:out value="${form.chemistry}"></c:out>
															<font color="red"><b>*</b></font>
														</c:otherwise>
													</c:choose></td>
											</tr>
											<tr>
												<td style="text-align: center;"><s:message
														code="label.maths" /></td>
												<td style="text-align: center;">100</td>
												<td style="text-align: center;">35</td>
												<td style="text-align: center;"><c:choose>
														<c:when test="${form.maths>=33}">
															<c:out value="${form.maths}"></c:out>
														</c:when>
														<c:otherwise>
															<c:out value="${form.maths}"></c:out>
															<font color="red"><b>*</b></font>
														</c:otherwise>
													</c:choose></td>
											</tr>

											<c:set var="total"
												value="${(form.maths  +form.physics + form.chemistry)}"></c:set>
											<c:set var="percentage"
												value="${(form.maths  +form.physics + form.chemistry)/3}"></c:set>



											<tr>
												<td style="text-align: center;"><s:message
														code="label.total" /></td>
												<td style="text-align: center;">300</td>
												<td style="text-align: center;"></td>
												<td style="text-align: center;">${total}</td>
											</tr>
											
											<tr>
												<td colspan="4"> </td>
											</tr>

											<tr>
												<th style="text-align: center;"><s:message
														code="label.percentage" /></th>

												<td align="center"><b><i>
												<fmt:formatNumber type="number"
														value="${percentage}" maxFractionDigits="1"></fmt:formatNumber>
													<c:out value=" %"></c:out></i></b></td>

												<td align="center"><b><i><s:message
																code="label.status" /></i></b></td>

												<c:choose>
													<c:when
														test="${form.chemistry>=33 && form.physics>=33 && form.maths>=33}">
														<td align="center" style="color: green;"><b><s:message
																	code="getMarksheet.lable.statusPass" /> </b></td>
													</c:when>
													<c:otherwise>
														<td align="center" style="color: red;"><b><s:message
																	code="getMarksheet.lable.statusFail" /></b></td>
													</c:otherwise>
												</c:choose>


											</tr>

										</tbody>
									</table>
								</div>

								

								</div>

								<hr>
						</div>
						</c:if>
	</sf:form>

	<br>

</body>
</html>
