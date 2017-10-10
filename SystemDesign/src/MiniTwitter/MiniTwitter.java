package MiniTwitter;

import java.util.*;

/**

 实现一个迷你的推特，支持下列几种方法
 1.postTweet(user_id, tweet_text). 发布一条推特.
 2.getTimeline(user_id). 获得给定用户最新发布的十条推特，按照发布时间从最近的到之前排序
 3.getNewsFeed(user_id). 获得给定用户的朋友或者他自己发布的最新十条推特，从发布时间最近到之前排序
 4.follow(from_user_id, to_user_id). from_user_id 关注 to_user_id.
 5.unfollow(from_user_id, to_user_id). from_user_id 取消关注 to_user_id.

 *
 * Created by Mellon on 10/7/17.
 */
public class MiniTwitter {
    class Tweet{
        int user_id;
        String tweet_text;

        public Tweet(int user_id, String tweet_text){

        }

    }

    class Node {
        public int order;
        public Tweet tweet;
        public Node(int o, Tweet t) {
            this.order = o;
            this.tweet = t;
        }
    }

    class SortByOrder implements Comparator {
        public int compare(Object obj1,Object obj2) {
            Node node1 = (Node) obj1;
            Node node2 = (Node) obj2;
            if (node1.order < node2.order)
                return 1;
            else
                return -1;
        }
    }

    private Map<Integer, Set<Integer>> friends;
    private Map<Integer, List<Node>> users_tweets;
    private int order;

    public List<Node> getLastTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < 10)
            last = tmp.size();
        return tmp.subList(tmp.size() - last, tmp.size());
    }

    public List<Node> getFirstTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < 10)
            last = tmp.size();
        return tmp.subList(0, last);
    }

    public MiniTwitter() {
        // initialize your data structure here.
        this.friends = new HashMap<Integer, Set<Integer>>();
        this.users_tweets = new HashMap<Integer, List<Node>>();
        this.order = 0;
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet = new Tweet(user_id, tweet_text);
        if (!users_tweets.containsKey(user_id))
            users_tweets.put(user_id, new ArrayList<Node>());
        order += 1;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<Node>();
        if (users_tweets.containsKey(user_id))
            tmp.addAll(getLastTen(users_tweets.get(user_id)));

        if (friends.containsKey(user_id)) {
            for (Integer user : friends.get(user_id)) {
                if (users_tweets.containsKey(user))
                    tmp.addAll(getLastTen(users_tweets.get(user)));
            }
        }

        Collections.sort(tmp, new SortByOrder());
        List<Tweet> rt = new ArrayList<>();
        tmp = getFirstTen(tmp);
        for (Node node : tmp) {
            rt.add(node.tweet);
        }
        return rt;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> tmp = new ArrayList<>();
        if (users_tweets.containsKey(user_id))
            tmp.addAll(getLastTen(users_tweets.get(user_id)));

        Collections.sort(tmp, new SortByOrder());
        List<Tweet> rt = new ArrayList<>();
        tmp = getFirstTen(tmp);
        for (Node node : tmp)
            rt.add(node.tweet);
        return rt;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friends.containsKey(from_user_id))
            friends.put(from_user_id, new HashSet<Integer>());

        friends.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friends.containsKey(from_user_id))
            friends.get(from_user_id).remove(to_user_id);
    }
}
