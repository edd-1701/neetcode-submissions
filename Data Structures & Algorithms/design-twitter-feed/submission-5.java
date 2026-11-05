/*

    Create a follower map UserId -> Set<Integer> following

    Create a list of tweets 

*/

class Twitter {

    final List<int[]> tweets = new ArrayList<>();
    final Map<Integer, Set<Integer>> following = new HashMap<>();

    public Twitter() {

    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.addFirst(new int[]{tweetId, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        final var result = new ArrayList<Integer>();
        final var follows = following.get(userId);

        for (var tweet : tweets) {
            if (tweet[1] != userId && (follows == null || !follows.contains(tweet[1]))) {
                continue;
            }

            result.add(tweet[0]);

            if (result.size() == 10) {
                break;
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        following
        .computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        final var followees = following.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }

    }
}
