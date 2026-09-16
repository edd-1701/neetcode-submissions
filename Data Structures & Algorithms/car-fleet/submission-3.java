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
        final var cars = new ArrayList<CarData>();
        for (var i = 0; i < position.length; i++) {
            cars.add(new CarData(position[i], (double) speed[i]));
        }

        cars.sort((a, b) -> Integer.compare(b.position, a.position));

        final var stack = new Stack<Double>();
        for (var car : cars) {
            final var remainingDist = target - car.position;
            final var tripTime = remainingDist / car.speed;

            if (!stack.isEmpty() && tripTime <= stack.peek()) {
                continue;
            }

            stack.push(tripTime);
        }

        return stack.size();
    }
}
