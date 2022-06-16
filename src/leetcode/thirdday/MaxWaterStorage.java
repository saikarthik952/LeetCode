package leetcode.thirdday;

public class MaxWaterStorage {
    public static void main(String[] args) {
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};

        int start = 0;
        int end = array.length - 1;
        int maxSoFar = 0;
        while (start < end) {


            int area = Math.min(array[start], array[end]) * (end - start);
            maxSoFar = Math.max(maxSoFar, area);


            if (array[start] < array[end]) {
                start++;
            }
            else if(array[end] <= array[start]) {
                end--;
            }
        }


    System.out.println(maxSoFar);
    }
}
