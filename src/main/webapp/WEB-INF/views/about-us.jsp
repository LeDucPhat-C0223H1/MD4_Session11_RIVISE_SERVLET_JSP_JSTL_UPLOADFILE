<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BenLaptop
  Date: 11/15/2023
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP_JSTL</title>
    <jsp:include page="/WEB-INF/assests/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/assests/navbar.jsp"></jsp:include>

<div class="container-lg">
    <h1>Upload File</h1>
    <form action="<%=request.getContextPath()%>/UploadFile" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <input type="file" class="form-control" id="image" name="image" multiple>
        </div>
        <div class="mb-3">
            <label for="avatar" class="form-label">Avatar</label>
            <input type="file" class="form-control" id="avatar" name="avatar" rows="3">
        </div>
        <input class="btn btn-primary" type="submit" name="action" value="UPLOAD">
    </form>
</div>

<div class="container-lg">
    <h1>Các File Upload</h1>
    <div class="d-flex gap-2" style="border: 3px solid black">
        <c:forEach items="${listFileNames}" var="f" varStatus="loop">
            <img src="uploads/${f}" width="150" height="150" style="object-fit: cover" alt="true">
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>
</body>
</html>
