package com.crawler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static com.crawler.constant.Const.*;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/1/22.
 */
public class CustomPipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomPipeline(String path) {
        this.setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }

        String action = resultItems.get(ACTION);
        if (ACTION_MAIN.equals(action)) return;
        String bookName = resultItems.get(BOOK_NAME);
        if (action.equals(ACTION_BOOK)) {
            String path = this.path + PATH_SEPERATOR + "book" + PATH_SEPERATOR;
            save(resultItems, path + bookName);
        } else if (action.equals(ACTION_CHAPTER)) {
            String path = this.path + PATH_SEPERATOR + bookName + PATH_SEPERATOR;
            String chapter = resultItems.get(BOOK_CHAPTER);
            save(resultItems, path + chapter);
        }
    }

    private void save(ResultItems resultItems, String path) {
        try {
            PrintWriter e = new PrintWriter(new FileWriter(this.getFile(path + ".json")));
            e.write(JSON.toJSONString(resultItems.getAll()));
            e.close();
        } catch (IOException var5) {
            this.logger.warn("write file result", var5);
        }
    }
}
