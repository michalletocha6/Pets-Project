<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/html/navTop.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form:form modelAttribute="appUser" cssClass="padding-small text-center" method="post" action="/login">
                    <h1 class="text-color-darker">Logowanie</h1>
                    <div class="form-group">
                        <label>Email: </label>
                        <form:input path="email" cssClass="form-control" placeholder="Podaj email"/>
                    </div>
                    <div class="form-group">
                        <label>Hasło: </label>
                        <form:input path="password" cssClass="form-control" placeholder="Podaj hasło" type="password"/>
                        <form:errors path=""/>
                    </div>
                    <br>
                    <br>
                    <span>Nie masz konta?<a href="/register"> Zarejestruj się</a></span>
                    <br>
                    <br>
                    <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/html/scripts.jsp" %>
</body>
</html>
