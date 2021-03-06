
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="resources/includes/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</head>
<body>
	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<c:if test="${empty sessionScope.check}">
		<%
			session.invalidate();
		%>
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="resources/includes/header.jsp"%>
	<div class="w3-row-padding">
		<div class="w3-quarter w3-right">
			<form name="search" class="w3-container w3-tiny" method="post"
				action="DrugSearchServlet"
				onsubmit="document.getElementById('wait').style.display='block';">
				<div class="w3-col m10">
					<input class="w3-input w3-border-0" type="text" name="search"
						placeholder="Szukaj"> <input type="hidden"
						name="patientId" value="${patientId}" />
				</div>
				<div class="w3-col m2">
					<span class="w3-opennav w3-xlarge " onclick="search.submit();"><i
						class="fa fa-search w3-text-grey"></i></span>
				</div>

			</form>
		</div>
	</div>
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<script type="text/javascript">
		document.getElementById('wait').style.display = 'none';
	</script>
	<c:set var="error_msg" value="${requestScope.error}" scope="page" />
	<c:set var="patientId" value="${requestScope.patientId}" scope="page" />
	<c:set var="patientName" value="${requestScope.patientInfo[0]}"
		scope="page" />
	<c:set var="patientSurname" value="${requestScope.patientInfo[1]}"
		scope="page" />
	<p class="w3-text-red">${error_msg}</p>
	<div class="w3-row w3-container w3-section">
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
		<div class="w3-col m10">
			<table class="w3-table w3-section w3-striped w3-bordered w3-card-4">
				<thead>
					<tr class="w3-teal">Pacjent ${patientName} ${patientSurname}
					</tr>
					<tr class="w3-teal">
						<th>Nazwa</th>
						<th>Ilość w magazynie</th>
						<th>Obecna ilość</th>
					</tr>
				</thead>
				<c:forEach var="drug" items='${requestScope.drugs}'>
					<td>${drug[1]}</td>
					<td>${drug[2]}</td>

					<td>
						<div class="w3-half">
							<form action="adddrug" method=post
								onsubmit="document.getElementById('wait').style.display='block';">
								<input class="w3-input w3-border-0" name="drugAmount"
									type="number" min="0" value="${fn:replace(drug[3],' ', '')}"
									id="drugAmount'${drug[0]}'" required /> <input type="hidden"
									name="patientId" value="${patientId}" /> <input type="hidden"
									name="wardName" value="${wardName}" /> <input type="hidden"
									name="drugCurrentAmount" value="${fn:replace(drug[3],' ', '')}" />
								<input type="hidden" name="drugId" value="${drug[0]}" />
						</div>
						<div class="w3-half">

							<button class='w3-btn w3-blue'>Zmien ilość</button>
							</form>
						</div>
					</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
	</div>

	<div class="w3-container">
		<form action="patients" method=post>
			<input type="hidden" name="wardName" value="${wardName}" />
			<button class='w3-btn w3-teal'>Powrót do listy pacjentów</button>
		</form>
	</div>


	<!-- popup z czekaniem -->
	<div id="wait" class="w3-modal w3-animate-opacity w3-center">
		<a onclick="document.getElementById('wait').style.display = 'none';"><i
			class="fa fa-spinner fa-pulse fa-3x fa-fw w3-text-white"></i></a>
	</div>
	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<div class="w3-row">
		<p class="w3-display-bottomright w3-text-grey w3-small">Created by
			Dawid Kiciński &amp Łukasz Szczepanek</p>
	</div>
</body>
</html>