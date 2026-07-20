class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        final var cardSet = new TreeSet<Integer>();
        final var cardCounts = new HashMap<Integer, Integer>();
        for (var card : hand) {
            cardSet.add(card);
            cardCounts.merge(card, 1, Integer::sum);
        }

        final var groupsNeeded = hand.length / groupSize;
        var groupsMade = 0;
        while (groupsMade < groupsNeeded) {

            var currentCard = cardSet.first();
            decrementCard(currentCard, cardSet, cardCounts);

            var handSize = 1;
            while (handSize < groupSize) {
                if (!cardSet.contains(currentCard + 1)) {
                    return false;
                }

                currentCard += 1;
                decrementCard(currentCard, cardSet, cardCounts);

                handSize += 1;
            }



            groupsMade += 1;
        }

        return true;


    }

    private void decrementCard(int num, TreeSet<Integer> set, HashMap<Integer, Integer> map) {
        final var newFrequency = map.merge(num, -1, Integer::sum);
        if (newFrequency == 0) {
            map.remove(num);
            set.remove(num);
        }
    }

}
