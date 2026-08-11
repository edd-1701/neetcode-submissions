class Solution {
    private final static String DELIMITER = "%%%%";
    private final static String EMPTY = "@@@";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        final var result = new StringBuilder();
        var isFirst = true;
        for (var str : strs) {
            final var delimiter = isFirst ? "" : DELIMITER;
            result.append(delimiter).append(str.isEmpty() ? EMPTY : str);

            if (isFirst) {
                isFirst = false;
            }
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return List.of();
        }

        final var result = new ArrayList<String>();

        final var split = str.split(DELIMITER);

        for (var chunk : split) {
            result.add(chunk.equals(EMPTY) ? "" : chunk);
        }

        return result;
    }
}
