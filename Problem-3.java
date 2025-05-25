/**
 * Approach:
 * - Split the input string `s` by spaces to get individual words.
 * - If the number of words doesn't match the pattern length, return false.
 * - Use a HashMap to map each word to a character in the pattern.
 * - Use a HashSet to ensure no two words map to the same character.
 * - Iterate through the pattern and words:
 *   - If a word is already mapped, verify it maps to the correct pattern character.
 *   - If not mapped, ensure the pattern character isn't already used, then map it.
 * - If all mappings are consistent, return true.
 */

// Time Complexity : O(N), where N is the number of words/characters.
// Space Complexity : O(N), for storing the map and set.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        // If lengths don't match, return false
        if (arr.length != pattern.length())
            return false;

        // Map each word to a pattern character
        Map<String, Character> hms = new HashMap<>();
        // Track used pattern characters
        Set<Character> hmt = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            String word = arr[i];

            if (hms.containsKey(word)) {
                // Check if current mapping is consistent
                if (!hms.get(word).equals(c))
                    return false;
            } else {
                // If character is already used, invalid pattern
                if (hmt.contains(c))
                    return false;

                // Create new mapping
                hms.put(word, c);
                hmt.add(c);
            }
        }

        // All mappings are valid
        return true;
    }
}
