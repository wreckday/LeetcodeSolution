import java.util.*;

/**
 *
 Design a simplified version of Twitter where users can post tweets,
 follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 Your design should support the following methods:

 1.postTweet(userId, tweetId): Compose a new tweet.
 2.getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
    Each item in the news feed must be posted by users who the user followed or by the user herself.
    Tweets must be ordered from most recent to least recent.
 3.follow(followerId, followeeId): Follower follows a followee.
 4.unfollow(followerId, followeeId): Follower unfollows a followee.

 * Created by Mellon on 6/14/16.
 */
public class DesignTwitter {
    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);

        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);

        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);


        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);

        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);

        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);

        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
class Tweet{
     int tweetId;
     int timeStamp;
    public Tweet(int tweetId, int timeStamp ){
        this.tweetId = tweetId;
        this.timeStamp = timeStamp;
    }
}

class Twitter{
    private int time=0;

    private HashMap<Integer, HashSet<Tweet>> posts = new HashMap<>();
    private HashMap<Integer, HashSet<Integer>> friends = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time);
        if(posts.containsKey(userId)){
            posts.get(userId).add(tweet);
        }else{
            HashSet<Tweet> set = new HashSet<>();
            set.add(tweet);
            posts.put(userId, set);
        }
        time = time+1;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.timeStamp-o1.timeStamp;
            }
        });

        // add friends' tweet to pq
        if(friends.get(userId)!=null){
            for(Integer f: friends.get(userId)){
                if(posts.get(f)!=null){
                    pq.addAll(posts.get(f));
                }
            }
        }

        // add user's tweet to pq
        if(posts.get(userId)!=null){
            pq.addAll(posts.get(userId));
        }

        List<Integer> newsFeeds = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            if(pq.size()>0){
                newsFeeds.add(pq.poll().tweetId);
            }
        }
        return newsFeeds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        if(!friends.containsKey(followerId)){
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            friends.put(followerId, set);
        }else{
            friends.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId==followerId) return;
        if(!friends.containsKey(followerId)) return;
        if(friends.containsKey(followerId)){
            if(friends.get(followerId).contains(followeeId)){
                friends.get(followerId).remove(followeeId);
            }
        }
    }
}
