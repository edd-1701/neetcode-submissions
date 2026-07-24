class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        var foundA = false;
        var foundB = false;
        var foundC = false;

        for (var triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            foundA |= triplet[0] == target[0];
            foundB |= triplet[1] == target[1];
            foundC |= triplet[2] == target[2];

            if (foundA && foundB && foundC) {
                return true;
            }
        }

        return false;
    }
}
