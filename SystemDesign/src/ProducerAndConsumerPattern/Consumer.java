package ProducerAndConsumerPattern;

/**
 * Created by Mellon on 9/22/17.
 */
public class Consumer implements Runnable {
    Monitor monitor;
    String name;

    public Consumer(Monitor monitor, String name){
        this.monitor = monitor;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = monitor.take();
                System.out.println("Consuming message --- " + message + "by " + name);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
