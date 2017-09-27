package ProducerAndConsumerPattern;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Mellon on 9/22/17.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Monitor monitor = new Monitor();
        executor.execute(new Producer(monitor));
        executor.execute(new Consumer(monitor, "A"));
        executor.execute(new Consumer(monitor, "B"));

    }
}
