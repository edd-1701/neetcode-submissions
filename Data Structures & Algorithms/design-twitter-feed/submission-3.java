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
        final var userObj = users.get(userId);

        return users
            .values()
            .stream()
            .filter(u -> u.id == userId || userObj.following.contains(u.id))
            .map(u -> u.tweets)
            .flatMap(List::stream)
            .sorted((a,b) -> Integer.compare(b.internalId, a.internalId))
            .map(t -> t.publicId)
            .limit(10)
            .toList();
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
