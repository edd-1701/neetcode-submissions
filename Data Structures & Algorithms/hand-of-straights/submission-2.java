/*
    Experimental using TreeMap
*/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        final var cardCounts = new TreeMap<Integer, Integer>();
        for (var num : hand) {
            cardCounts.merge(num, 1, Integer::sum);
        }

        final var groupsNeeded = hand.length / groupSize;
        var groupsMade = 0;
        while (groupsMade < groupsNeeded) {
            var currCard = cardCounts.firstEntry().getKey();

            subtractCard(currCard, cardCounts);

            var handSize = 1;
            while (handSize < groupSize) {
                if (!cardCounts.containsKey(currCard + 1)) {
                    return false;
                }

                currCard += 1;
                subtractCard(currCard, cardCounts);

                handSize += 1;
            }

            groupsMade += 1;
        }

        return true;
    }

    private void subtractCard(int card, Map<Integer, Integer> cardCounts) {
        if (cardCounts.merge(card, -1, Integer::sum) == 0) {
            cardCounts.remove(card);
        }
    }
}
