<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/19
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    成功

    <table cellpadding="5" cellspacing="0" border="1">
        <tr><th>id</th><th>name</th><th>course</th><th>address</th></tr>
        <c:forEach items="${info.list}" var="t">
            <tr>
                <td>${t.id}</td>
                <td>${t.name}</td>
                <td>${t.course}</td>
                <td>${t.address}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="${pageContext.servletContext.contextPath}/getTeaAll?pn=1">首页</a>
                <a href="${pageContext.servletContext.contextPath}/getTeaAll?pn=${info.prePage}">上一页</a>
                当前页${info.pageNum}
                <a href="${pageContext.servletContext.contextPath}/getTeaAll?pn=${info.nextPage}">下一页</a>
                <a href="${pageContext.servletContext.contextPath}/getTeaAll?pn=${info.pages}">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
