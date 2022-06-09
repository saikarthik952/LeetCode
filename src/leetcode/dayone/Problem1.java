package leetcode.dayone;

public class Problem1 {
    /**
     *  Find First and Last Position of Element in Sorted Array
     * @param args
     */
    public static void main(String[] args) {
        /*
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

         */
        int[] array = new int[]{5,7,7,8,8,10};

        int target = 8;
        int foundStart = binarySearch(array, target, true);
        int foundEnd = binarySearch(array, target, false);
        int[] arrayEmp = new int[]{foundStart, foundEnd};
            for (int i = 0; i < 2; i++) {

                System.out.println(arrayEmp[i]);
            }


    }

    public static int binarySearch(int[] array, int target, boolean searchingForStart) {

        int low = 0;
        int high = array.length - 1;
        int start = -1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (array[mid] == target) {
                start = mid;
                // If we are searching for start, we must modify high to check left most list, to check if there is
                // the same element
                if (searchingForStart) {

                    high = mid - 1;
                }
                // same as above modify the low to check right most array from mid to check whether we have another chance of element
                else {
                    low = mid + 1;
                }
            }
            else if (array[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return start;
    }
}
