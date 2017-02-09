<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        var show_dlg;
        $(function () {
            $('#dg').datagrid({
                url: '/user/list',
                method: 'get',
                title: '用户列表',
                iconCls: 'icon-ok',
                fit: true,
                fitColumns: true,
                rownumbers: true,
                pagination: true,
                singleSelect: true,
                border: false,
                striped: true,
                toolbar: [{
                    text: '查看详情',
                    iconCls: 'icon-search',
                    handler: function () {
                        viewDetail();
                    }
                }, '-', {
                    iconCls: 'icon-help',
                    handler: function () {
                        alert('帮助按钮');
                    }
                }],
                columns: [[
                    {field: 'id', title: 'id'},
                    {field: 'login_name', title: 'login_name'},
                    {field: 'name', title: 'name'},
                    {field: 'password', title: 'password'},
                    {field: 'status', title: 'status'},
                    {field: 'create_time', title: 'create_time'},
                    {field: 'update_time', title: 'update_time'},
                    {field: 'memo', title: 'memo'},
                    {field: 'action', title: 'Action', formatter: operation}
                ]]
            });
            show_dlg = $('#dlg').show().dialog({
                title: 'My Dialog',
                width: 400,
                height: 200,
                closed: false,
                cache: false,
                modal: true,
//                onClose:function(){
//                    alert('close');
//                },
//                onOpen: function() {
//                    alert('open');
//                }
            }).dialog('close')

        });

        function operation(value, row, index) {
            var id = row.id;
            var str = '';
            str += '<a href="javascript:void(0)" onclick="grantFun(' + id + ');" >授权</a>';
            str += '|';
            str += '<a href="javascript:void(0)" onclick="editFun(' + id + ');" >编辑</a>';
            str += '|';
            str += '<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" >删除</a>', row.id;
            return str;
            //            return "<a href='" + row.id + "' target='_blank'>Cell Link Name</a>";
        }

        function grantFun(id) {
            show_dlg.dialog('open');
            $('#id').val(id);
            $('#tt').tree({
                checkbox: true,
                url: '/permission/tree'
            });
        }
        function grant() {
            var nodes = $('#tt').tree('getChecked');
            var ids = '';
            for (var i = 0; i < nodes.length; i++) {
                ids += nodes[i].id + ',';
            }
//            $('#ids').val(ids);
            $('#ff').form('submit', {
                url: '/permission/grant',
                onSubmit: function (param) {
//                    param.id = $('#id').val();
                    param.ids = ids;
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        show_dlg.dialog('close');
                        $.messager.show({	// show error message
                            title: 'Success',
                            msg: '授权成功'
                        });
                    } else {
                        $.messager.show({	// show error message
                            title: 'Error',
                            msg: result.msg
                        });
                    }
                }
            });
        }

    </script>
</head>
<body>
<table id="dg"></table>
<div id="dlg" style="display: none;overflow: hidden;" buttons="#dlg-buttons">
    <form id="ff" method="post">
        <input id="id" name="id" class="easyui-validatebox" type="hidden">
    </form>
    <ul id="tt"></ul>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="grant()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:show_dlg.dialog('close')">Cancel</a>
</div>
</body>
</html>