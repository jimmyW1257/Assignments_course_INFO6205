package Assignment5;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int findLongestSubstringWithTwoDistinct(String str) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int windowStart = 0, maxLen = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currentChar = str.charAt(windowEnd);
            lastIndexMap.put(currentChar, windowEnd);

            if (lastIndexMap.size() > 2) {
                int earliestIndex = str.length();
                for (int index : lastIndexMap.values()) {
                    earliestIndex = Math.min(earliestIndex, index);
                }

                // Remove the character at the earliest index
                lastIndexMap.remove(str.charAt(earliestIndex));

                // Adjust the start of the window
                windowStart = earliestIndex + 1;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // Example 1
        String test1 = "eceba";
        System.out.println("Input: " + test1);
        System.out.println("Output: " + solution.findLongestSubstringWithTwoDistinct(test1));

        // Example 2
        String test2 = "ccaabbb";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + solution.findLongestSubstringWithTwoDistinct(test2));
    }
}

