<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form method="post" action="patients">
    <button>dupa</button>
    </form>
    <a><c:out value='${requestScope.patientInfo}'/></a>
  <%--       <table id="messages" border="1">
            <tr>
                <th>Message</th>
                <th>Type</th>
            </tr>
             
            <c:forEach var="msg" items='${sessionScope.message}'>
                <tr>
                    <td><c:out value='${msg[0]}'/></td>
                    <td><c:out value='${msg[1]}'/></td>
                </tr>
            </c:forEach>    
        </table> --%>
 
   			 <a href=tester.jsp>przejsd tu</a>    
    </body>
</html>