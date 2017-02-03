import java.util.HashMap;

/**
 *
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity),
 return true if the message should be printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.
 *
 * Created by Mellon on 6/19/16.
 */
public class L359_LoggerRateLimiter {
    public static void main(String[] args){
        Logger logger = new Logger();

        System.out.println(logger.shouldPrintMessage(1, "foo"));

        System.out.println(logger.shouldPrintMessage(2, "bar"));

        System.out.println(logger.shouldPrintMessage(3, "foo"));

        System.out.println(logger.shouldPrintMessage(8, "bar"));

        System.out.println(logger.shouldPrintMessage(10, "foo"));

        System.out.println(logger.shouldPrintMessage(11, "foo"));

    }

}

class Logger {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) && timestamp-map.get(message)<10){
            return false;

        }else{
            map.put(message, timestamp);

        }
        return true;
    }
}