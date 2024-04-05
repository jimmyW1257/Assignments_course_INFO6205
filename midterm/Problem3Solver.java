package midterm;
import java.util.ArrayDeque;

public class Problem3Solver {

    public boolean confirmPreorder(int[] preorderSequence) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int minValue = Integer.MIN_VALUE;
        for (int num : preorderSequence) {
            if (num < minValue) return false;
            while (!stack.isEmpty() && num > stack.peek()) {
                minValue = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem3Solver solver = new Problem3Solver();
        int[] preorderSample = {5, 2, 1, 3, 6};
        System.out.println("Preorder sequence verification:");
        System.out.println("Sequence: " + java.util.Arrays.toString(preorderSample));
        System.out.println("Is valid preorder: " + solver.confirmPreorder(preorderSample));
        
    }
}
