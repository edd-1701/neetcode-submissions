public class User {
    int id;
    List<Tweet> tweets;
    Set<Integer> following;

    public User(int id) {
        this.id = id;
        tweets = new ArrayList<Tweet>();
        following = new HashSet<Integer>();
    }
}

public record Tweet(int internalId, int publicId){};

class Twitter {
    private Map<Integer, User> users;
    private int tweetIdCounter;

    public Twitter() {
        users = new HashMap<>();
        tweetIdCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        final var user = users.computeIfAbsent(userId, key -> new User(key));
        user.tweets.add(new Tweet(++tweetIdCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // System.out.println("GetNewsFeed for " + userId);

        final var userObj = users.get(userId);

        final var feed = new ArrayList<Tweet>();
        for (var user : users.values()) {
            // System.out.println("\t looping over current user " + user.id + " tweets: " + user.tweets);
            if (user.id != userObj.id && !userObj.following.contains(user.id)) {
                continue;
            }
            feed.addAll(user.tweets);
        }

        return feed
            .stream()
            .sorted((a,b) -> Integer.compare(b.internalId, a.internalId))
            .map(tweet -> tweet.publicId)
            .limit(10)
            .toList();

        // System.out.println("result: " + feed);

        // return feed.size() <= 10 ? feed : feed.subList(0, 10);

    }
    
    public void follow(int followerId, int followeeId) {
        final User follower = users.computeIfAbsent(followerId, key -> new User(key));
        follower.following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        final User follower = users.computeIfAbsent(followerId, key -> new User(key));
        follower.following.remove(followeeId);
    }
}
