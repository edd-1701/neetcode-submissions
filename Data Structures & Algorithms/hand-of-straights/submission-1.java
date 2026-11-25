/*

    put the cards in a set
    also put in a treeMap that counts the frequency of each number
    then simulate putting the hand together
*/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        final var cardSet = new TreeSet<Integer>();
        final var cardCounts = new HashMap<Integer, Integer>();
        for (var num : hand) {
            cardSet.add(num);
            cardCounts.merge(num, 1, Integer::sum);
        }

        final var groupsNeeded = hand.length / groupSize;
        var groupsMade = 0;
        while (groupsMade < groupsNeeded) {
            var currCard = cardSet.first();
            subtractCard(currCard, cardSet, cardCounts);

            var handSize = 1;
            while (handSize < groupSize) {
                if (!cardSet.contains(currCard + 1)) {
                    return false;
                }

                currCard += 1;
                subtractCard(currCard, cardSet, cardCounts);

                handSize += 1;
            }

            groupsMade += 1;
        }

        return true;
    }

    private void subtractCard(
        int card, TreeSet<Integer> cardSet, Map<Integer, Integer> cardCounts) {
        if (cardCounts.merge(card, -1, Integer::sum) == 0) {
            cardCounts.remove(card);
            cardSet.remove(card);
        }
    }
}
