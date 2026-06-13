class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // list of [position, speed]
        final var carData = new ArrayList<int[]>();
        for (var i = 0; i < position.length; i++) {
            carData.add(new int[]{position[i], speed[i]});
        }
        carData.sort((a,b) -> b[0] - a[0]);
        // carData.sort((a,b) -> Integer.compare(b[0], a[0]));

        final var stack = new Stack<Double>();
        for (var car : carData) {
            final var remainingDistance = target - car[0];
            final var tripTime = (double) remainingDistance / car[1];

            if (!stack.isEmpty() && tripTime <= stack.peek()) {
                // stack.pop();
                continue;
            }
            
            stack.push(tripTime);
        }

        return stack.size();
    }
}
