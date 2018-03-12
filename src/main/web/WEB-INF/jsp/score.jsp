<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4/004
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#scoreDataGrid").datagrid({
                url: "${pageContext.request.contextPath}/score/queryScore",
                method: "GET",

                rownumbers: true,
                striped: true,
                pagination: true,
                checkOnSelect: false,
                toolbar: [{
                    text: "添加",
                    iconCls: 'icon-add',
                    handler: function () {

                        $.get("${pageContext.request.contextPath}/student/queryAllGrade",
                            function (grade) {
                                $("#addScoreGradeNameCombobox").combobox({
                                    valueField:'id',
                                    textField:'gradeName',
                                    data:grade,
                                    editable:false,
                                    onSelect:function (gradeItem) {
                                        //学生combobox选项加载
                                        $.get("${pageContext.request.contextPath}/student/queryStudentByGradeId",
                                            {"gradeId":gradeItem.id},function (student) {
                                                $("#addScoreStudentNameCombobox").combobox({
                                                    valueField:'id',
                                                    textField:'studentName',
                                                    data:student,
                                                    editable:false
                                                });
                                            });
                                    }
                                });
                            });
                        $.get("${pageContext.request.contextPath}/score/queryCourse",function (course) {
                            $("#addScoreCourseCombobox").combobox({
                                valueField:'id',
                                textField:'courseName',
                                data:course,
                                editable:false
                            })
                        })
                        $("#addScoreWindow").window("open");

                    }
                }, {
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function () {
                        alert("删除");
                    }
                }],
                columns: [[
                    {field: 'ck', checkbox: true},
                    {
                        field: 'grade', title: "班级", width: 200, formatter: function (value, row, index) {
                        return row.student.grade.gradeName;
                    }
                    },
                    {
                        field: 'student', title: '名字', width: 200, formatter: function (value, row, index) {
                        return row.student.studentName;
                    }
                    },
                    {
                        field: 'course', title: '课程', width: 200, formatter: function (value, row, index) {
                        return row.course.courseName;
                    }
                    },
                    {field: 'score', title: '成绩', width: 200},
                    {
                        field: 'id', title: '操作', width: 200, formatter: function (value, row, index) {
                        var queryScore = "<button onclick='queryScore(" + value + ")'>详情</button>";
                        var updateScore = "<button onclick='updateScore(" + value + ")'>修改</button>";
                        var deleteScore = "<button onclick='deleteScore(" + value + ")'>删除</button>";
                        return queryScore + " " + updateScore + " " + deleteScore;
                    }
                    }
                ]]
            });
            $.get("${pageContext.request.contextPath}/grade/queryAll", function (gradeData) {
                var grade1 = $.parseJSON('{"id":-1,"gradeName":"---请选择---"}');
                gradeData.push(grade1);
                $("#gradeCombobox").combobox({
                    valueField: "id",
                    textField: "gradeName",
                    editable: false,
                    data: gradeData,
                    onLoadSuccess: function () {
                        $(this).combobox('select', -1);
                    },
                    onSelect:function (grade) {
                        $.get("${pageContext.request.contextPath}/student/queryStudentByGradeId",
                            {"gradeId":grade.id},function (student) {
                                var student1=$.parseJSON('{"id":-1,"studentName":"--请选择--"}');
                                student.push(student1);
                                $("#studentCombobox").combobox({
                                    valueField:'id',
                                    textField:'studentName',
                                    editable:false,
                                    data:student,
                                    onLoadSuccess:function () {
                                        $(this).combobox('select',-1);
                                    }
                                })
                            })
                        }
                    });

                    $("#queryScoreButton").click(function () {
                        var gradeId = $("#gradeCombobox").combobox('getValue');
                        var studentId = $("#studentCombobox").combobox('getValue');

                        $("#scoreDataGrid").datagrid('load', {
                            "gradeId": gradeId,
                            "studentId": studentId
                        })
                    })
                })
            $("#saveAddScoreButton").click(function () {
                var score =$("#addScoreForm").serialize();
                $.post("${pageContext.request.contextPath}/score/addScore",score, function (data) {
                    alert(data.msg);
                    $("#addScoreForm").form("clear");
                    $("#addScoreWindow").window("close");
                    $("#scoreDataGrid").datagrid("reload");
                })
            })
        });
        function queryScore(id) {
            /*alert("详情" + id);*/
            $.get("${pageContext.request.contextPath}/score/queryScoreById",{"id":id},function (data) {
                $("#queryGradeName").textbox('setValue', data.student.grade.gradeName);
                $("#queryStudentName").textbox('setValue', data.student.studentName);
                $("#queryCourseName").textbox('setValue', data.course.courseName);
                $("#queryScore").textbox('setValue', data.score);
            });
            $("#queryScoreByIdWindow").window("open");
        }
        function updateScore(id) {
            /*alert("修改" + id);*/

                $.get("${pageContext.request.contextPath}/score/queryScoreById",{"id":id},function (data) {
                    alert(data.student.studentName);
                    $("#updateScoreGradeNameCombobox").textbox('setValue', data.student.grade.gradeName);
                    $("#updateScoreStudentNameCombobox").textbox('setValue', data.student.studentName);

                    $("#updateCourseCombobox").textbox('setValue', data.course.courseName);
                    $("#updateScoreCombobox").textbox('setValue', data.score);
                    $("#updateScoreId").val(data.id);
                });
                $("#updateScoreWindow").window("open");
        }
        function deleteScore(id) {
           /* alert("删除" + id);*/
           if(confirm("确定删除该成绩吗?")){

               $.post("${pageContext.request.contextPath}/score/deleteScoreById",{"id":id},function (data) {
                   alert(data.msg);
                   $("#scoreDataGrid").datagrid('reload');
               })
           }
        }
    </script>
</head>
<body>
<table id="scoreDataGrid" class="easyui-datagrid"></table>
<div>
    <form id="queryScoreForm">
        班级:<input id="gradeCombobox" name="gradeName">
        学生:<input id="studentCombobox" name="studentName"/>
        <a href="#" id="queryScoreButton" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </form>
</div>
<div id="queryScoreByIdWindow" class="easyui-window" title="成绩详情" style="top: 10%;left: 20%;width: 400px;height: 350px;padding: 40px 80px;"
     closed="true">
    <form id="queryScoreByIdForm">
        <div>
            班级:<input id="queryGradeName" class="easyui-textbox"/>
        </div>
        <div>
            学生:<input id="queryStudentName" class="easyui-textbox"/>
        </div>
        <div>
            课程:<input id="queryCourseName" class="easyui-textbox"/>
        </div>
        <div>
            成绩:<input id="queryScore" class="easyui-textbox"/>
        </div>
    </form>
</div>
<!----添加成绩--->
<div class="easyui-window" id="addScoreWindow" title="添加成绩" style="top: 10%;left: 20%;width: 400px;height: 350px;padding: 40px 80px;"
     closed="true">
    <form id="addScoreForm">
        <div>
            班级:<input class="easyui-textbox" id="addScoreGradeNameCombobox" name="student.grade.id"/>
        </div>
        <div>
            学生:<input id="addScoreStudentNameCombobox" name="student.id"/>
        </div>
        <div>
            课程:<input id="addScoreCourseCombobox" name="course.id"/>
        </div>
        <div>
            成绩:<input id="addScore" name="score" class="easyui-numberbox"/>
        </div>
    </form>
    <button id="saveAddScoreButton" class="easyui-linkbutton" iconCls="icon-save">保存</button>
</div>
<!--修改成绩-->
<div closed="true" id="updateScoreWindow" class="easyui-window" style="top: 10%;left: 20%;width: 400px;height: 350px;padding: 40px 80px;" title="修改成绩">
    <form id="updateScoreForm">
        <div>
            班级:<input id="updateScoreGradeNameCombobox" class="easyui-textbox" readonly name="student.grade.id"/>
            <input type="hidden" id="updateScoreId" name="id"/>
        </div>
        <div>
            学生:<input id="updateScoreStudentNameCombobox" readonly name="student.id"/>
        </div>
        <div>
            课程:<input id="updateCourseCombobox" name="course.id" readonly/>
        </div>
        <div>
            成绩:<input id="updateScoreCombobox" class="easyui-numberbox" name="score"/>
        </div>
    </form>
    <button id="saveUpdateScoreButton" class="easyui-linkbutton" iconCls="icon-save">保存</button>
</div>
</body>
</html>
