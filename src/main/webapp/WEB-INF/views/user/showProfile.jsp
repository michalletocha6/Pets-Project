<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 03.02.2020
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/html/navTop.jsp" %>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="/WEB-INF/views/html/dashboardSideNav.jsp" %>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba ogłoszeń: ${recipesAmount}</span>
                    </div>
                    <div class="alert-item alert-light">
                        <span>Moje zwierzaki: </span>
<%--                        Pierwsze zdjecie kazdego zwierzaka, linkujace na jego profil--%>
<%--                        <img src=""/>--%>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <div>
                    Wyswietlic informacje o uzytkowniku, zdjecie, opis itp.
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/html/scripts.jsp" %>
</body>
</html>
