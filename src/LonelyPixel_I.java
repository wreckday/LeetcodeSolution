import java.util.*;
/**
 Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

 Example:
 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.
 Note:
 The range of width and height of the input 2D array is [1,500].
 *
 * Created by Mellon on 3/5/17.
 */
public class LonelyPixel_I {
    public static int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && isValid(picture, i, j, m, n)) res = res + 1;
            }

        }
        return res;
    }

    private static boolean isValid(char[][] picture, int row, int col, int m, int n){

        for(int i = row+1;i<m;i++){
            if(picture[i][col] == 'B') return false;
        }

        for(int i=row-1;i>=0;i--){
            if(picture[i][col] == 'B') return false;
        }

        for(int i = col+1;i<n;i++){
            if(picture[row][i] == 'B') return false;
        }

        for(int i = col-1;i>=0;i--){
            if(picture[row][i] == 'B') return false;
        }
        return true;
    }




    public static void main(String[] args){
        char[][] matrix = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        System.out.println(findLonelyPixel(matrix));
    }
}
