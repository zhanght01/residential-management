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
            $("#dlg").dialog("open").dialog("setTitle", "添加维修信息");
            url = "${pageContext.request.contextPath}/park/addpark.do";
        }

        //添加或者修改表单后保存
        function saveStore() {
        	url = "${pageContext.request.contextPath}/tousu/addtousu.do";
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "保存成功");
                       /*  $("#dlg").dialog("close");
                        $("#dg").datagrid("reload"); */
                        $("#fm")[0].reset();
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
            url = "${pageContext.request.contextPath}/weixiu/updateweixiu.do?id=" + row.id;
            $.messager
            .confirm(
                    "系统提示",
                    "您确定要标记为维修完成吗",function updateStore() {
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
            $('#fm').form('load', row);
            url = "${pageContext.request.contextPath}/weixiu/deleteweixiu.do?id=" + row.id;
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
<form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>姓名：</td>
                <td><input type="text" id="yezhuname" name="yezhuname"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>投诉内容：</td>
                <td><input type="text" id="neirong" name="neirong"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
             <tr>
                <td>联系电话：</td>
                <td><input type="text" id="phone" name="phone"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
               
                <td><input type="hidden" id="status" name="status"
                           class="easyui-validatebox"/>&nbsp;<font
                        color="red"></font>
                </td>
            </tr>
        </table>
    </form>
<%-- <table id="dg" title="维修管理" class="easyui-datagrid" pagination="true"
       rownumbers="true" fit="true" data-options="pageSize:20"
       url="${pageContext.request.contextPath}/weixiu/unweixiu.do" toolbar="#tb">
    <thead data-options="frozen:true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="10%" align="center" hidden="true">编号</th>
        <th field="yezhuname" width="200" align="center">报修业主</th>
        <th field="baoxiuneirong" width="500" align="center">保修内容</th>
        <th field="phone" width="300" align="center">联系电话</th>
        <th field="status" width="50" align="center" hidden="true">状态</th>
    </tr>
    </thead>
</table> --%>
<!-- <div id="tb">
    <div>
        <a href="javascript:openStoreAddDialog()"
           class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a
            href="javascript:openCategoryModifyDialog()"
            class="easyui-linkbutton" iconCls="icon-edit" plain="true">标记为维修完成</a> 
        <a
            href="javascript:deleteCategory()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
</div> -->
<!-- <div id="dlg" class="easyui-dialog"
     style="width: 600px;height:350px;padding: 10px 20px; position: relative; z-index:1000;"
     close="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>业主：</td>
                <td><input type="text" id="yezhuname" name="yezhuname"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>保修内容：</td>
                <td><input type="text" id="baoxiuneirong" name="baoxiuneirong"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
             <tr>
                <td>联系电话：</td>
                <td><input type="text" id="phone" name="phone"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font>
                </td>
            </tr>
            <tr>
               
                <td><input type="hidden" id="status" name="status"
                           class="easyui-validatebox"/>&nbsp;<font
                        color="red"></font>
                </td>
            </tr>
        </table>
    </form>
</div> -->


<div id="dlg-buttons">
    <a href="javascript:saveStore()" class="easyui-linkbutton"
       iconCls="icon-ok">提交投诉</a>  <%-- <td width=100 align=middle><input
                                                style="border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px"
                                                id=btnReset src="${pageContext.request.contextPath}/images/btn2.jpg"
                                                type=image name=btnReset
                                                onclick="javascript:fm.reset();return false;"></td> --%>
</div>
</body>
</html>