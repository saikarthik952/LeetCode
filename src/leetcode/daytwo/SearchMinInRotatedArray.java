package leetcode.daytwo;

public class SearchMinInRotatedArray {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};
        int left = 0;
        int right = array.length - 1;


         // 5,1,2,3,4 -> checking whether minimum value will be left part or right rotated by checking right against mid
            /*
            1st
            mid = 2
            low = 0
            right = 4

            2 < 4
            right = 2

            2nd

            mid=1
            1 < 2  true -> right = 1

            3rd
            mid = 0
            low = 0
            right = 1

            5 < 2 -> false -> mid + 1


            [3, 1, 2]

            mid = 1
            low = 0;
            high = 2
            1 < 2 -> true -> right = 1

            2nd
            mid = 0
            low = 0
            right = 1

            3 < 1 -> false

             */
        while(left < right) {
            int mid = (left + right)/ 2;
            if(array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(array[left]);

    }
}
