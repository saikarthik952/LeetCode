package leetcode.thirdday;

import java.util.ArrayList;

public class ThreeSum {
    public static void main(String[] args) {
        int[] array = new int[]{-1,0,1,2,-1,-4};
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int a = array[i];

            for (int j = i + 1; j < array.length; j++) {
                int b = array[j];

                for (int l = j + 1; l < array.length; l++) {

                    int c = array[l];

                    if (a + b + c == 0) {
                    arrayList.add(new Integer[]{a, b , c});
                    }
                }
                }
        }
       arrayList.forEach(vals -> {
           for (int i = 0; i < 3; i++)
               System.out.println(vals[i]);
       });
    }
}
