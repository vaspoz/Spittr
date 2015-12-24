<%--
  Created by IntelliJ IDEA.
  User: Vasilii_Pozdeev
  Date: 24-Dec-15
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"/></span>
<span class="spittleLocation">
(<c:out value="${spittle.latitude}"/>,
<c:out value="${spittle.longitude}"/>)</span>
        </div>
    </li>
</c:forEach>
</body>
</html>
