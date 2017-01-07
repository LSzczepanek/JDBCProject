    <%
     String oddzialName = (String) pageContext.getAttribute("oddzial");
        String doctorName = (String) pageContext.getAttribute("doctor");
    %>
    <header class="w3-container w3-teal">
        <div class="w3-row">
            <div class="w3-half">
                <h1 class="w3-lobster">Szpital im. Napoleona Bonaparte</h1>
            </div>
            <div class="w3-half w3-right-align">
            </div>
        </div>
        <p class="w3-lobster" align="right"><%=oddzialName %></p>
        <p class="w3-lobster" align="right"><%=doctorName %></p>
    </header>