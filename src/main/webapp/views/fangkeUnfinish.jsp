<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>pictureManger</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript">
        var url;


        function openStore() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要操作的数据！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确认要执行此操作吗？", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/store/openStore.do", {
                        ids: ids
                    }, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "操作成功！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "操作失败！");
                        }
                    }, "json");
                }
            });

        }
        
        
        //打开隐藏的添加页面
        function openStoreAddDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "添加文本信息");
            url = "${pageContext.request.contextPath}/fangke/addfangke.do";
        }

        //添加或者修改表单后保存
        function saveStore() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "保存成功");
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                        resetValue();
                    } else {
                        $.messager.alert("系统提示", "保存失败");
                        window.location.reload();
                        return;
                    }
                }
            });
        }

        //提交一个修改表单,更改访客状态
        function openCategoryModifyDialog() {
        	var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要修改的数据！");
                return;
            }
            var row = selectedRows[0];                                      	
            $('#fm').form('load', row);
            url = "${pageContext.request.contextPath}/fangke/updatefangke.do?id=" + row.user_id;
            $.messager
            .confirm(
                    "系统提示",
                    "您确定要标记为离开吗",function updateStore() {
                        $("#fm").form("submit", {
                            url: url,
                            onSubmit: function () {
                                return $(this).form("validate");
                            },
                            success: function (result) {
                                var result = eval('(' + result + ')');
                                if (result.success) {
                                    $.messager.alert("系统提示", "修改成功");
                                    //$("#dlg").dialog("close");
                                    $("#dg").datagrid("reload");
                                    resetValue();
                                } else {
                                    $.messager.alert("系统提示", "修改失败");
                                    window.location.reload();
                                    return;
                                }
                            }
                        });
            });

        }
        
        //删除一条信息
        function deleteCategory() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要删除的数据！");
                return;
            }
            var row = selectedRows[0];
            //$("#dlg").dialog("open").dialog("setTitle", "修改信息");
            //$('#fm').form('load', row);
			//$("#dlg").dialog("open").dialog("setTitle", "删除");                                       	
            $('#fm').form('load', row);
            url = "${pageContext.request.contextPath}/fangke/deletefangke.do?id=" + row.user_id;
            $.messager
            .confirm(
                    "系统提示",
                    "您确定要删除吗",function deleteStore() {
                        $("#fm").form("submit", {
                            url: url,
                            onSubmit: function () {
                                return $(this).form("validate");
                            },
                            success: function (result) {
                                var result = eval('(' + result + ')');
                                if (result.success) {
                                    $.messager.alert("系统提示", "删除成功");
                                    //$("#dlg").dialog("close");
                                    $("#dg").datagrid("reload");
                                    resetValue();
                                } else {
                                    $.messager.alert("系统提示", "删除失败");
                                    window.location.reload();
                                    return;
                                }
                            }
                        });
            });

        }

       

        function closeCategoryDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }
    </script>
</head>
<body style="margin:1px;" id="ff">
<table id="dg" title="访客管理" class="easyui-datagrid" pagination="true"
       rownumbers="true" fit="true" data-options="pageSize:20"
       url="${pageContext.request.contextPath}/fangke/unfinish.do" toolbar="#tb">
    <thead data-options="frozen:true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="user_id" width="10%" align="center" hidden="true">编号</th>
        <th field="name" width="100" align="center">姓名</th>
        <th field="xingbie" width="50" align="center">性别</th>
        <th field="visitor" width="200" align="center">访问者</th>
        <th field="begin" width="300" align="center">进入时间</th>
        <th field="end" width="300" align="center">离开时间</th>
        <th field="status" width="50" align="center" hidden="true">是否离开</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openStoreAddDialog()"
           class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a
            href="javascript:openCategoryModifyDialog()"
            class="easyui-linkbutton" iconCls="icon-edit" plain="true">标记为离开</a> 
        <a
            href="javascript:deleteCategory()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>
<div id="dlg" class="easyui-dialog"
     style="width: 600px;height:350px;padding: 10px 20px; position: relative; z-index:1000;"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>姓名：</td>
                <td><input type="text" id="name" name="name"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" id="xingbie" name="xingbie"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
             <tr>
                <td>访问者：</td>
                <td><input type="text" id="visitor" name="visitor"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
        </table>
    </form>
</div>


<div id="dlg-buttons">
    <a href="javascript:saveStore()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:closeCategoryDialog()"
                                   class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>