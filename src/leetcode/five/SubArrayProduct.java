package leetcode.five;

public class SubArrayProduct {
    public static void main(String[] args) {
        int[] arr = new  int[]{10,5,2,6};
        int l = 100;
        int prod = 1;
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            prod *= arr[i];

            while (prod >= l && j <= i) {
                prod /= arr[j++];
            }
            cnt += i - j + 1;
        }
        System.out.println(cnt);
    }
}
