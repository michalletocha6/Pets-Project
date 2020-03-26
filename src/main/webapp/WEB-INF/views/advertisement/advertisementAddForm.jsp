<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 26.03.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>Pet Lovers - Add Animal</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/html/sidebar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Top Bar -->
            <%@ include file="/WEB-INF/views/html/topBar.jsp" %>
            <!-- End of Top Bar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">Add Animal</h1>

                <form:form modelAttribute="advertisement" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputName4">Nazwa</label>
                            <form:input path="title" cssClass="form-control" id="inputName4" placeholder="Nazwa"/>
                            <span style="color: red"><form:errors path="title"/></span>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputDescription">Zawartość</label>
                            <form:textarea cssClass="form-control" id="inputDescription" path="description"
                                           placeholder="Cos o pupilu"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Zapisz</button>
                </form:form>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@ include file="/WEB-INF/views/html/footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@ include file="/WEB-INF/views/html/scrollTop.jsp" %>

<!-- Logout Modal-->
<%@ include file="/WEB-INF/views/html/logout.jsp" %>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>
