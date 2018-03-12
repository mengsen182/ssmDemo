<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4/004
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>

<body>
    <div class="easyui-layout" style="width:100%; height:100%;">
        <div region="north" style="height: 20%;padding: 20px;">
            <div align="center">
                <h2>学生管理系统</h2>
            </div>
            <div align="right">
                <h3>欢迎您:${loginUser.nickName}</h3>
            </div>
        </div>
        <div region="south">
            <div align="center" style="padding: 4px;">
                <h4>北大青鸟</h4>
            </div>
        </div>
        <div region="west" title="菜单栏" style="width: 20%">
            <%--<li>
                <a href="#" src="${pageContext.request.contextPath}/demo/datagridDemo">demo</a>
            </li>
            <li>
                <a href="#" src="${pageContext.request.contextPath}/hobby/toHobby">爱好管理</a>
            </li>
            <li>
                <a href="#" src="${pageContext.request.contextPath}/score/toScore">成绩管理</a>
            </li>--%>
            <ul id="tree"></ul>
        </div>
        <div region="center" border="false">
            <div class="easyui-tabs" style="width: 100%;height: 100%;" id="tt">
                <div title="欢迎" style="padding: 20px;">
                    欢迎使用
                </div>
            </div>
        </div>
    </div>
</body>
</html>
