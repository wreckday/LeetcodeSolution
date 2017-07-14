/**
 * Created by Mellon on 5/27/17.
 */
public class RangeAdditionII {
//    private static int max = 0;
//    public static int maxCount(int m, int n, int[][] ops) {
//        int[][] matrix = new int[m][n];
//        for(int i=0;i<ops.length;i++){
//            helper(matrix, ops[i][0], ops[i][1]);
//        }
//        int count = 0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(matrix[i][j] == max) count++;
//            }
//        }
//        return count;
//    }
//
//    private static void helper(int[][] matrix, int m, int n){
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                matrix[i][j] = matrix[i][j] + 1;
//                max = Math.max(matrix[i][j], max);
//            }
//        }
//    }

    public static int maxCount(int m, int n, int[][] ops) {
        if(ops==null || ops.length==0) return m*n;
        int min1=Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            for(int j=0;j<ops[0].length;j++){
                min1 = Math.min(ops[i][0], min1);
            }
        }
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            for(int j=0;j<ops[0].length;j++){
                min2 = Math.min(ops[i][1], min2);
            }
        }
        return min1 * min2;
    }

    public static void main(String[] args){
//        int[][] input = {
//                {2, 2}, {3, 3}
//        };
//        System.out.println(maxCount(3, 3, input));

        int[][] input = {
//                {2, 2}, {3, 3}
        };
        System.out.println(maxCount(3, 3, input));

        int[][] input3 = {
                {2, 2}, {3, 3}, {4, 5}
        };
        System.out.println(maxCount(5, 5, input3));
    }
}
