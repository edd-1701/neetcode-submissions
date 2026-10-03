class TimeMap {
    private Map<String, List<Pair<Integer, String>>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new ArrayList<Pair<Integer, String>>())
            .addFirst(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        for (var entry : data.getOrDefault(key, List.of())) {
            if (entry.getKey() <= timestamp) {
                return entry.getValue();
            }
        }

        return "";
    }
}
