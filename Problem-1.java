/**
 * Approach:
 * - Iterate through each word in the input array.
 * - For each word, sort its characters to create a canonical form (anagram signature).
 * - Use a HashMap to group words with the same sorted signature.
 * - The key is the sorted word, and the value is a list of original words (anagrams).
 * - Finally, return the grouped anagram lists from the HashMap.
 */

// Time Complexity : O(N * K log K), where N is the number of words and K is the maximum length of a word.
// Space Complexity : O(N * K), for storing grouped anagrams.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize a hashmap to group words by their sorted character signature
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // Convert word to char array and sort it to get the canonical form
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars); // This will act as the key
            
            // If key doesn't exist, initialize list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            // Add original word to the correct anagram group
            map.get(sortedWord).add(word);
        }
        
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
