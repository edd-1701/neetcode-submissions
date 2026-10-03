class TimeMap {
    class Pair {
        int ts;
        String val;

        public Pair(int ts, String val) {
            this.ts = ts;
            this.val = val;
        }
    }

    private Map<String, List<Pair>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new ArrayList<Pair>()).addFirst(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        final var times = data.getOrDefault(key, List.of());

        for (var entry : times) {
            if (entry.ts <= timestamp) {
                return entry.val;
            }
        }

        return "";
    }
}
