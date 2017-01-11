
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="resources/includes/head.jsp"%>
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
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<div class="w3-row w3-container w3-section">
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
		<div class="w3-col m10">
			<table class="w3-table w3-section w3-striped w3-bordered w3-card-4">
				<thead>
					<tr class="w3-teal">
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>Data ur.</th>
						<th>Miasto</th>
						<th>Adres</th>
						<th>Opcje</th>
					</tr>
				</thead>
				<c:forEach var="patient" items='${sessionScope.patientInfo}'>
					<c:set var="patient_id" value="${patient[2]}" scope="page" />
					<c:set var="patientName" value="${patient[3]} ${patient[4]}"
						scope="page" />
					<td>${patient[3]}</td>
					<td>${patient[4]}</td>
					<td>${patient[5]}</td>
					<td>${patient[6]}</td>
					<td>${patient[7]}</td>
					<td><div class="w3-third">
							<a class='w3-btn w3-red'
								onclick="document.getElementById('${patient[2]}').style.display='block';">Usuń</a>
						</div>
						<div class="w3-third">
							<form action="/leki" method=post>
								<button class='w3-btn w3-blue'>Leki</button>
							</form>
						</div>
						<div class="w3-third"><a class='w3-btn w3-teal'
								onclick="document.getElementById(edit'${patient[2]}').style.display='block';">Edytuj</a></div></td>
					</tr>
					<!-- popup z zapytaniem czy usunąć -->
					<div id="${patient[2]}" class="w3-modal">
						<div class="w3-modal-content w3-animate-top w3-card-8">
							<div class="w3-container w3-section w3-red">
								<span
									onclick="document.getElementById('${patient[2]}').style.display = 'none'"
									class="w3-closebtn"><i class="fa fa-times"></i></span>
								<h2>Uwaga!</h2>
								<p>Czy na pewno chcesz usunąć ${patientName} z listy
									pacjentów?</p>
								<div class="w3-row w3-center">
									<div class="w3-half">
										<form method="post" action="patientDelete">
										<input type="hidden" name="patientId" value="${patient[2]}"/>
										<input type="hidden" name="wardId" value="${sessionScope.ward_id}"/>
										<input type="hidden" name="wardName" value="${sessionScope.ward}"/>
											<button class="w3-btn w3-red" type="submit" name="delete"
												style="width: 33.3%">
												<i class="fa fa-check"></i><b> Tak</b>
											</button>
										</form>
									</div>
									<div class="w3-half">
										<button class="w3-btn w3-red" name="cancel"
											onclick="document.getElementById('${patient[2]}').style.display = 'none'"
											style="width: 33.3%">
											<i class="fa fa-times"></i><b> Nie</b>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
					<div class="w3-third"><a>&nbsp</a></div>
					<div class="w3-third"><a>&nbsp</a></div>
					<div class="w3-third">
					<form action="patientAdd" 
							method=post>
							<button class="w3-btn w3-blue-grey">Dodaj</button>
						</form></div>
						</td>
				</tr>
			</table>

		</div>
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
	</div>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<div class="w3-row">
		<p class="w3-display-bottomright w3-text-grey w3-small">Created by
			Dawid Kiciński &amp Łukasz Szczepanek</p>
	</div>

</body>
</html>