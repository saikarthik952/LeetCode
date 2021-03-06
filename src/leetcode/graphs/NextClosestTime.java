package leetcode.graphs;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public static void main(String[] args) {
        String time = "23:59";
        String time2 = "19:34";

        /**
         * 1. we may find all different permutations with repeptetions of above 4 digits
         *
         * 0 - 2400 range
         * 2359 ->
         */

        System.out.println(nextClosestTime(time));

    }

    public static String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));
        int ans = start;
        int elapsed = 24 * 60;
        Set<Integer> allowed = new HashSet();
        for (char c: time.toCharArray()) if (c != ':') {
            allowed.add(c - '0');
        }

        for (int h1: allowed)
            for (int h2: allowed)
                if (h1 * 10 + h2 < 24) {
            for (int m1: allowed)
                for (int m2: allowed)
                    if (m1 * 10 + m2 < 60) {
                int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
                int candElapsed = Math.floorMod((cur - start) , (24 * 60));
                if (0 < candElapsed && candElapsed < elapsed) {
                    ans = cur;
                    elapsed = candElapsed;
                }
            }
        }

        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}
