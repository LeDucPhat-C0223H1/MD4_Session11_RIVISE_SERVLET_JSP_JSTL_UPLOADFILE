<%--
  Created by IntelliJ IDEA.
  User: BenLaptop
  Date: 11/15/2023
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" >
    <div class="container-fluid d-flex justify-content-between" style="background: orange">
        <a class="navbar-brand" href="#">
            <img src="https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            Navbar
        </a>
        <div class="" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link ${action=='home'?'text-success':''} fs-5 fw-medium"  href="<%=request.getContextPath()%>/PageServlet?action=HOME">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${action=='product'?'text-success':''} fs-5 fw-medium" href="<%=request.getContextPath()%>/PageServlet?action=PRODUCT">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${action=='about'?'text-success':''} fs-5 fw-medium"  href="<%=request.getContextPath()%>/PageServlet?action=ABOUT_US">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${action=='profile'?'text-success':''} fs-5 fw-medium" href="<%=request.getContextPath()%>/PageServlet?action=PROFILE">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${action=='cart'?'text-success':''} fs-5 fw-medium" href="<%=request.getContextPath()%>/PageServlet?action=CART">Cart</a>
                </li>
            </ul>
        </div>
        <div class="navbar-brand d-flex gap-3">
            <button type="button" class="btn" style="background: #FFCC33">Login</button>
            <button type="button" class="btn" style="background: #FFCC33">Sign Up</button>
        </div>

    </div>
</nav>
</body>
</html>
