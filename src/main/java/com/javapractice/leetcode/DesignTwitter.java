/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author feng
 * https://leetcode.com/problems/design-twitter/
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able
 * to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids
 * in the user's news feed. Each item in the news feed
 * must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 */
public class DesignTwitter {
	class User {
		int id;
		public User(int id) {
			this.id = id;
		}
	}

	class Tweet {
		int id, priority;
		public Tweet(int id, int priority) {
			this.id = id;
			this.priority = priority;
		}
	}

	public static int id = 0;

	HashMap<Integer, User> user;
	HashMap<Integer, HashSet<User>> follow;
	HashMap<Integer, HashSet<Tweet>> tweet;

	/** Initialize your data structure here. */
	public DesignTwitter() {
		follow = new HashMap<>();
		user = new HashMap<>();
		tweet = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if(!user.containsKey(userId)) {
			user.put(userId, new User(userId));
			follow.put(userId, new HashSet<User>());
			follow.get(userId).add(user.get(userId));
			tweet.put(userId, new HashSet<Tweet>());
		}
		tweet.get(userId).add(new Tweet(tweetId, DesignTwitter.id++));
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed.
	 * Each item in the news feed must be posted by users who the user
	 * followed or by the user herself. Tweets must be ordered
	 * from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> list = new ArrayList<>();
		if(!user.containsKey(userId)) {
			return list;
		}

		List<Tweet> set = new ArrayList<>();
		if(follow.containsKey(userId)) {
			for(User i:follow.get(userId)) {
				set.addAll(tweet.get(i.id));
			}
		}
		Collections.sort(set, new Comparator<Tweet>(){
			public int compare(Tweet a, Tweet b) {
				return b.priority - a.priority;
			}
		});
		for(int i=0; i<10 && i<set.size(); i++) {
			list.add(set.get(i).id);
		}
		return list;
	}

	/** Follower follows a followee.
	 * If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if(!user.containsKey(followerId)) {
			user.put(followerId, new User(followerId));
			follow.put(followerId, new HashSet<User>());
			follow.get(followerId).add(user.get(followerId));
			tweet.put(followerId, new HashSet<Tweet>());
		}
		if(!user.containsKey(followeeId)) {
			user.put(followeeId, new User(followeeId));
			follow.put(followeeId, new HashSet<User>());
			follow.get(followeeId).add(user.get(followeeId));
			tweet.put(followeeId, new HashSet<Tweet>());
		}
		follow.get(followerId).add(user.get(followeeId));
	}

	/** Follower unfollows a followee.
	 * If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if(!user.containsKey(followerId)
			|| !user.containsKey(followeeId)
			|| followerId==followeeId ) {
			return ;
		}
		follow.get(followerId).remove(user.get(followeeId));
	}
}
