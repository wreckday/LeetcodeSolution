import java.util.Arrays;

/**
 * Created by Mellon on 2/7/15.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int closest = num[0]+num[1]+num[num.length-1];

        for(int i=0;i<num.length;i++){
            if(i>0&&num[i]==num[i-1]){
                continue;
            }
            int start = i+1;
            int end = num.length-1;

            while(start<end){
                int sum = num[i]+num[start]+num[end];
                if(sum==target)
                    return sum;

                if( Math.abs(target-sum) < Math.abs(closest)){
                    closest = sum;
                    if(target-sum>0)
                        end--;
                    else if(target-sum<0)
                        start++;
                    else
                        return target;

                }else if (Math.abs(target-sum) > Math.abs(closest)){
                    if(target-sum>0)
                        end--;
                    else if(target-sum<0)
                        start++;
                    else
                        return target;
                }else{
                    do{
                        start++;
                    }while(start<end&&num[start]==num[start-1]);

                    do{
                        end--;
                    }while(start<end&&num[end]==num[end+1]);
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,1};
        int target = 4;
        System.out.println(threeSumClosest(num, target));
    }
}
