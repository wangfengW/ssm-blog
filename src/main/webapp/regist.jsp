<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/regist.html" method="post">
    用户名：<input type="text" name="userName" id="userName" onblur="check('userName')"/><span id="msg"></span><br/>
    密码：<input type="password" name="password"/><br/>
    确认密码：<input type="password" name="repwd"/><br/>
    <input type="button" value="注册" onclick="check('btn')"/>
</form>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function check(obj) {
        $.ajax({
            url: "/user/check.html",
            data: "userName=" + $("#userName").val(),
            success: function (data) {
                $("#msg").html(data.msg)
                if (data.status == true && obj == "btn") {
                    $("form").submit();
                }

            }
        })
    }

</script>

</body>
</html>
