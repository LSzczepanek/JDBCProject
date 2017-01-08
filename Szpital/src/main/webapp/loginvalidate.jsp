
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

	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<%
		Object[] wardData = (Object[]) request.getAttribute("wardData");
		session.setAttribute("doctor_id", wardData[0]);
		String doctor = "Dr. " + (String) wardData[1] + " " + wardData[2];
		session.setAttribute("doctor", doctor);
		session.setAttribute("ward_id", wardData[3]);
		session.setAttribute("ward", wardData[4]);
		session.setAttribute("patientAmount", wardData[5]);
		String check = "check";
		session.setAttribute("check", check);

		String redirectURL = "/Szpital/welcome.jsp";
		response.sendRedirect(redirectURL);
	%>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%@include file="resources/includes/footer.jsp"%>

</body>
</html>