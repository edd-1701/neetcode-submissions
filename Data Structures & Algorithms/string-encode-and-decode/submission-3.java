class Solution {
    private final static String DELIMITER = "@@@";
    private final static String EMPTY_STR = "[BLANK_STR]";


    public String encode(List<String> strs) {
        final var output = new StringBuilder();

        final var lastIdx = strs.size() - 1;
        var i = 0;
        for (final var str : strs) {
            final var appendStr = i == lastIdx ? "" : DELIMITER;

            output.append(str.isEmpty() ? EMPTY_STR : str).append(appendStr);
            i += 1;
        }

        // System.out.println("encode result: " + output.toString());

        return output.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return List.of();
        }
        // System.out.println("decode input str: " + str + "len: " + str.length());
        final var result = new ArrayList<String>();
        
        final var split = str.split(DELIMITER);

        // System.out.println("decode split result: " + Arrays.toString(split) + "size: " + split.length);

        for (var word : split) {
            if (word.equals(EMPTY_STR)) {
                result.add("");
            } else {
                // System.out.println("IS BLANK:" + word.isBlank());
                result.add(word);
            }
        }

        return result;
    }
}
