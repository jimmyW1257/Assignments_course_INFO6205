package FinalProject;

class Solution3 {
    public void invertWords(char[] str) {
        // Invert each word in the character array.
        int wordStart = 0;
        for (int i = 0; i <= str.length; i++) {
            if (i == str.length || str[i] == ' ') {
                flip(str, wordStart, i - 1);
                wordStart = i + 1;
            }
        }

        // Invert the entire character array.
        flip(str, 0, str.length - 1);
    }

    private void flip(char[] str, int left, int right) {
        while (left < right) {
            char swap = str[left];
            str[left] = str[right];
            str[right] = swap;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        
        char[] example = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        solution.invertWords(example);
        System.out.println(example); 
    }
}

