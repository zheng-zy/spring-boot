package com.crawler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

import static com.crawler.constant.Const.*;


/**
 * <p>线上日志定时下载</p>
 * Created by zhezhiyong@163.com on 2017/1/22.
 */
public class BiQuGeAllProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

//    public static void main(String[] args) throws JMException {
//
//        Spider spider = Spider.create(new BiQuGeAllProcessor())
//                //从"https://github.com/code4craft"开始抓
//                .addUrl(URL_CRAWLER)
////                .addUrl("http://www.biquge.com/21_21470/")
////                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
//                .addPipeline(new CustomPipeline("D:\\webmagic\\"))
//                //开启5个线程抓取
//                .thread(5);
//                //启动爬虫
////                .run();
//        SpiderMonitor.instance().register(spider);
//        spider.run();
//    }

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        List<String> links = new ArrayList<String>();
        String url = page.getUrl().toString();

        if (URL_CRAWLER.equals(url)) {
            // 处理主页,获取小说url地址
            page.putField(ACTION, ACTION_MAIN);
            links.addAll(page.getHtml().links().regex(PATTERN_BOOK_URL).all());
        } else if (url.contains(URL_SUFFIX)) {
            // 处理章节详情页
            page.putField(ACTION, ACTION_CHAPTER);
            String bookName = page.getHtml().xpath("//div[@class='con_top']/a/text()").all().get(1);
            String chapter = page.getHtml().xpath("//div[@class='bookname']/h1/text()").toString();
            String content = page.getHtml().xpath("//div[@id='content']/text()").toString();
            page.putField(BOOK_NAME, bookName);
            page.putField(BOOK_CHAPTER, chapter);
            page.putField(BOOK_CHAPTER_CONTENT, content.replaceAll("\u00A0", ""));
            if (page.getResultItems().get(BOOK_CHAPTER) == null) {
                page.setSkip(true);
            }
        } else {
            // 处理小说主页,获取主要信息,并把章节页添到爬虫
//            List<String> info = page.getHtml().xpath("//meta[@property='og:title']/@content").all();
            page.putField(ACTION, ACTION_BOOK);
            List<String> info = page.getHtml().xpath("//meta/@content").all();
            String bookName = info.get(10);
            String description = info.get(6);
            String read_url = info.get(11);
            String status = info.get(13);
            String update_time = info.get(14);
            String latest_chapter_name = info.get(15);
            String latest_chapter_url = info.get(16);
            page.putField(BOOK_NAME, bookName);
            page.putField(BOOK_DESCRIPTION, description);
            page.putField(BOOK_URL, read_url);
            page.putField(BOOK_STATUS, status);
            page.putField(BOOK_UPDATE_TIME, update_time);
            page.putField(BOOK_LATEST_CHAPTER_NAME, latest_chapter_name);
            page.putField(BOOK_LATEST_CHAPTER_URL, latest_chapter_url);

            List<String> chapterUrls = page.getHtml().links().regex(PATTERN_BOOK_CHAPTER_URL).all();
            links.addAll(chapterUrls);

        }


        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(links);

        logger.info("action: {}, json: {}", page.getResultItems().get(ACTION), JSON.toJSONString(page.getResultItems()));
    }

    @Override
    public Site getSite() {
        return site;
    }
}
