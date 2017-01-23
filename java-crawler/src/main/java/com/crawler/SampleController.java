package com.crawler;

//@Controller
//@SpringBootApplication
//public class SampleController {
//
//    private AtomicInteger num = new AtomicInteger(0);
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Resource
//    private HelloWorldService helloWorldService;
//
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }
//
//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        logger.info("times: {}", num.getAndIncrement());
//        return helloWorldService.getHelloMessage() + num.getAndIncrement();
//    }
//}