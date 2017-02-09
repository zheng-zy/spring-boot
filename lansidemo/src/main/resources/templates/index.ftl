<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${request.contextPath}/static/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/static/easyui/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
        });

        function addTab(title, url) {
            if ($('#index-tabs').tabs('exists', title)) {
                $('#index-tabs').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
                $('#index-tabs').tabs('add', {
                    title: title,
                    content: content,
                    closable: true
                });
            }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:50px"></div>
<div data-options="region:'south',split:true" style="height:50px;"></div>
<div data-options="region:'west',split:true" title="导航菜单" style="width:150px;">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <ul class="easyui-tree" data-options="lines:true">
            <li>
                <span>系统配置</span>
                <ul>
                    <li><span><a href="#" onclick="addTab('用户管理','/user')">用户管理</a></span></li>
                    <li><span><a href="#" onclick="addTab('角色管理','role/index.html')">角色管理</a></span></li>
                    <li><span><a href="#" onclick="addTab('权限管理','admin/permission.html')">权限管理</a></span></li>
                </ul>
            </li>
            <li>
                <span>博客管理</span>
                <ul>
                    <li><span><a href="#" onclick="addTab('文章列表','blog/list.html')">博客列表</a></span></li>
                </ul>
            </li>
            <li><span>File 3</span></li>
            <li><span>File21</span></li>
        </ul>
        <!--</div>-->
    </div>
</div>
<div data-options="region:'center',title:'主面板区域',iconCls:'icon-ok'">
    <div id="index-tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
        <div title="首页" data-options="border:false" style="overflow: hidden;">
            <iframe src="${request.contextPath}/page/portal" frameborder="0"
                    style="border: 0; width: 100%; height: 100%;"></iframe>
        </div>

    </div>
</div>
</body>
</html>