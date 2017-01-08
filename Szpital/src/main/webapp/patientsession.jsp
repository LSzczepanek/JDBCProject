
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
	<c:set var="patientInfo" value="${patientInfo}" scope="session" />

	<c:redirect url="patient.jsp"/>

	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%@include file="resources/includes/footer.jsp"%>

</body>
</html>