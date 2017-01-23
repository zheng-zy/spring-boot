package com.crawler.constant;

/**
 * <p>相关常量</p>
 * Created by zhezhiyong@163.com on 2017/1/22.
 */
public class Const {

    // 区分三个处理动作
    public static final String ACTION = "action";
    public static final String ACTION_MAIN = "main";
    public static final String ACTION_BOOK = "book";
    public static final String ACTION_CHAPTER = "chapter";

    // 正则表达式
    public static final String PATTERN_HTML = "";
    public static final String PATTERN_BOOK_URL = ".*\\/[\\d]+_[\\d]*\\/";
    public static final String PATTERN_BOOK_CHAPTER_URL = ".*\\/[\\w]*.html";

    // 网站相关常量
    public static final String URL_CRAWLER = "http://www.biquge.com";
    public static final String URL_SUFFIX = "html";

    // 小说相关常量
    public static final String BOOK_NAME = "book_name";
    public static final String BOOK_CHAPTER = "book_chapter";
    public static final String BOOK_CHAPTER_CONTENT = "book_chapter_content";
    public static final String BOOK_DESCRIPTION = "book_description";
    public static final String BOOK_URL = "book_url";
    public static final String BOOK_STATUS = "book_status";
    public static final String BOOK_UPDATE_TIME = "book_update_time";
    public static final String BOOK_LATEST_CHAPTER_NAME = "book_latest_chapter_name";
    public static final String BOOK_LATEST_CHAPTER_URL = "book_latest_chapter_url";

}
