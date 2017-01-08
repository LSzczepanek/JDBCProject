
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <%@include file="resources/includes/head.jsp" %>
</head>
<body>
    <!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <% 
    
    	String checkPage = (String) session.getAttribute("check");
    	if (checkPage != "check")
    	{
    		String redirectURL = "/Szpital/index.jsp";
    	    response.sendRedirect(redirectURL);
    	}
    %> 
    <%@include file="resources/includes/header.jsp" %>
    <!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <div class="w3-row w3-container w3-section">
        <div class="w3-col m1 w3-hide-small"><p>&nbsp</p></div>
        <div class="w3-col m10">
            <div class="w3-card-4">
                <div class="w3-container w3-teal">
                    <h2>Witaj ${doctor}</h2>
                </div>
                <div class="w3-container">
				<p>Obecnie na oddziale ${ward} znajduje się ${patientAmount} pacjentów. Aby przejrzeć ich listę wciśnij przycisk <b>Lista</b></p>
				<form action="patients" class="w3-container" method=post>
				<input type="hidden" name="ward" value="${ward}">
				<br><button class="w3-btn w3-blue-grey w3-center">Lista</button>
				</form>
                </div>
            </div>
        </div>
        <div class="w3-col m1 w3-hide-small"><p>&nbsp</p></div>
    </div>
    
    
    <!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <%@include file="resources/includes/footer.jsp" %>

</body>
</html>