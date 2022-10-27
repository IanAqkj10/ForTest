package xianchen;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description:
 * @author:ljh
 * @date:2022/8/4 21:45
 */

public class CallableDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws Exception {

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("test" + "-%d")
                .setDaemon(true).build();

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
        int i = executor.prestartAllCoreThreads();
        System.out.println(i);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "测试使用";
        }, executor);

        executor.shutdown();
    }
}