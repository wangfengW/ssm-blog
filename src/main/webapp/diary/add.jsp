<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布日记</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div id="content">
    <div class="left" id="about_me">
        <div class="weizi">
            <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>碎言碎语</h1></div>
        </div>
        <div class="about_content" style="height:100%">
            <form action="/diary/add.html" method="post">
                日记:<textarea name="content"></textarea><br/>
                <input type="submit" value="发布">
            </form>
        </div>
    </div>
    <jsp:include page="/common/right.jsp"/>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
