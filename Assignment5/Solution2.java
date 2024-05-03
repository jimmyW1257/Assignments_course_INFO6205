package Assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    
    // Strobogrammatic pairs definition
    private static final char[][] STROBO_PAIRS = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> generateStrobogrammatic(int length) {
        return buildStrobogrammatic(length, length);
    }

    private List<String> buildStrobogrammatic(int currentLength, int totalLength) {
        if (currentLength == 0) return Arrays.asList("");
        if (currentLength == 1) return Arrays.asList("0", "1", "8");
        
        List<String> partialResults = buildStrobogrammatic(currentLength - 2, totalLength);
        List<String> completeResults = new ArrayList<>();

        for (String part : partialResults) {
            for (char[] pair : STROBO_PAIRS) {
                // Avoid numbers with a leading zero
                if (pair[0] == '0' && currentLength == totalLength) continue;
                completeResults.add(pair[0] + part + pair[1]);
            }
        }

        return completeResults;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> output = solution.generateStrobogrammatic(2);
        System.out.println(output);
        output = solution.generateStrobogrammatic(1);
        System.out.println(output);
    }
}

