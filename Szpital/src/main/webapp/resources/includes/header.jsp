<c:set var="wardName" value=" " scope="page" />
<c:set var="doctorName" value=" " scope="page" />
<c:if test="${not empty sessionScope.ward}">
	<c:set var="wardName" value="${sessionScope.ward}" scope="page" />
</c:if>
<c:if test="${not empty sessionScope.doctor}">
	<c:set var="doctorName" value="${sessionScope.doctor}" scope="page" />
</c:if>
<header class="w3-container w3-teal">
	<div class="w3-row">
		<div class="w3-half">
			<h1 class="w3-lobster">Szpital im. Napoleona Bonaparte</h1>
			<c:if test="${not empty sessionScope.check}">
			<p><a href="logout.jsp" onclick="document.getElementById('wait').style.display='block';"><i class="fa fa-sign-out"></i></a></p>
			</c:if>
		</div>
		<div class="w3-half w3-right-align">
			<h2 align="right">
				<c:out value='${wardName}' />
			</h2>
			<p align="right">
				<c:out value='${doctorName}' />
			</p>
			
		</div>
	</div>

</header>