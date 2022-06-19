package leetcode.fourth;

public class Backspace {
    public static void main(String[] args) {
        String s = "###", t = "#c";

        int sIter = 0;

        int tIter = 0;

        int sLen = s.length() - 1;
        int tLen = t.length() - 1;
        while (sLen>= 0 || tLen >= 0) {
            int i = getValidNextIndex(s, sLen);
            int j = getValidNextIndex(t, tLen);
            if (i< 0 && j < 0) {
                System.out.println("true");
                break;
                //return true;
            }
            if (i< 0 || j <0) {
                System.out.println("false");
                break;
                //return false;
            }

            if (s.charAt(i) != t.charAt(j)) {
                System.out.println("false");
                break;
                //return false;
            }
            sLen = i - 1;
            tLen = j - 1;
        }
        System.out.println(true);
        //return true;

    }

    private static int getValidNextIndex(String t, int len) {
        int bs = 0;
        while (len >= 0) {
            if (t.charAt(len) == '#') {
                bs++;
            }
            else if (bs > 0) {
                bs--;
            }
            else {
                break;
            }
            len--;
        }
        return len;
    }
}
