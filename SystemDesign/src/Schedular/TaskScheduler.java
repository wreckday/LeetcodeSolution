package Schedular;

import java.util.concurrent.DelayQueue;

/**
 * Created by Mellon on 9/22/17.
 */
public class TaskScheduler {
    public static void main(String[] args) {
        DelayQueue<Task> queue = new DelayQueue<>();
        new Thread(new TaskProducer(queue), "Producer Thread").start();
        new Thread(new TaskConsumer(queue, "Mark"), "Consumer Thread").start();
        new Thread(new TaskConsumer(queue, "Mellon"), "Consumer Thread").start();
    }
}
