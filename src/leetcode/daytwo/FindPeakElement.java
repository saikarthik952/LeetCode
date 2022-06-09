package leetcode.daytwo;

public class FindPeakElement {

    /**
     * A peak element is an element that is strictly greater than its neighbors.
     *
     * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
     *
     * You may imagine that nums[-1] = nums[n] = -∞.
     *
     * You must write an algorithm that runs in O(log n) time.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * we are aware that an array can contain at least one peak as adjacent elememnts will not be there
         * to get the peak element we can check mid by using binary search, we can confirm that it will be always a peak becuase -inf and +inf constraint in
         * first of array or last array
         *Now
         * where if mid is greater than right element, we chec left element is less than mid, by following this approach, low and high will be same
         * By end of finding the peak, the low and high will be same
         * we are finding increasing slope here
         */
        int[] array = new int[]{5,4,3,2,1};
            int low = 0;
            int high = array.length - 1;

        while (low < high) {
            int mid = (low + high)/2;


            if (array[mid] > array[mid + 1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(low);

    }
}
