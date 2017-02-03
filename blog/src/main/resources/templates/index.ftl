<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>那年夜下花如雪</title>
    <meta name="author" content="ZhengZy"/>
    <!-- syntax highlighting CSS -->
    <link rel="stylesheet" href="/css/syntax.css" type="text/css"/>
    <!-- Homepage CSS -->
    <link rel="stylesheet" href="/css/screen.css" type="text/css" media="screen, projection"/>
    <!-- Typekit -->
    <script type="text/javascript" src="http://use.typekit.com/jpd0pfm.js"></script>
    <script type="text/javascript">try {
        Typekit.load();
    } catch (e) {
    }</script>
    <script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
</head>
<body>

<!-- ClickTale Top part -->
<script type="text/javascript">
    var WRInitTime = (new Date()).getTime();
</script>
<!-- ClickTale end of Top part -->

<div class="site">
    <div class="title">
        <a href="/">那年夜下花如雪</a>
        <a class="extra" href="/">home</a>
    </div>

    <h1>Blog Posts</h1>
    <ul id="posts" class="posts">
    <#--<li><span>12 Sep 2013</span> &raquo; <a href="http://www.youtube.com/watch?v=k2vJNNAQZlg">Video: Fox Business News interview</a></li>-->
    <#list blogs as blog>
        <li><span>${blog.createTime?date}</span> &raquo; <a href="/blog/${blog.id}">${blog.title}</a></li>
    </#list>
    </ul>

    <h1>Noteworthy Open Source Projects and Specifications</h1>
    <ul class="posts">
        <li><a href="http://github.com/jekyll/jekyll/">Jekyll:</a> A simple, blog aware, static site generator (used for
            this site).
        </li>
        <li><a href="http://semver.org">Semantic Versioning:</a> A meaningful method for incrementing version numbers.
        </li>
        <li><a href="http://github.com/toml-lang/toml">TOML:</a> Tom's Obvious, Minimal Language.</li>
        <li><a href="http://github.com/mojombo/god/">God:</a> Ruby process monitoring framework with easy extensibility.
        </li>
        <li><a href="http://github.com/mojombo/chronic/">Chronic:</a> Ruby natural language date/time parser.</li>
        <li><a href="http://tomdoc.org">TomDoc:</a> Code documentation for humans.</li>
        <li><a href="http://github.com/mojombo/proxymachine/">ProxyMachine:</a> Layer 7 routing proxy in Ruby with Event
            Machine.
        </li>
        <li><a href="http://github.com/github/gollum/">Gollum:</a> A simple, Git-powered wiki with a sweet API and local
            frontend.
        </li>
        <li><a href="http://github.com/mojombo/grit/">Grit:</a> Object oriented Ruby bindings for Git (used by GitHub).
        </li>
        <li><a href="http://github.com/mojombo/ernie/">Ernie:</a> Ruby/Erlang Hybrid BERT-RPC server.</li>
    </ul>

    <div class="footer">
        <div class="contact">
            <p>
                那年夜下花如雪
                <br/>
                Cofounder of
                <a href="https://github.com/">GitHub</a>
                <br/>
                zhezhiyong@163.com
            </p>
        </div>
        <div class="contact">
            <p>
                <br/>
                <a href="http://github.com/zheng-zy/">github.com/zheng-zy</a><br/>
                <!--<a href="http://twitter.com/zheng-zy/">twitter.com/mojombo</a><br/>-->
            </p>
        </div>
        <div class="rss">
            <a href="http://feeds.feedburner.com/tom-preston-werner">
                <img src="/images/rss.png" alt="Subscribe to RSS Feed"/>
            </a>
        </div>
    </div>
</div>

<a href="http://github.com/zheng-zy"><img style="position: absolute; top: 0; right: 0; border: 0;"
                                          src="http://s3.amazonaws.com/github/ribbons/forkme_right_red_aa0000.png"
                                          alt="Fork me on GitHub"/></a>

<!-- ClickTale Bottom part -->
<div id="ClickTaleDiv" style="display: none;"></div>
<script type="text/javascript">
    if (document.location.protocol != 'https:')
        document.write(unescape("%3Cscript%20src='http://s.clicktale.net/WRb.js'%20type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
    if (typeof ClickTale == 'function') ClickTale(206, 0.3, "www03");
</script>
<!-- ClickTale end of Bottom part -->

<!-- Google Analytics -->
<script type="text/javascript">
    var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
    document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
    var pageTracker = _gat._getTracker("UA-6016902-1");
    pageTracker._trackPageview();
</script>
<!-- Google Analytics end -->

</body>
</html>