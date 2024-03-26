package Assignment2;

public class BinarySearchSolutions {

    // Method to count occurrences of a target in a sorted array
    public static int countOccurrences(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return 0; // Target not found
        int last = findLast(nums, target);
        return last - first + 1;
    }

    private static int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || target > nums[mid - 1]) && nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == nums.length - 1 || target < nums[mid + 1]) && nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Method to search in a rotated sorted array
    public static int searchInRotatedArray(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left side is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right side is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        System.out.println("Target 4 = " + countOccurrences(sortedArray, 4) + " Occurrences");
        System.out.println("Target 2 = " + countOccurrences(sortedArray, 2) + " Occurrences");
        System.out.println("Target 5 = " + countOccurrences(sortedArray, 5) + " Occurrences");

        int[] rotatedArray = {6, 7, 8, 2, 3, 4, 5};
        System.out.println("Target 8 = " + searchInRotatedArray(rotatedArray, 8));
        System.out.println("Target 9 = " + searchInRotatedArray(rotatedArray, 9));
    }
}

