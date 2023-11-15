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
    <h1>Add Word For Dictionary</h1>
    <form action="<%=request.getContextPath()%>/Dictionary" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="image" class="form-label">Image url</label>
            <input type="file" class="form-control" id="image" name="image">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name of word</label>
            <input type="text" class="form-control" id="name" name="name" rows="3">
        </div>
        <input class="btn btn-primary" type="submit" name="action" value="ADD">
    </form>
</div>

<div class="container-lg">
    <h1 class="ms-3">Các từ vựng trong từ điển</h1>
    <c:forEach items="${dictionary}" var="w" varStatus="loop">
        <div class="m-3 d-flex gap-2" style="border: 3px solid black">
            <img src="uploads/${w.imageUrl}" width="150" height="150" style="object-fit: cover">
            <div>
                <p class="text-content">${w.name}</p>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>
</body>
</html>
