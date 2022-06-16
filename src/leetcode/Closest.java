package leetcode;

public class Closest {

    public static void main(String[] args) {
        /**
         * Please write a function that searches in an array of a numeric values for the value
         * that is closest to a given value N. If there are two values that are equally far away,
         * return the greater value.
         *
         * Example:
         *
         * searchClosest(4.5, array(-1.5, 0, 4, 5, 6, 7));
         * => 5
         *
         * searchClosest(5.5, array(-1.5, 0, 4.4, 5, 6, 7));
         * => 6
         */

        float[] arr = new float[]{-1.5f, 0, 4.4f, 5, 6, 7};
        float closestValue = Integer.MAX_VALUE;
        float target = 5.5f;
        int closesIndex = 0;

        for  (int i = 0; i < arr.length; i++) {
            float v = Math.abs(arr[i]  - target);
            if (v < closestValue && arr[i] >= arr[closesIndex]) {
                closestValue = v;
                closesIndex = i;
            }
        }
        System.out.println(arr[closesIndex]);

    }
}
