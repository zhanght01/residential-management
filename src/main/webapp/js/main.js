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