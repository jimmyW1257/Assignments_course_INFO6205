package FinalProject;

// Simulated SocialGraph class containing the doesKnow API.
class SocialGraph {
    boolean doesKnow(int person1, int person2) {
        // Placeholder for the doesKnow method. Adjust according to actual implementation details.
        int[][] acquaintanceMatrix = {
            {1, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        return acquaintanceMatrix[person1][person2] == 1;
    }
}

// Solution1 class extends SocialGraph and uses the doesKnow API.
public class Solution1 extends SocialGraph {
    public int locateCelebrity(int totalPeople) {
        int suspect = 0;
        for (int i = 1; i < totalPeople; i++) {
            if (doesKnow(suspect, i)) {
                suspect = i;
            }
        }
        for (int i = 0; i < totalPeople; i++) {
            if (suspect != i && (doesKnow(suspect, i) || !doesKnow(i, suspect))) {
                return -1;
            }
        }
        return suspect;
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        
        // Number of people in the scenario
        int numberOfPeople = 3;
        
        // Result from the locateCelebrity method
        int celebrity = solution.locateCelebrity(numberOfPeople);
        
        // Display the result
        System.out.println(celebrity);
    }
}

