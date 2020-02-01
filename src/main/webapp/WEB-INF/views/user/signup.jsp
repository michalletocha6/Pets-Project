<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/html/navTop.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form class="padding-small text-center" method="post" action="/register">
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" id="name" name="firstName" value="${user.firstName}" placeholder="podaj imię">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="surname" name="lastName" value="${user.lastName}"
                               placeholder="podaj nazwisko">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" id="email" name="email" value="${user.email}" placeholder="podaj email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" value="${user.password}"
                               placeholder="podaj hasło">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="repassword" name="repassword"
                               placeholder="powtórz hasło">

                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                </form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/html/scripts.jsp" %>
</body>
</html>
