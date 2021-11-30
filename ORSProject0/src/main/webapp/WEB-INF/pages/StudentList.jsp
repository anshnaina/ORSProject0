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
<title>Student List</title>
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
										code="student.label.studentList"></s:message>
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


						<s:message code="user.placeholder.firstName" var="firstName"></s:message>
						<s:message code="user.placeholder.lastName" var="lastName"></s:message>
						<s:message code="student.placeholder.email" var="email"></s:message>

						<div class="container-fluid text-center">
							<div class="form-inline">

								<div class="form-group  text-center">
									<label class="control-label" for="firstName"> <s:message
											code="label.firstName" /> :
									</label> <input type="text" class="form-control" name="firstName"
										size=15 placeholder="${firstName}" value="">
								</div>

								&emsp;&emsp;

								<div class="form-group  text-center">
									<label class="control-label" for="lastName"> <s:message
											code="label.lastName" /> :
									</label> <input type="text" class="form-control" name="lastName"
										size=15 placeholder="${lastName}" value="">
								</div>

								&emsp;&emsp; <label class="control-label col-sm-1"
									for="collegeName"
									style="padding-left: 0px; padding-top: 7px; padding-right: 0px; width: 105px;"><b><font
										color="black"><s:message code="label.collegeName"></s:message>:</font>
								</b></label>
								<div class="col-sm-2">

									<sf:select STYLE="width: 100%" size="0" path="collegeId"
										cssClass="form-control" style="width: 180px;">
										<sf:option value="0">--- <s:message
												code="label.select"></s:message> ---</sf:option>
										<sf:options items="${collegeList}" itemValue="id"
											itemLabel="name"></sf:options>
									</sf:select>
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
										href="<c:url value="/ctl/Student"></c:url>"><s:message
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
														code="label.firstName" /></th>
												<th style="text-align: center;"><s:message
														code="label.lastName" /></th>
												<th style="text-align: center;"><s:message
														code="label.dob" /></th>
												<th style="text-align: center;"><s:message
														code="label.mobileNo" /></th>

												<th style="text-align: center;"><s:message
														code="label.email" /></th>


												<th style="text-align: center;"><s:message
														code="label.collegeName" /></th>
												<c:if test="${sessionScope.user.roleId==1 }">
													<th style="text-align: center;"><s:message
															code="button.edit" /></th>
												</c:if>

											</tr>
										</thead>
										<tbody>
											<c:url var="editUrl" value="/ctl/Student?id=" />
											<c:forEach items="${list}" var="student" varStatus="ct">
												<tr>
													<c:if test="${sessionScope.user.roleId==1 }">
														<td align="center"><input type="checkbox" name="ids"
															value="${student.id}"></td>
													</c:if>

													<td align="center">${(form.pageSize * (form.pageNo-1))+ct.index+1}</td>
													<td align="center">${student.firstName}</td>
													<td align="center">${student.lastName}</td>
													<td align="center"><fmt:formatDate
															value="${student.dob }" /></td>
													<td align="center">${student.mobileNo}</td>
													<td align="center">${student.email}</td>

													<c:forEach items="${collegeList}" var="college">
														<c:if test="${student.collegeId==college.id}">
															<td align="center">${college.name}</td>
														</c:if>
													</c:forEach>

													<c:if test="${sessionScope.user.roleId==1 }">
														<td style="size: 20%; text-align: center;"><a
															href="${editUrl}${student.id}"> <span
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
											test="${list.size()==form.pageSize && !((studentList.size()==form.pageSize*form.pageNo))}">

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