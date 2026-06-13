class WordDictionary {
    private Set<String> exactWords;

    public WordDictionary() {
        exactWords = new HashSet<String>();
    }

    public void addWord(String word) {
        exactWords.add(word);
    }

    public boolean search(String word) {
        if (exactWords.contains(word)) {
            return true;
        }

        for (var dictWord : exactWords) {
            if (dictWord.length() != word.length()) {
                continue;
            }

            var i = 0;
            while (i < word.length()) {
                if (word.charAt(i) != '.' && word.charAt(i) != dictWord.charAt(i)) {
                    break;
                }
                i += 1;
            }
            if (i == word.length()) {
                return true;
            }
        }

        return false;
    }
}
