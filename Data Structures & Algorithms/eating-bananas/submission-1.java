class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        var maxPile = Integer.MIN_VALUE;
        for (var pile: piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }

        var result = maxPile;

        var minRate = 1;
        var maxRate = maxPile;
        while (minRate <= maxRate) {
            final var currRate = (minRate + maxRate) / 2;
            var hoursTaken = 0;

            for (var pile : piles) {
                hoursTaken += pile / currRate;
                hoursTaken += pile % currRate == 0 ? 0 : 1;

                if (hoursTaken > h) {
                    break;
                }
            }

            if (hoursTaken <= h) {
                if (currRate < result) {
                    result = currRate;
                }
                maxRate = currRate - 1;
            } else {
                minRate = currRate + 1;
            }

        }

        return result;
        
    }
}
