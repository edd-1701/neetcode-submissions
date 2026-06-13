class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        Arrays.sort(points, (a,b) -> {
            final var distanceA = Math.sqrt(
                Math.pow(a[0] - 0, 2) + 
                Math.pow(a[1] - 0, 2)
            );
            
            final var distanceB = Math.sqrt(
                Math.pow(b[0] - 0, 2) + 
                Math.pow(b[1] - 0, 2)
            );

            return Double.compare(distanceA, distanceB);
        });

        return Arrays.copyOf(points, k);
    }


}


