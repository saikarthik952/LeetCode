package leetcode.graphs;

import java.util.HashMap;

public class CoupleHoldingHands {
    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0,2,1,3}));
    }
    public static int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        int res = 0;
        while(index < row.length)
        {
            map.put(row[index],row[index + 1]);
            map.put(row[index + 1], row[index]);
            index = index + 2;
        }
        index = 0;
        while(index < row.length)
        {
            if(map.get(index) != index + 1)
            {
                int nextvalue = map.get(index + 1);
                int currentvalue = map.get(index);
                map.put(currentvalue, nextvalue);
                map.put(nextvalue, currentvalue);
                map.put(index, index + 1);
                map.put(index + 1, index);
                res++;
            }
            index = index + 2;
        }
        return res;
    }
}
