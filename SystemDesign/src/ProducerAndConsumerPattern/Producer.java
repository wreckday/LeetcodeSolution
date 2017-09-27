package ProducerAndConsumerPattern;

import java.util.UUID;

/**
 * Created by Mellon on 9/22/17.
 */
public class Producer implements Runnable {
    Monitor monitor;

    public Producer(Monitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true){
            String message = "Message ID : " + UUID.randomUUID();
            try {
                monitor.append(message);
                System.out.println("Producing message --- " + message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
