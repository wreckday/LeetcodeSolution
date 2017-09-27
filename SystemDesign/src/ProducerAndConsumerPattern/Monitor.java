package ProducerAndConsumerPattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mellon on 9/22/17.
 */
public class Monitor {
    private final static int bufferSize = 10;
    private final transient ReentrantLock lock = new ReentrantLock();
    private final BlockingQueue<String> q = new LinkedBlockingDeque<>(bufferSize);
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    private int count = 0;

    public void append(String message) throws InterruptedException {
        lock.lock();

        while (count == bufferSize) notFull.await();

        q.offer(message);

        count++;
        notEmpty.signal();
        lock.unlock();
    }

    public String take() throws InterruptedException {
        lock.lock();

        while (count == 0) notEmpty.await();

        String message = q.poll();

        count--;

        notFull.signal();
        lock.unlock();

        return message;
    }

}
