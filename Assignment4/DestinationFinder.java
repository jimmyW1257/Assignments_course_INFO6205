import java.util.ArrayList;
import java.util.List;

public class DestinationFinder {
    private List<List<Integer>> adjacencyList;
    private boolean[] hasVisited;
    private int target;

    public boolean canReachTarget(int vertices, int[][] connections, int start, int target) {
        this.adjacencyList = new ArrayList<>();
        this.hasVisited = new boolean[vertices];
        this.target = target;

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adjacencyList.get(connection[0]).add(connection[1]);
        }

        return search(start);
    }

    private boolean search(int vertex) {
        if (adjacencyList.get(vertex).isEmpty()) {
            return vertex == target;
        }

        if (hasVisited[vertex]) {
            return false;
        }

        hasVisited[vertex] = true;
        for (int adjacent : adjacencyList.get(vertex)) {
            if (!search(adjacent)) {
                return false;
            }
        }
        hasVisited[vertex] = false;

        return true;
    }

    public static void main(String[] args) {
        DestinationFinder navigator = new DestinationFinder();
        int[][] routes1 = {{0, 1}, {0, 2}};
        System.out.println(navigator.canReachTarget(3, routes1, 0, 2)); // Output: false
        
        int[][] routes2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(navigator.canReachTarget(4, routes2, 0, 3)); // Output: true
    }
}
