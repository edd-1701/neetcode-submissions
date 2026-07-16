class Solution {
    public List<Integer> partitionLabels(String s) {
        final var lastIdx = new HashMap<Character, Integer>();

        for (var i = 0; i < s.length(); i++) {
            lastIdx.put(s.charAt(i), i);
        }

        final var result = new ArrayList<Integer>();

        var groupEndIndex = 0;
        var groupLen = 0;
        for (var i = 0; i < s.length(); i++) {
            final var currChar = s.charAt(i);
            groupEndIndex = Math.max(groupEndIndex, lastIdx.get(currChar));

            groupLen += 1;

            if (i == groupEndIndex) {
                result.add(groupLen);
                groupLen = 0;
            }

        }


        return result;


    }
}
