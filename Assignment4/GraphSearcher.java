import java.util.ArrayList;
import java.util.List;

public class GraphSearcher {

    static class NetworkGraph {
        private final List<List<Integer>> connections;

        public NetworkGraph(int count) {
            connections = new ArrayList<>();
            for (int index = 0; index < count; index++) {
                connections.add(new ArrayList<>());
            }
        }

        public void linkNodes(int first, int second) {
            connections.get(first).add(second);
            connections.get(second).add(first); // Assuming an undirected graph
        }

        public boolean isPathAvailable(int from, int to) {
            boolean[] explored = new boolean[connections.size()];
            return explore(from, to, explored);
        }

        private boolean explore(int start, int goal, boolean[] explored) {
            if (start == goal) {
                return true;
            }

            explored[start] = true;

            for (int adjacent : connections.get(start)) {
                if (!explored[adjacent] && explore(adjacent, goal, explored)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        NetworkGraph simpleGraph = new NetworkGraph(3);
        simpleGraph.linkNodes(0, 1);
        simpleGraph.linkNodes(1, 2);
        simpleGraph.linkNodes(0, 2);

        System.out.println("Direct path from 0 to 2: " + simpleGraph.isPathAvailable(0, 2));

        NetworkGraph complexGraph = new NetworkGraph(6);
        complexGraph.linkNodes(0, 1);
        complexGraph.linkNodes(0, 2);
        complexGraph.linkNodes(3, 5);
        complexGraph.linkNodes(5, 4);
        complexGraph.linkNodes(4, 3);

        System.out.println("Direct path from 0 to 5: " + complexGraph.isPathAvailable(0, 5));
    }
}
