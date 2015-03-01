/**
 * Created by Mellon on 2/28/15.
 */
public class ContainerWithMostWater {
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
