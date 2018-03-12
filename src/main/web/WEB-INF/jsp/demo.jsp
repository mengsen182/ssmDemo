<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/5/005
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
    <script  type="text/javascript">
        $(function () {
            $("#dg").datagrid({
                url:"${pageContext.request.contextPath}/statics/json/products.json",
                method:'get',
                pagination:true,
                columns:[[
                    {
                        field:'productid',title:'商品id'
                    },
                    {
                        field:'productname',title:'商品名称'
                    }
                ]]
            })
        })
    </script>
<body>
    <table id="dg"></table>
        测试dfsd
</body>
</html>
