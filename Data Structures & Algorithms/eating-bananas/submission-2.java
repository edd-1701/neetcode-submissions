class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var maxSpeed = 0;
        for (var pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        var left = 1;
        var right = maxSpeed;
        var result = maxSpeed;
        while (left <= right) {
            final var middle = (left + right) / 2;
            if (canEatAll(piles, middle, h)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }

    private static boolean canEatAll(int[] piles, int speed, int hourLimit) {
        var hoursTaken = 0;
        for (var pile : piles) {
            hoursTaken += (pile / speed);
            hoursTaken += (pile % speed > 0 ? 1 : 0);

            if (hoursTaken > hourLimit) {
                return false;
            }
        }

        return true;
    }
}
