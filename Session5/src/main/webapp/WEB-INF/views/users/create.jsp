<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cập nhật thông tin</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../resources/assets/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../resources/assets/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="../layout/nav.jsp"></jsp:include>
    <jsp:include page="../layout/aside.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content">
            <div class="card">
                <div class="card-body">
                    <div class="container">
                        <h1>Add Profile</h1>
                        <hr>
                        <f:form  method="post" enctype="multipart/form-data" modelAttribute="user" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Email:</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="email" type="text"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="email"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Password :</label>
                                <div class="col-lg-8">

                                    <f:input class="form-control" path="password" type="password"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="password"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Phone :</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="phone" type="text"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="phone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Image :</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="image" type="file"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="image" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Birthday :</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="birthday" type="date"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="birthday"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Address :</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="address" type="text"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="address"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Status :</label>
                                <div class="col-lg-8">
                                    <f:input class="form-control" path="status" type="text"/>
                                </div>
                                <div class="col-lg-8">
                                    <f:errors class="form-control" path="status"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <button class="btn btn-primary">Add</button>
                                    <span></span>
                                    <input type="reset" class="btn btn-default" value="Cancel">
                                </div>
                            </div>
                        </f:form>
                    </div>
                </div>

                <div class="card-footer">
                    Footer
                </div>
            </div>
        </section>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../layout/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../../resources/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../resources/assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../resources/assets/dist/js/demo.js"></script>
</body>
</html>