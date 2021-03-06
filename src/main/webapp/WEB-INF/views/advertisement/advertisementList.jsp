<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 11.02.2020
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>User adv list</title>

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
                <div class="row">
                    <h1 class="h3 mb-1 text-gray-800">Twoje ogłoszenia</h1>
                    <div class="col noPadding d-flex justify-content-end mb-2">
                        <a href="/advertisement/add" class="btn btn-success rounded-0
                     pt-0 pb-0 pr-4 pl-4">Dodaj ogłoszenie</a>
                    </div>
                    <!-- Content Row -->
                </div>

                <div class="row">

                    <!-- Border Bottom Utilities -->
                    <div class="col-lg-12">
                        <c:forEach items="${advertisements}" var="advertisement">
                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <c:out value="${advertisement.title}"/>,
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                </div>

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
