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
<title>Marksheet Merit List</title>
<style type="text/css">
body {
	background-image: url("/ORSProject0/resources/theam_wel/image/0.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}

.table-hover tbody tr:hover td {
	background-color: #0064ff36;
}
</style>
</head>
</head>
<body>
	<br>
	<div class="container">
		<div class="row">
			<div class="panel"
				style="background-color: rgba(218, 222, 210, 0.85); margin-bottom: 150px;">
				<div class="panel-body">
					<div align="center">

						<H2>
							<span class="glyphicon glyphicon-list"></span><b><b>&nbsp;<s:message
										code="marksheet.label.marksheetMeritList"></s:message>
							</b></b>
						</H2>
						<hr style="height: 2px; color: #000000;">
					</div>

					<br>

					<c:choose>
						<c:when test="${empty list}">
							<table align="center">
								<tr>
									<td>

										<button type="submit" name="operation"
											class=" form-control btn btn-warning" value="Back"
											style="width: 150px; height: 47px; font-size: 16px; background-color: gray;">
											<span style="margin-right: 4px;"
												class="	glyphicon glyphicon-circle-arrow-left"></span>
											<s:message code="button.back"></s:message>
										</button>

									</td>

								</tr>
							</table>
						</c:when>

						<c:otherwise>
							<div class="box-body table-responsive">

								<table class="table  table-bordered  table-hover">
									<thead bgcolor="#9999ff">
										<tr>

											<th style="text-align: center;"><s:message
													code="button.sNo" /></th>
											<th style="text-align: center;"><s:message
													code="label.rollNo" /></th>
											<th style="text-align: center;"><s:message
													code="label.student" /></th>
											<th style="text-align: center;"><s:message
													code="label.physics" /></th>
											<th style="text-align: center;"><s:message
													code="label.chemistry" /></th>
											<th style="text-align: center;"><s:message
													code="label.maths" /></th>
											<th style="text-align: center;"><s:message
													code="label.total" /></th>
											<th style="text-align: center;"><s:message
													code="label.percentage" /></th>
											<th style="text-align: center;"><s:message
													code="label.status" /></th>


										</tr>
									</thead>
									<tbody>
										<c:url var="editUrl" value="/ctl/Marksheet?id=" />
										<c:forEach items="${list}" var="marksheet" varStatus="ct">
											<tr>

												<td align="center">${(form.pageSize * (form.pageNo-1))+ct.index+1}</td>

												<td align="center">${marksheet.rollNo}</td>
												<td align="center">${marksheet.name}</td>

												<c:choose>
													<c:when test="${marksheet.physics>33}">
														<td align="center"><c:out
																value="${marksheet.physics}" /></td>
													</c:when>
													<c:otherwise>
														<td align="center"><c:out
																value="${marksheet.physics}" /><font color="red">*</font></td>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${marksheet.chemistry>33}">
														<td align="center"><c:out
																value="${marksheet.chemistry}" /></td>
													</c:when>
													<c:otherwise>
														<td align="center"><c:out
																value="${marksheet.chemistry}" /><font color="red">*</font></td>
													</c:otherwise>
												</c:choose>
												</span>

												<c:choose>
													<c:when test="${marksheet.physics>33}">
														<td align="center"><c:out
																value="${marksheet.physics}" /></td>
													</c:when>
													<c:otherwise>
														<td align="center"><c:out
																value="${marksheet.physics}" /><font color="red">*</font></td>
													</c:otherwise>
												</c:choose>

												<td align="center"><c:out
														value="${marksheet.maths  +marksheet.physics + marksheet.chemistry}" /></td>

												<td align="center"><fmt:formatNumber type="number"
														value="${(marksheet.maths + marksheet.physics + marksheet.chemistry)/3}"
														maxFractionDigits="1"></fmt:formatNumber> <c:out
														value=" %"></c:out></td>

												<c:choose>
													<c:when
														test="${marksheet.chemistry>=33 && marksheet.physics>=33 && marksheet.maths>=33}">
														<td align="center" style="color: green;"><b><s:message
																	code="getMarksheet.lable.statusPass" /> </b></td>
													</c:when>
													<c:otherwise>
														<td align="center" style="color: red;"><b><s:message
																	code="getMarksheet.lable.statusFail" /></b></td>
													</c:otherwise>
												</c:choose>

											</tr>
											<c:set var="index" value="${index+1}"></c:set>
										</c:forEach>
									</tbody>
								</table>
							</div>

							<div>

								<div class="row">

									<div class="col-sm-3" style="margin-left: 2%;"></div>

									<div class="col-sm-3" align="right">
										<a style="font-size: 16px;" href="<c:url value="/ctl/JasperCtl"></c:url>"
											class="btn btn-primary" role="button" target="blank"> <span
											style="padding-right: 6px;" class="glyphicon glyphicon-print"></span><s:message
													code="leble.print" />
										</a>
									</div>

									<div class="col-sm-3" align="left">
										<a style="font-size: 16px;" href="<c:url value="/Welcome"></c:url>"
							
											class="btn btn-warning">
											<span style="padding-right: 6px;"
												class="glyphicon glyphicon-arrow-left"></span><s:message code="button.back"></s:message>
										</a>
									</div>

									<div style="margin-top: -1px;"></div>

								</div>


							</div>
							<hr>
						</c:otherwise>
					</c:choose>

					<br>
</body>
</html>