/**
 Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent,
 with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 *
 * Created by Mellon on 8/27/16.
 */
public class SortColors {
    // there are two ways 1. count sort 2.two pointers

    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        // the left elements of redIndex are all red, the right elements of blueIndex are all blue
        int redIndex = 0;
        int blueIndex = A.length - 1;
        int i = 0;

        while (i <= blueIndex) {
            if (A[i] == 0) {
                swap(A, redIndex, i);
                i++;
                redIndex++;
            } else if (A[i] == 1) {
                i++;
            } else {
                // be careful: no need to i++
                swap(A, blueIndex, i);
                blueIndex--;
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
