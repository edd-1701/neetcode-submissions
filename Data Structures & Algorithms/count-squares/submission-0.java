class CountSquares {
    private Map<List<Integer>, Integer> pointCounter = new HashMap<>();
    private List<List<Integer>> points = new ArrayList<>();

    public CountSquares() {}

    public void add(int[] point) {
        final var newPoint = List.of(point[0], point[1]);
        pointCounter.merge(newPoint, 1, Integer::sum);
        points.add(newPoint);
    }

    public int count(int[] point) {
        var result = 0;
        final var inX = point[0];
        final var inY = point[1];

        for (var pt : points) {
            final var x = pt.get(0);
            final var y = pt.get(1);

            if (Math.abs(inX - x) != Math.abs(inY - y) || x == inX || y == inY) {
                continue;
            }

            result += pointCounter.getOrDefault(List.of(x, inY), 0)
                * pointCounter.getOrDefault(List.of(inX, y), 0);
        }

        return result;
    }
}
