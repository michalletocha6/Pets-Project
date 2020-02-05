<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 05.02.2020
  Time: 17:35
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
                <h1 class="h3 mb-4 text-gray-800">Add Animal 1 of 2</h1>

                <form:form modelAttribute="animal" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputName4">Imię</label>
                            <form:input path="name" cssClass="form-control" id="inputName4" placeholder="Imię"/>
                            <span style="color: red"><form:errors path="name"/></span>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputType">Rodzaj</label>
                            <form:select path="type" cssClass="form-control" id="inputType">
                                <form:option value="" label="--Please Select--"/>
                                <form:options items="${types}" itemLabel="name" itemValue="id"/>
                            </form:select>
                            <span style="color: red"><form:errors path="type"/></span>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="inputDescription">Opis pupila</label>
                        <form:textarea cssClass="form-control" id="inputDescription" path="description"
                                       placeholder="Cos o pupilu"/>
                    </div>
                    <button type="submit" class="btn btn-primary">1 z 2</button>
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