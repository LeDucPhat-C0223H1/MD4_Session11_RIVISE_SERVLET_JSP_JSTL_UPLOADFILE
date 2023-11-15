<%@ page import="ra.practicejsp_jstl_15112023.controller.PageServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP_JSTL</title>
    <jsp:include page="/WEB-INF/assests/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/assests/navbar.jsp"></jsp:include>


<c:if test="${action==null}">
    <%
        response.sendRedirect(request.getContextPath() + "/PageServlet?action=HOME");
    %>
</c:if>
<div class="container-lg">
    <h1 class="ms-3">Các bài biết</h1>
    <c:forEach items="${list}" var="n" varStatus="loop">
        <div class="m-3 d-flex gap-2" style="border: 3px solid black">
            <img src="${n.imageUrl}" width="150" height="150" style="object-fit: cover">
            <div>
                <h3 class="fw-medium">${n.title}</h3>
                <p class="text-content">${n.content}</p>
                <p class="fst-italic text-end me-1">${n.author}</p>
            </div>
        </div>
    </c:forEach>
</div>




<jsp:include page="/WEB-INF/assests/foot.jsp"></jsp:include>
</body>
</html>