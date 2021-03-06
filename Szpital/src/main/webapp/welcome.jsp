
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
			<div class="w3-card-4">
				<div class="w3-container w3-teal">
					<h2>Witaj ${doctor}</h2>
				</div>
				<div class="w3-container">
					<p>
						Obecnie na oddziale ${ward} znajduje się ${patientAmount}
						pacjentów. Aby przejrzeć ich listę wciśnij przycisk <b>Lista</b>
					</p>
					<form action="patients" class="w3-container w3-center" method=post
						onsubmit="document.getElementById('wait').style.display='block';">
						<input type="hidden" name="wardName" value="${ward}" />
						<button class="w3-btn w3-blue-grey">Lista</button>
					</form>
				</div>
			</div>
		</div>
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
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