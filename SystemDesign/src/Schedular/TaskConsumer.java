package Schedular;

import java.util.concurrent.DelayQueue;

public class TaskConsumer implements Runnable {
    private DelayQueue<Task> q;
    private String name;

    public TaskConsumer(DelayQueue<Task> q, String name) {
        this.q = q;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = q.take();
                System.out.println("Take " + task + "by Consumer - " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
