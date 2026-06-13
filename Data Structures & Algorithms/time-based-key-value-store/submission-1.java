class TimeMap {

    private Map<String, ArrayList<Pair<Integer, String>>> data;

    public TimeMap() {
        data = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if (!data.containsKey(key)) {
            data.put(key, new ArrayList<>());
        }

        data.get(key).addFirst(new Pair<>(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }

        final var values = data.get(key);

        for (var value : values) {
            if (value.getKey() <= timestamp) {
                return value.getValue();
            }
        }
        
        // if (values.getFirst().getKey() <= timestamp) {
        //     return values.getFirst().getValue();
        // }

        return "";
    }
}
