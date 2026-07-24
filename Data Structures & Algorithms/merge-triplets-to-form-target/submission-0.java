class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        var foundA = false;
        var foundB = false;
        var foundC = false;

        for (var triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            if (triplet[0] == target[0]) {
                foundA = true;
            }
            if (triplet[1] == target[1]) {
                foundB = true;
            }
            if (triplet[2] == target[2]) {
                foundC = true;
            }
        }


        return foundA && foundB && foundC;
    }
}
