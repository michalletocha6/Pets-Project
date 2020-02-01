<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Pet <span>Lovers</span>
        </a>
        <%--        To wyswietlamy gdy uzytkownik jest zalogowany--%>
        <%--        <img  class="user-photo" src="img/userNoPhoto.jpg"/>--%>
        <%--        <span class="user-name">michalletocha</span>--%>
        <a class="login" href="/login">Zaloguj się</a>
    </nav>
</header>
</body>
</html>
