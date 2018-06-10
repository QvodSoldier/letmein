//package com.neo;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Configuration
//@Slf4j
//public class ScheduledTask {
//	
//	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    private int fixedDelayCount = 1;
//    private int fixedRateCount = 1;
//    private int initialDelayCount = 1;
//    private int cronCount = 1;
//
////    @Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
//    public void testFixDelay() {
//    }
//
//    
////    @Scheduled(fixedRate=5000)
////    public void doSomething() {
////        // 一些需要定期执行的代码
////    }
//    
//    @Scheduled(fixedRate = 5000)        //fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
//    public void testFixedRate() {
//    	System.out.println("dingshi renwu"+ System.currentTimeMillis());
//    }
//
////    @Scheduled(initialDelay = 1000, fixedRate = 5000)   //initialDelay = 1000表示延迟1000ms执行第一次任务
////    public void testInitialDelay() {
////    }
//
//    
////    Cron表达式参数分别表示：
////    秒（0~59） 例如0/5表示每5秒   @Scheduled(cron = "0/5 * * * * ?")
////    分（0~59）
////    时（0~23）
////    月的某天（0~31） 需计算
////    月（0~11）
////    @Scheduled(cron = "0/5 * * * * ?")  //cron接受cron表达式，根据cron表达式确定定时规则
////    public void testCron() {
////        logger.info("===testCron: 第{}次执行方法", cronCount++);
////        System.out.println("testCrontestCron");
////    }
//    
////    @Scheduled(cron="5 * * * * ?")
////    public void cronScheduled() {
////        log.info("cron : The time is now {}", dateFormat.format(new Date()));
////    }
//    
////    /**
////     * 每隔5秒执行一次
////     */
////    @Scheduled(fixedRate = 5000)
////    public void reportCurrentTime() {
////    	System.out.println("12344444");
////        log.info("The time is now {}", dateFormat.format(new Date()));
////    }
//    
//}
