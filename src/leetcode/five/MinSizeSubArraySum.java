package leetcode.five;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};

        int end = 0;
        int start = 0;

        int sum = 0;
        int t = 7;

        int length = Integer.MAX_VALUE;

        for (end =0; end < arr.length; end++) {
            sum += arr[end];

            while (sum >= t) {
                length = Math.min(length, end - start + 1);
                sum -= arr[start++];
            }
        }
        System.out.println(length);
    }
}
