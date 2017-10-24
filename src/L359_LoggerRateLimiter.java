import java.util.*;

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
    private Map<String, Integer> ok = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
    }
}

class Log {
    int timestamp;
    String message;
    public Log(int aTimestamp, String aMessage) {
        timestamp = aTimestamp;
        message = aMessage;
    }
}

class Logger2 {
    Queue<Log> recentLogs;
    Set<String> recentMessages;

    /** Initialize your data structure here. */
    public Logger2() {
        recentLogs = new LinkedList<>();
        recentMessages = new HashSet<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (recentLogs.size() > 0 && recentLogs.peek().timestamp-timestamp>=10)   {
            Log log = recentLogs.peek();
            // discard the logs older than 10 minutes
            recentLogs.poll();
            recentMessages.remove(log.message);
        }
        if(!recentMessages.contains(message)){
            recentLogs.add(new Log(timestamp, message));
            recentMessages.add(message);
            return true;
        }

        return false;
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */