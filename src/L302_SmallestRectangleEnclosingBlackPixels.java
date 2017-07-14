/**
 An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 The black pixels are connected,
 i.e., there is only one black region. Pixels are connected horizontally and vertically.
 Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
 that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,

 Return 6.
 *
 * Created by Mellon on 2/5/17.
 */
public class L302_SmallestRectangleEnclosingBlackPixels {
    /*   the algorithm runs in O(m log n + n log m)
    top = search row [0...x], find first row contain 1,
    bottom = search row[x+1, row], find first row contain all 0
    left = search col[0...y], find first col contain 1,
    right = search col[y+1, col], find first col contain all 0
    * */
    public int minArea(char[][] image, int x, int y) {
        if(image==null || image.length==0) return 0;
        int m = image.length, n=image[0].length;
        int top = search(image, 0, x, 0, n, true, true);
        int bottom = search(image, x+1, m-1, 0, n, true, false);
        int left = search(image, 0, y, top, bottom, false, true);
        int right = search(image, y+1, n-1, top, bottom, false, false);
        return (right-left)*(bottom-top);
    }

    private int search(char[][] image, int start, int end, int min, int max, boolean searchRow, boolean findLow){
        int i=start, j=end;
        while(i<=j){
            int mid = (j-i)/2+i;
            boolean hasBlack=false;
            for(int k=min; k<max; k++){
                if((hasBlack?image[mid][k]:image[k][mid]) =='1') {
                    hasBlack=true;
                    break;
                }
            }
            if(hasBlack==findLow) j=mid-1;
            else i=mid+1;
        }
        return i;
    }
}
