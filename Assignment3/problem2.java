public class problem2 {
    private long res = 0, mod = 1000_000_007;
    public int subarraysWithMoreZerosThanOnes(int[] nums) {

    int[] prefixSum = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) nums[i] = -1;
        if (i == 0) prefixSum[i] = nums[i];
        else prefixSum[i] = prefixSum[i-1] + nums[i];

        if (prefixSum[i] > 0) res++;
    }

    mergeSort(prefixSum, 0, nums.length-1);
    return (int) (res % mod);
    }
    
    public void mergeSort(int[] prefixSum, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(prefixSum, left, middle);
        mergeSort(prefixSum, middle+1, right);
        merge(prefixSum, left, middle, right);
    }
    
    private void merge(int[] prefixSum, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        
        // two pointers;
        int i = left;
        int j = middle+1;
        int index = 0;
        
        while (i <= middle && j <= right) {
            if (prefixSum[i] < prefixSum[j]) {
                temp[index++] = prefixSum[i++];
            } else {
                res += (i - left);
                temp[index++] = prefixSum[j++];
            }
        }
        
        while(i <= middle) temp[index++] = prefixSum[i++];
        while(j <= right) {
            res += (i - left);  // here, we make sure that prefixSum[left_last_element] < prefixSum[j];
            temp[index++] = prefixSum[j++];
        }
        
        for (int m = left; m <= right; m++) prefixSum[m] = temp[m-left];
    }
}
