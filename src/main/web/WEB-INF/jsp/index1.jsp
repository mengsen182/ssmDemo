<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4/004
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
<body>
    <div class="easyui-window" title="登录"
    style="top: 20%;left: 30%;width: 500px;height: 400px;padding: 50px 120px;">
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <table>
                <tr>
                    <td>用户名:</td>
                    <td>
                        <input type="text" class="easyui-textbox" name="userName"/>
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input class="easyui-passwordbox" name="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="登录" class="easyui-linkbutton" style="width: 80px;height: 40px">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
