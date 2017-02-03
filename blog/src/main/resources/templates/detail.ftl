<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${blog.title}</title>
    <link rel="stylesheet" href="/editor/style.css"/>
    <link rel="stylesheet" href="/editor/editormd.preview.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
    <style>
        .editormd-html-preview {
            width: 70%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div id="layout">
    <header>
        <h1>${blog.title}</h1>
        <p>即：非编辑情况下的HTML预览</p>
        <p>HTML Preview(markdown to html)</p>
    </header>
    <div class="btns">
        <button id="go_back">返回</button>
        <button id="go_home">主页</button>
    </div>
<#--<div id="title">-->
<#--<h1>${blog.title}</h1>-->
<#--</div>-->
    <div id="test-editormd-view2">
        <textarea id="append-test" style="display:none;">${blog.content}</textarea>
    </div>
</div>
<!-- <script src="js/zepto.min.js"></script>
<script>
    var jQuery = Zepto;  // 为了避免修改flowChart.js和sequence-diagram.js的源码，所以使用Zepto.js时想支持flowChart/sequenceDiagram就得加上这一句
</script> -->
<script src="/js/jquery.min.js"></script>
<script src="../lib/marked.min.js"></script>
<script src="../lib/prettify.min.js"></script>

<script src="../lib/raphael.min.js"></script>
<script src="../lib/underscore.min.js"></script>
<script src="../lib/sequence-diagram.min.js"></script>
<script src="../lib/flowchart.min.js"></script>
<script src="../lib/jquery.flowchart.min.js"></script>

<script src="/editor/editormd.js"></script>
<script type="text/javascript">
    $(function () {
        editormd.markdownToHTML("test-editormd-view2", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
//            tocContainer    : "#custom-toc-container" // 自定义 ToC 容器层
//            tocm: true
        });
        $("#go_back").bind('click', function () {
            history.go(-1);
        });
        $("#go_home").bind('click', function () {
            location.href = '/'
        });
    });

</script>
</body>
</html>