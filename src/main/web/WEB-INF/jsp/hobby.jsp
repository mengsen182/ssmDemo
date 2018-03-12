<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4/004
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#hg").datagrid({
                url:"${pageContext.request.contextPath}/hobby/queryHobbyList",
                method:"GET",
                pagination:true,
                toolbar:[
                    {
                        text:'添加爱好',iconCls:'icon-add',handler:function () {
                        addHobby();
                    }
                    },{
                    text:'批量删除',iconCls:'icon-remove',handler:function () {
                           /* alert("批量删除");*/
                            var checkHobby = $("#hg").datagrid("getChecked");
                            var ids = "";
                            if(checkHobby==null||checkHobby.length<=0){
                                alert("请选择需要删除的爱好");
                                return;
                            }
                            if(confirm("确定删除这些爱好吗?")){
                                $.each(checkHobby,function (index,item) {
                                    ids = ids + item.id + ",";
                                })
                                $.post("${pageContext.request.contextPath}/hobby/deleteHobbyByIds",{"ids":ids},function (data) {
                                    alert(data.msg);
                                    $("#hg").datagrid("reload");
                                })
                            }
                        }
                    }
                ],
                columns:[[
                    {field:"ck",checkbox:true},
                    {field:"hobbyName",title:"爱好名称",width:100},
                    {field:"createTime",title:"创建时间",width:150,
                        formatter:function (value,row,index) {
                            var date=new Date(value);
                            var y=date.getFullYear();
                            var M=date.getMonth();
                            var d=date.getDate();
                            var h =date.getHours();
                            var m=date.getMinutes();
                            var s=date.getSeconds();
                            return y+"-"+M+"-"+d+"-"+h+"-"+m+"-"+s;

                        }},
                    {field:"id",title:"操作",formatter:function (value,row,index) {
                        var queryButton="<button onclick='queryHobby("+value+")'>详情</button>"
                        var updateButton="<button onclick='updateHobby("+value+")'>修改</button>"
                        var deleteButton="<button onclick='deleteHobby("+value+")'>删除</button>"
                        return queryButton+" "+updateButton+" "+deleteButton;
                    }}
                ]]
            })
            $("#saveAddHobbyButton").click(function () {
                //1取表单数据
                var hobby=$("#addHobbyForm").serialize();
                //2.Ajax请求
                $.post("${pageContext.request.contextPath}/hobby/addHobby",
                    hobby,function (data) {
                        alert(data.msg);
                        $("#addHobbyForm").form("clear");
                        $("#addHobbyWindow").window("close");
                        $("#hg").datagrid("reload");
                    }
                )
            })
            $("#saveUpdateHobby").click(function () {
                var hobby =$("#updateHobbyForm").serialize();
                alert(hobby);
                $.post("${pageContext.request.contextPath}/hobby/updateHobbyById",hobby,function (data) {
                    alert(data.msg);
                    $("#updateHobbyWindow").window("close");
                    $("#hg").datagrid("reload");
                })
            })
        })
        function queryHobby(id) {
            /*alert("详情"+id);*/
            $.get("${pageContext.request.contextPath}/hobby/queryHobbyById",{"id":id},function (data) {
                var date = new Date(data.createTime);
                var y = date.getFullYear();
                var M=date.getMonth()+1;
                var d=date.getDate();
                var h=date.getHours();
                var mm=date.getMinutes();
                var ss=date.getSeconds();
                data.createTime=y+"-"+M+"-"+d+" "+h+":"+mm+":"+ss;
                console.log(data);
                $("#queryHobbyForm").form('load', data);
            })
            $("#queryHobbyWindow").window("open");
        }
        function updateHobby(id) {
            /*alert("修改" + id);*/
            $.get("${pageContext.request.contextPath}/hobby/queryHobbyById",{"id":id},function (data) {
                $("#updateHobbyForm").form('load', data);
            })
            $("#updateHobbyWindow").window("open");

        }

        function deleteHobby(id) {
            if(confirm("确定删除该爱好吗?")){
                $.post("${pageContext.request.contextPath}/hobby/deleteHobby",{"id":id},function (data) {

                    alert(data.msg);
                    $("#hg").datagrid("reload");
                })
            }
        }
        function addHobby() {
            $("#addHobbyWindow").window("open");
        }

    </script>
</head>
<body>
    <table id="hg"></table>
    <div id="addHobbyWindow" class="easyui-window" closed="true"
         style="top: 15%;left: 20%;width: 400px;height: 250px;padding: 30px 80px;" title="添加爱好">
        <form id="addHobbyForm">
            <lable>
                爱好名称:
            </lable>
            <input type="text" name="hobbyName" class="easyui-textbox"/>
        </form>
        <button id="saveAddHobbyButton" class="easyui-linkButton">保存</button>
    </div>
    <div title="爱好详情" id="queryHobbyWindow" class="easyui-window" closed="true" style="top: 20%;left: 20%;width: 350px;height: 250px;padding: 40px 80px;">
        <form id="queryHobbyForm" >
            <div>
                <lable>
                    爱好名称:
                    <input class="easyui-textbox" id="queryHobbyName" name="hobbyName"/>
                </lable>
            </div>
            <div>
                <lable>
                    创建时间:
                    <input class="easyui-textbox" id="queryCreateTime" name="createTime"/>
                </lable>
            </div>
        </form>
    </div>
    <div id="updateHobbyWindow" class="easyui-window" closed="true" title="修改爱好" style="top: 20%;left: 20%;width: 350px;height: 250px;padding: 40px 80px;">
        <form id="updateHobbyForm">
            <div>
                <lable>
                    爱好名称:
                    <input class="easyui-textbox" id="updateHobbyName" name="hobbyName"/>
                    <input type="hidden" name="id"/>
                </lable>
            </div>
        </form>
        <button id="saveUpdateHobby" class="easyui-linkbutton">保存</button>
    </div>
</body>
</html>
