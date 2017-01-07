
<%
	String wardName = "&nbsp";
	if((String) session.getAttribute("ward") != null)
	{
		wardName = (String) session.getAttribute("ward");
	}

	String doctorName = "&nbsp";
	if((String) session.getAttribute("doctor") != null)
	{
		doctorName = (String) session.getAttribute("doctor");
	}

%>
<header class="w3-container w3-teal">
	<div class="w3-row">
		<div class="w3-half">
			<h1 class="w3-lobster">Szpital im. Napoleona Bonaparte</h1>
		</div>
		<div class="w3-half w3-right-align"></div>
	</div>
	<h2 align="right"><%=wardName%></h2>
	<p  align="right"><%=doctorName%></p>
</header>