
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
	<%@include file="resources/includes/header.jsp"%>
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%
		session.invalidate();
	%>
	<c:set var="error_msg" value="${requestScope.error}" scope="page" />
	<div id="main" class="w3-container w3-section w3-main">
		<div class="w3-third w3-container"></div>
		<div class="w3-card-4 w3-center w3-third">
			<div class="w3-container w3-teal">
				<h2>Zaloguj się</h2>
			</div>
			<form action="loginvalid" class="w3-container" method=post onsubmit="document.getElementById('wait').style.display='block';">
				<input class="w3-input" type="text" name="login" required> <label
					class="w3-label w3-validate">Login</label> <input class="w3-input"
					type="password" name="password" required> <label
					class="w3-label w3-validate" style="display: block">Hasło</label> <br>
				<button class="w3-btn-block w3-blue-grey w3-hover-green">Login</button>
			</form>
			<p class="w3-text-red">${error_msg}</p>
		</div>
		<div class="w3-third w3-container"></div>
	</div>

	<!-- popup z czekaniem -->
	<div id="wait" class="w3-modal w3-animate-opacity w3-center">
		<a onclick="document.getElementById('wait').style.display = 'none';"><i class="fa fa-spinner fa-pulse fa-3x fa-fw w3-text-white"></i></a>
	</div>

	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<div class="w3-row">
		<p class="w3-display-bottomright w3-text-grey w3-small">Created by
			Dawid Kiciński &amp Łukasz Szczepanek</p>
	</div>

</body>
</html>