/**
 * Created by Mellon on 2/28/15.
 *
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    //时间复杂度为O(n),空间复杂度是O(1)
    public int maxArea(int[] height) {
        //十分夾逼法
        // 不要誤會題目的意思  是和X軸形成container
        if(height==null || height.length==0)
            return 0;

        int l=0;
        int r= height.length-1;
        int maxArea = 0;

        while(l<r){
            maxArea = Math.max(maxArea, Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
