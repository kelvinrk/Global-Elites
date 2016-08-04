package com.charles.elites.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class Twitter {
    private Map<Integer, Set<Integer>> relation;

    private TreeSet<Feed> feeds;

    /** Initialize your data structure here. */
    public Twitter() {
        relation = new HashMap<>();
        feeds = new TreeSet<>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Feed feed = new Feed(tweetId, userId);
        feeds.add(feed);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        int count = 10;
        Set<Integer> followees = relation.get(userId);
        for(Feed feed : feeds) {
            if(count == 0)
                break;
            if(userId == feed.getUserId()) {
                res.add(feed.getTweetId());
                count--;
            } else if (followees != null && followees.contains(feed.getUserId())){
                res.add(feed.getTweetId());
                count--;
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(relation.containsKey(followerId)) {
            relation.get(followerId).add(followeeId);
        } else {
            Set<Integer> followees = new HashSet<Integer>();
            followees.add(followeeId);
            relation.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(relation.containsKey(followerId)) {
            relation.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 6);
        twitter.getNewsFeed(1).forEach(System.out::println);
    }
}

class Feed implements Comparable<Feed>{
    private int tweetId;
    private int userId;
    private long time;

    @Override
    public int compareTo(Feed that) {
        return (int) (that.time - this.time);
    }

    public Feed(int tweetId, int userId) {
        this.tweetId = tweetId;
        this.userId = userId;
        this.time = System.nanoTime();
    }

    public int getTweetId() {
        return tweetId;
    }

    public int getUserId() {
        return userId;
    }
}
