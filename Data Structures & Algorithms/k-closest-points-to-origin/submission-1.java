class Solution {
    public int[][] kClosest(int[][] points, int k) {

        final var pointCache = new HashMap<int[], Double>();
    
        Arrays.sort(points, (a,b) -> {

            if (!pointCache.containsKey(a)) {
                final var distanceA = Math.sqrt(
                    Math.pow(a[0] - 0, 2) + 
                    Math.pow(a[1] - 0, 2)
                );
                pointCache.put(a, distanceA);
            }

            if (!pointCache.containsKey(b)) {
                final var distanceB = Math.sqrt(
                    Math.pow(b[0] - 0, 2) + 
                    Math.pow(b[1] - 0, 2)
                );
                pointCache.put(b, distanceB);
            }

            return Double.compare(pointCache.get(a), pointCache.get(b));
        });

        return Arrays.copyOf(points, k);
    }
}