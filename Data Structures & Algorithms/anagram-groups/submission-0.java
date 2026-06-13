class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //iterate each string and 
        //

        //key sorted character + frequency count
        final var wordMap = new HashMap<String, List<String>>();

        for (final var word : strs) {
            final var keyString = getCharacterFrequencyString(word);

            if (!wordMap.containsKey(keyString)) {
                wordMap.put(keyString, new ArrayList<>());
            } 
            
            wordMap.get(keyString).add(word);
            
        }

        final var result = new ArrayList<List<String>>();
        for (final var xd : wordMap.values()) {
            result.add(xd);
        }

        return result;
    }


    private static String getCharacterFrequencyString(final String str) {
        if (str.isBlank()) {
            return " ";
        }

        final var charCounts = new TreeMap<Character, Integer>();

        for (var i = 0; i < str.length(); i++) {
            final var currChar = str.charAt(i);
            charCounts.merge(currChar, 1, Integer::sum);
        }

        return charCounts.toString();
    }
}
