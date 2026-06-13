class Solution {
    public int[][] kClosest(int[][] points, int k) {    
        Arrays.sort(points, (a,b) -> 
            Double.compare(
                Math.hypot(a[0] - 0, a[1] - 0),
                Math.hypot(b[0] - 0, b[1] - 0)
            )
        );
        return Arrays.copyOf(points, k);
    }
}