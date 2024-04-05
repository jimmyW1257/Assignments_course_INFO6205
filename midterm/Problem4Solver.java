package midterm;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Problem4Solver {

    public int findShortestPath(int[][] labyrinth, int[] entry, int[] exit) {
        int rows = labyrinth.length, cols = labyrinth[0].length;
        int[][] distances = new int[rows][cols]; 
        for (int[] distanceRow : distances) {
            java.util.Arrays.fill(distanceRow, Integer.MAX_VALUE);
        }
        distances[entry[0]][entry[1]] = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entry[0], entry[1], 0});
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point[0] == exit[0] && point[1] == exit[1]) {
                return point[2];
            }
            for (int[] direction : directions) {
                int x = point[0] + direction[0];
                int y = point[1] + direction[1];
                int steps = 0;
                while (x >= 0 && y >= 0 && x < rows && y < cols && labyrinth[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                    steps++;
                }
               
                x -= direction[0];
                y -= direction[1];
                if (distances[point[0]][point[1]] + steps < distances[x][y]) {
                    distances[x][y] = distances[point[0]][point[1]] + steps;
                    queue.add(new int[]{x, y, distances[x][y]});
                }
            }
        }
        return distances[exit[0]][exit[1]] == Integer.MAX_VALUE ? -1 : distances[exit[0]][exit[1]];
    }

    public static void main(String[] args) {
        Problem4Solver pathFinder = new Problem4Solver();
        
        int[][] maze = {
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0}
        };
        int[] start = {0, 4};
        int[] end = {4, 4};
        System.out.println("Example:");
        System.out.println("Shortest path length: " + pathFinder.findShortestPath(maze, start, end));
        
    }
}
