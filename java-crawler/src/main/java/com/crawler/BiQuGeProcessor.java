package com.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * <p>线上日志定时下载</p>
 * Created by zhezhiyong@163.com on 2017/1/22.
 */
public class BiQuGeProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());


    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        String bookName = page.getHtml().xpath("//div[@class='con_top']/a/text()").all().get(1);
        String chapter = page.getHtml().xpath("//div[@class='bookname']/h1/text()").toString();
        String content = page.getHtml().xpath("//div[@id='content']/text()").toString();
//        List<String> links = page.getUrl().css("div.bottem1").links().regex("^[0-9]*.html").all();
        List<String> links = page.getHtml().css("div.bottem1").links().regex(".*\\/[\\w]*.html").all();
        page.putField("bookName", bookName);
        page.putField("chapter", chapter);
        page.putField("content", content);
        page.putField("links", links);
        if (page.getResultItems().get("chapter") == null) {
            //skip this page
            page.setSkip(true);
        }

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(links);

        logger.info("chapter: {}, links: {}", chapter, links);
    }

    @Override
    public Site getSite() {
        return site;
    }

//    public static void main(String[] args) {
//
//        Spider.create(new BiQuGeProcessor())
//                //从"https://github.com/code4craft"开始抓
//                .addUrl("http://www.biquge.com/43_43821/2520338.html")
////                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
//                .addPipeline(new CustomPipeline("D:\\webmagic\\"))
//                //开启5个线程抓取
//                .thread(8)
//                //启动爬虫
//                .run();
//    }
}
