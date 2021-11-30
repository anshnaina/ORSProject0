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
<title>Marksheet List</title>
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
										code="marksheet.label.marksheetList"></s:message>
							</b></b>
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

					<sf:form action="search" commandName="form" method="post">

						<sf:hidden path="pageNo" />
						<sf:hidden path="pageSize" />

						<s:message code="subject.placeholder.name" var="subjectName"></s:message>

						<div class="container-fluid text-center">
							<div class="form-inline">

								<s:message code="marksheet.placeholder.name" var="name"></s:message>
								<div class="form-group  text-center">
									<label class="control-label" for="rollNo"> <s:message
											code="label.student" /> :
									</label> <input type="text" class="form-control" name="name" size=15
										placeholder="${name}" value="">
								</div>

								&emsp;&emsp;


								<s:message code="marksheet.placeholder.rollNo" var="rollNo"></s:message>
								<div class="form-group  text-center">
									<label class="control-label" for="rollNo"> <s:message
											code="label.rollNo" /> :
									</label> <input type="text" class="form-control" name="rollNo" size=15
										placeholder="${rollNo}" value="">
								</div>

								&emsp;&emsp;

								<div class="form-group">
									<button type="submit" name="operation"
										class=" form-control btn btn-primary" value="Search">
										<span class="glyphicon glyphicon-search"></span>
										<s:message code="button.search" />
									</button>

									<button type="submit" name="operation"
										class=" form-control btn btn-warning" value="Reset">
										<span class="	glyphicon glyphicon-refresh"></span>
										<s:message code="button.reset" />
									</button>

								</div>
							</div>


							<hr>

							<c:choose>
								<c:when test="${sessionScope.user.roleId==1 }">
									<div style="float: right">
										<div class="col-sm-3" style="margin-left: 4%;">
											<button type="submit" name="operation" value="Delete"
												class="btn btn-danger">
												<span class="glyphicon glyphicon-trash"></span>
												<s:message code="button.delete" />
											</button>


										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div style="float: right">
										<div class="col-sm-3" style="margin-left: 4%;">
											<button type="submit" name="operation" value="Delete"
												disabled="disabled" class="btn btn-danger">
												<span class="glyphicon glyphicon-trash"></span>
												<s:message code="button.delete" />
											</button>


										</div>
									</div>

								</c:otherwise>
							</c:choose>

							<div style="float: left">
								<div class="col-sm-3">
									<a class="btn btn-primary"
										href="<c:url value="/ctl/Marksheet"></c:url>"><s:message
											code="button.new"></s:message> <span
										class="glyphicon glyphicon-plus"></a>
								</div>
							</div>

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

												<c:if test="${sessionScope.user.roleId==1 }">
													<th style="text-align: center;"><input type="checkbox"
														id="mainbox" onchange="selectAll(this)"> <s:message
															code="label.selectall" /></th>
												</c:if>

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
												<c:if test="${sessionScope.user.roleId==1 }">
													<th style="text-align: center;"><s:message
															code="button.edit" /></th>
												</c:if>

											</tr>
										</thead>
										<tbody>
											<c:url var="editUrl" value="/ctl/Marksheet?id=" />
											<c:forEach items="${list}" var="marksheet" varStatus="ct">
												<tr>

													<c:if test="${sessionScope.user.roleId==1 }">
														<td align="center"><input type="checkbox" name="ids"
															value="${marksheet.id}"></td>
													</c:if>

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

													<c:if test="${sessionScope.user.roleId==1 }">
														<td style="size: 20%; text-align: center;"><a
															href="${editUrl}${marksheet.id}"> <span
																class="glyphicon glyphicon-edit"></span></a></td>
													</c:if>

												</tr>
												<c:set var="index" value="${index+1}"></c:set>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<div>

									<c:choose>
										<c:when
											test="${list.size()==form.pageSize && !((marksheetList.size()==form.pageSize*form.pageNo))}">

											<div style="float: right">

												<div class="col-sm-4"">
													<button type="submit" name="operation" value="Next"
														class="btn btn-primary">
														<s:message code="button.next" />
														<span class="glyphicon glyphicon-chevron-right"></span>
													</button>
												</div>
											</div>

										</c:when>
										<c:otherwise>
											<div style="float: right">

												<div class="col-sm-4"">
													<button type="submit" name="operation" value="Next"
														disabled="disabled" class="btn btn-primary">
														<s:message code="button.next" />
														<span class="glyphicon glyphicon-chevron-right"></span>
													</button>
												</div>
											</div>

										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${form.pageNo==1}">
											<div style="float: left">
												<div class="col-sm-4"">
													<button type="submit" name="operation" value="Previous"
														disabled="disabled" class=" btn btn-primary">
														<span class="glyphicon glyphicon-chevron-left"></span>
														<s:message code="button.previos" />
													</button>
												</div>

											</div>

										</c:when>
										<c:otherwise>
											<div style="float: left">
												<div class="col-sm-4"">
													<button type="submit" name="operation" value="Previous"
														class=" btn btn-primary">
														<span class="glyphicon glyphicon-chevron-left"></span>
														<s:message code="button.previos" />
													</button>
												</div>

											</div>


										</c:otherwise>
									</c:choose>

								</div>
								<hr>
							</c:otherwise>
						</c:choose>
					</sf:form>
					<br>
</body>
</html>