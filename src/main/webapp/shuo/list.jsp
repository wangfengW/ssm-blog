<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div id="say">
    <div class="weizi">
        <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>碎言碎语</h1></div>
    </div>
    <c:forEach items="${shuoPage.list}" var="shuo">
        <ul class="say_box">
            <div class="sy">
                <p>${shuo.content}</p>
            </div>
            <span class="dateview"><fmt:formatDate value="${shuo.createdDate}" pattern="yyyy-MM-dd"/></span>
        </ul>
    </c:forEach>
    <!--依赖于PageHelper的插件-->
    <c:forEach begin="${shuoPage.navigateFirstPage}" end="${shuoPage.navigateLastPage}" var="pn">
        <a href="/shuo/list.html?userId=${param.userId}&pageNo=${pn}"><span style="${shuoPage.pageNum==pn?'font-weight:bold':''}">${pn}</span></a>
    </c:forEach>
    <!--自己写的分页插件-->
    <jsp:include page="/common/pager.jsp">
        <jsp:param name="navNum" value="6"/>
        <jsp:param name="pageNum" value="${shuoPage.pageNum}"/>
        <jsp:param name="totalPage" value="${shuoPage.pages}"/>
        <jsp:param name="url" value="/shuo/list.html?userId=${param.userId}"/>
    </jsp:include>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
