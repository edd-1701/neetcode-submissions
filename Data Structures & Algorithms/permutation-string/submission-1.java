class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        final var charFrequencies = new HashMap<Character, Integer>();
        for (var i = 0; i < s1.length(); i++) {
            charFrequencies.merge(s1.charAt(i), 1, Integer::sum);
        }

        final var substrFreqs = new HashMap<Character, Integer>();
        for (var i = 0; i < s1.length(); i++) {
            substrFreqs.merge(s2.charAt(i), 1, Integer::sum);
        }

        // System.out.println(charFrequencies);
        var l = 0;
        var r = s1.length() - 1;
        while (r < s2.length()-1) {
            // System.out.println("\t" + substrFreqs);

            // System.out.println("\t" + substrFreqs);
            if (substrFreqs.equals(charFrequencies)) {
                return true;
            }
            
            final var leftFreq = substrFreqs.merge(s2.charAt(l), -1, Integer::sum);
            if (leftFreq <= 0) {
                substrFreqs.remove(s2.charAt(l));
            }
            l += 1;

            r += 1;
            substrFreqs.merge(s2.charAt(r), 1, Integer::sum);



        }

        return substrFreqs.equals(charFrequencies);
    }


}
