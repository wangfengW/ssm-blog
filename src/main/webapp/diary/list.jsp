<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>日记</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<!--content start-->
<div id="content">
    <!--left-->
    <div class="left" id="riji">
        <div class="weizi">
            <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>个人日记</h1></div>
        </div>
        <div class="rj_content">
            <c:forEach items="${diaryList}" var="diary">
                <div class="shiguang animated bounceIn">
                    <div class="left sg_ico">
                        <img src="images/my_1.jpg" width="120" height="120" alt=""/>
                    </div>
                    <div class="right sg_text">
                        <img src="images/left.png" width="13" height="16" alt="左图标"/>
                            ${diary.content}
                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
        </div>
    </div>
    <jsp:include page="/common/right.jsp"/>

</div>

<jsp:include page="/common/footer.jsp"/>
</body>
</html>
