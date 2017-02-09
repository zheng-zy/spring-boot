<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/themes/icon.css">
<#--<link rel="stylesheet" type="text/css" href="http://www.java1234.com/jquery-easyui-1.3.3/demo/demo.css">-->
    <script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://www.java1234.com/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="http://www.java1234.com/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div style="margin:10px 0;"></div>
<table id="dg" class="easyui-datagrid" title="定制数据表格分页"
       data-options="rownumbers:true,singleSelect:true,pagination:true,method:'get',url:'/user/list'">
    <thead>
    <tr>
    <#--{field: 'id', title: 'id'},-->
    <#--{field: 'login_name', title: 'login_name'},-->
    <#--{field: 'name', title: 'name'},-->
    <#--{field: 'password', title: 'password'},-->
    <#--{field: 'status', title: 'status'},-->
    <#--{field: 'create_time', title: 'create_time'},-->
    <#--{field: 'update_time', title: 'update_time'},-->
    <#--{field: 'memo', title: 'memo'},-->
    <#--{field: 'action', title: 'Action', formatter: operation}-->
        <th data-options="field:'id',width:50,align:'center'">编号</th>
        <th data-options="field:'login_name',width:100,align:'center'">登录名</th>
        <th data-options="field:'name',width:100,align:'center'">用户名</th>
        <th data-options="field:'password',width:100,align:'center'">密码</th>
        <th data-options="field:'status',width:50,align:'center'">状态</th>
        <th data-options="field:'create_time',width:60,align:'center'">创建时间</th>
        <th data-options="field:'update_time',width:60,align:'center'">更新时间</th>
        <th data-options="field:'memo',width:100,align:'center'">备注</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    $(function () {
        var pager = $('#dg').datagrid('getPager');	// get the pager of datagrid
        pager.pagination({
            buttons: [{
                iconCls: 'icon-search',
                handler: function () {
                    alert('搜索');
                }
            }, {
                iconCls: 'icon-add',
                handler: function () {
                    alert('添加');
                }
            }, {
                iconCls: 'icon-edit',
                handler: function () {
                    alert('编辑');
                }
            }]
        });
    })
</script>
</body>
</html>