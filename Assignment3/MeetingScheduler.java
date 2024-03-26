public class MeetingScheduler {

    private void quickSort(int[][] intervals, int low, int high) {
        if (low < high) {
            int pi = partition(intervals, low, high);
            quickSort(intervals, low, pi - 1);
            quickSort(intervals, pi + 1, high);
        }
    }

    private int partition(int[][] intervals, int low, int high) {
        int[] pivot = intervals[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (intervals[j][0] <= pivot[0]) {
                i++;
                // Swap arr[i] and arr[j]
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (or pivot)
        int[] temp = intervals[i + 1];
        intervals[i + 1] = intervals[high];
        intervals[high] = temp;
        return i + 1;
    }

    public boolean canAttendMeetings(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false; // Found an overlap
            }
        }
        return true; // No overlap found
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};
        
        System.out.println("Can attend all meetings (Example 1): " + scheduler.canAttendMeetings(intervals1));
        System.out.println("Can attend all meetings (Example 2): " + scheduler.canAttendMeetings(intervals2));
    }
}
