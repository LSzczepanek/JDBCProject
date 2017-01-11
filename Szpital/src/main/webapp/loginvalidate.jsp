
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="resources/includes/head.jsp"%>
</head>
<body>
	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<c:set var="doctor_id" value="${wardData[0]}" scope="session" />
	<c:set var="doctor" value="Dr. ${wardData[1]} ${wardData[2]}" scope="session" />
	<c:set var="ward_id" value="${wardData[3]}" scope="session" />
	<c:set var="ward" value="${wardData[4]}" scope="session" />
	<c:set var="patientAmount" value="${wardData[5]}" scope="session" />
	<c:set var="check" value="check" scope="session" />
	<c:redirect url="welcome.jsp"/>

	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%@include file="resources/includes/footer.jsp"%>

</body>
</html>