/*
    - Store initial data in a 2d array/object containing the cars' speed and position
    - sort by position descending

    - create a stack that will store the trip time remaining-distance / speed
    - if curr car trip time less than stack peek, it is a fleet, do not add to stack
    - else, add trip time to stack
    - return stack size, which will be the fleets

*/

class Solution {
    record CarData(int position, double speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        final var cars = new ArrayList<int[]>();
        for (var i = 0; i < position.length; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }

        cars.sort((a, b) -> Integer.compare(b[0], a[0]));

        final var stack = new Stack<Double>();
        for (var car : cars) {
            final var remainingDist = target - car[0];
            final var tripTime = remainingDist / (double)car[1];

            if (!stack.isEmpty() && tripTime <= stack.peek()) {
                continue;
            }

            stack.push(tripTime);
        }

        return stack.size();
    }
}
