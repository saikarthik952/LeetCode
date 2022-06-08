package leetcode.dayone;

public class Problem3 {
    /**
     * Search a 2D Matrix
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        int i = 0;
        int j = matrix[0].length - 1;

        boolean flag = false;
        while ( i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                flag = true;
                break;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else if (matrix[i][j] < target){
             i++;
            }

        }
        System.out.println(flag);
    }
}
