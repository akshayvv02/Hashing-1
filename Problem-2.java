/**
 * Approach:
 * - Check if both strings are of the same length; if not, return false.
 * - Use a HashMap to store character mappings from `s` to `t`.
 * - Use a HashSet to track already mapped characters from `t` to avoid duplicates.
 * - Iterate through characters of both strings:
 *   - If the character from `s` is already mapped, check for consistency with `t`.
 *   - If not mapped, ensure the character from `t` is not already used, then map it.
 * - If all character mappings are consistent and unique, return true.
 */
// Time Complexity : O(N) where N is the length of the strings.
// Space Complexity : O(N), for storing mappings and used characters.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Strings of different lengths can't be isomorphic
        if (s.length() != t.length())
            return false;

        // Map from characters in s to characters in t
        HashMap<Character, Character> hms = new HashMap<>();
        // Set to track characters already mapped in t
        HashSet<Character> hmt = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (hms.containsKey(a)) {
                // If already mapped, check if mapping is consistent
                if (hms.get(a) != b)
                    return false;
            } else {
                // If b is already mapped to some other character, return false
                if (hmt.contains(b))
                    return false;

                // Create new mapping and mark b as used
                hms.put(a, b);
                hmt.add(b);
            }
        }

        // All mappings are valid
        return true;
    }
}

