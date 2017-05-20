<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>系统主页</title>
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
    <script type="text/javascript">
        var url;
        function addTab(url, text, iconCls) {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"
                    + url + "'></iframe>";
            $("#tabs").tabs("add", {
                title: text,
                iconCls: iconCls,
                closable: true,
                content: content
            });
        }
        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("close", text);
                addTab(url, text, iconCls);
                $("#tabs").tabs("select", text);
            } else {
                addTab(url, text, iconCls);
            }
        }

        function openPasswordModifyDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "修改密码");
            url = "${pageContext.request.contextPath}/user/modifyPassword.do?id=${currentUser.id}";
        }

        function closePasswordModifyDialog() {
            $("#dlg").dialog("close");
            $("#oldPassword").val("");
            $("#newPassword").val("");
            $("#newPassword2").val("");
        }

        function modifyPassword() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    var newPassword = $("#newPassword").val();
                    var newPassword2 = $("#newPassword2").val();
                    if (!$(this).form("validate")) {
                        return false;
                    }
                    if (newPassword != newPassword2) {
                        $.messager.alert("系统提示", "确认密码输入错误！");
                        return false;
                    }
                    return true;
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "密码修改成功，下一次登录生效！");
                        closePasswordModifyDialog();
                    } else {
                        $.messager.alert("系统提示", "密码修改失败");
                        return;
                    }
                }
            });
        }

        function logout() {
            $.messager
                    .confirm(
                            "系统提示",
                            "您确定要退出系统吗",
                            function (r) {
                                if (r) {
                                    window.location.href = "${pageContext.request.contextPath}/user/logout.do";
                                }
                            });
        }
    </script>
    <jsp:include page="login_chk.jsp"></jsp:include>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #ffff">
    <table width="100%">
        <tr>
            <td width="50%"></td>
            <td valign="bottom"
                style="font-size: 20px;color:#8B8B8B;font-family: '楷体';"
                align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>当前用户：</strong>${currentUser.userName
                    }</font>
            </td>
        </tr>
    </table>
</div>
<!-- 中心的面板 -->
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <!-- <div align="center" style="padding-top: 50px;"><a
                    href="http://download.csdn.net/detail/zhenfengshisan/9765855"
                    target="_blank" style="font-size: 20px;">项目源码下载</a>
            </div>
            <div align="center" style="padding-top: 50px;"><a href="https://github.com/ZHENFENG13/ssm-demo"
                                                              target="_blank"
                                                              style="font-size: 20px;">github地址</a></div>
            <div align="center" style="padding-top: 100px">
                <font color="grey" size="10">ssm demo</font>
            </div> -->
        </div>
    </div>
</div>

<!-- 左侧导航栏 
	暂时先不使用icon，后期加入-->
<div region="west" style="width: 200px;height:500px;" title="导航菜单"
     split="true">
    <div class="easyui-accordion">

       <!--  <div title="书架管理" data-options="iconCls:'icon-shujias'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 书架管理','storeManage.jsp','icon-shujia')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-shujia'"
                    style="width: 150px;"> 书架管理</a>
        </div>
        <div title="书籍管理" data-options="iconCls:'icon-shuji'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 全部书籍','allBooksManage.jsp','icon-shuben')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-shuben'"
                    style="width: 150px;">全部书籍</a>
        </div> -->
        
        <div title="业主管理" data-options="iconCls:'icon-yezhu'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 业主管理','yezhu.jsp','icon-yezhu')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-yezhu'"
                    style="width: 150px;"> 业主管理</a>
        </div>
        <div title="访客管理" data-options="iconCls:'icon-fangke'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 已离开访客','fangkeFinish.jsp','icon-fangke')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-fangke'"
                    style="width: 150px;"> 已离开访客</a>
            <a
                    href="javascript:openTab(' 还未离开访客','fangkeUnfinish.jsp','icon-fangke')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-fangke'"
                    style="width: 150px;"> 还未离开访客</a>
        </div>
        <div title="停车场管理" data-options="iconCls:'icon-tingchechang'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 已租赁停车位','parking.jsp','icon-tingchechang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tingchechang'"
                    style="width: 150px;"> 已租赁停车位管理</a>
                    <a
                    href="javascript:openTab(' 未租赁停车位','unpark.jsp','icon-tingchechang')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tingchechang'"
                    style="width: 150px;"> 未租赁停车位管理</a>
        </div>
       <!--  <div title="收费管理" data-options="iconCls:'icon-shoufei'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 收费管理','storeManage.jsp','icon-shoufei')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-shoufei'"
                    style="width: 150px;"> 收费管理</a>
        </div> -->
        <div title="维修管理" data-options="iconCls:'icon-weixiu'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 已完成维修','weixiuing.jsp','icon-weixiu')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-weixiu'"
                    style="width: 150px;"> 已完成维修</a>
                    <a
                    href="javascript:openTab(' 待完成维修','unweixiu.jsp','icon-weixiu')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-weixiu'"
                    style="width: 150px;"> 待完成维修</a>
        </div>
        <div title="资产管理" data-options="iconCls:'icon-zichan'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 资产管理','storeManage.jsp','icon-zichan')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-zichan'"
                    style="width: 150px;"> 资产管理</a>
        </div>
       <!--  <div title="统计查询" data-options="iconCls:'icon-tongji'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 统计查询','storeManage.jsp','icon-tongji')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tongji'"
                    style="width: 150px;"> 统计查询</a>
        </div> -->
        <div title="用户投诉" data-options="iconCls:'icon-tousu'"
             style="padding:10px">
            <a
                    href="javascript:openTab(' 用户投诉','storeManage.jsp','icon-tousu')"
                    class="easyui-linkbutton"
                    data-options="plain:true,iconCls:'icon-tousu'"
                    style="width: 150px;"> 用户投诉</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item1'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 管理员列表','userManage.jsp','icon-lxr1')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr1'" style="width: 150px;">
                管理员列表</a> <a href="javascript:openPasswordModifyDialog()"
                             class="easyui-linkbutton"
                             data-options="plain:true,iconCls:'icon-modifyPassword1'"
                             style="width: 150px;"> 修改密码</a> <a href="javascript:logout()"
                                                                class="easyui-linkbutton"
                                                                data-options="plain:true,iconCls:'icon-exit1'"
                                                                style="width: 150px;">
            安全退出</a>
        </div>
    </div>
</div>
<div id="dlg" class="easyui-dialog"
     style="width: 400px;height:250px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="userName" name="userName"
                           value="${currentUser.userName }" readonly="readonly"
                           style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>原密码：</td>
                <td><input type="password" id="oldPassword"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" id="newPassword" name="password"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>确认新密码：</td>
                <td><input type="password" id="newPassword2"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:modifyPassword()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a
        href="javascript:closePasswordModifyDialog()"
        class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>