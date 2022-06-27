package leetcode.graphs;

import java.util.concurrent.*;

public class MT  implements Runnable {


    @Override
    public void run() {
        System.out.println("Test");
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread("test");
            }
        };
        Executor executor = Executors.newCachedThreadPool(threadFactory);
        CompletableFuture<Void> run = CompletableFuture.runAsync(() -> new MT().run(), executor);
    }
}
