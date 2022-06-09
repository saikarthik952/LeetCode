package leetcode.dayone;

public class Problem2 {
    /**
     * Search in Rotated Sorted Array
     * @param args
     */
    public static void main(String[] args) {
        /*
     Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

         */
        int[] array = new int[]{4,5,6,7,0,1,2};

        int target = 0;
        int foundStart = binarySearch(array, target);
       System.out.println(foundStart);


    }

    public static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (array[mid] == target) {

                return mid;
            }
            // check if the element is present in first half of rotated array, that will help determine whether we
            // need to check only that part
            else if (array[mid] < array[low]) {
                if (target < array[mid] || target >= array[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (target > array[mid] || target < array[low]) {
                low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
