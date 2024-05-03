package FinalProject;

import java.util.*;

public class Solution4 {
    private Map<String, List<Integer>> wordLocations;

    public Solution4(String[] wordsDictionary) {
        wordLocations = new HashMap<>();
        for (int pos = 0; pos < wordsDictionary.length; pos++) {
            wordLocations.putIfAbsent(wordsDictionary[pos], new ArrayList<>());
            wordLocations.get(wordsDictionary[pos]).add(pos);
        }
    }

    public int findShortestDistance(String firstWord, String secondWord) {
        List<Integer> locations1 = wordLocations.get(firstWord);
        List<Integer> locations2 = wordLocations.get(secondWord);
        int smallestDistance = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < locations1.size() && j < locations2.size();) {
            int pos1 = locations1.get(i), pos2 = locations2.get(j);
            smallestDistance = Math.min(smallestDistance, Math.abs(pos1 - pos2));
            if (pos1 < pos2) {
                i++;
            } else {
                j++;
            }
        }
        
        return smallestDistance;
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        Solution4 distanceFinder = new Solution4(dictionary);
        System.out.println(distanceFinder.findShortestDistance("coding", "practice"));  // Output: 3
    }
}

