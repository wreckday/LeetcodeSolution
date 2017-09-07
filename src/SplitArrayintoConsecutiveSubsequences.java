import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Mellon on 8/12/17.
 */
public class SplitArrayintoConsecutiveSubsequences {
    public static boolean isPossible(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        return dfs(list);
    }

    private static boolean dfs(List<Integer> list){
        if(list.size()==0) return true;
        int count =0;
        int pre = list.get(0);

        boolean ans1 = false;
        boolean ans2 = false;

       int i =1;
       while(i>=0){
            if(count>=3){
                List<Integer> copy = new ArrayList<>();
                copy.addAll(list);
                ans1 = dfs(copy);
                int index = list.indexOf(pre++);
                if(index>=0){
                    list.remove(index);
                    count++;
                    ans2 = dfs(list);
                }

            }else {
                int index = list.indexOf(pre++);
                if(index>=0){
                    list.remove(index);
                    count++;
                }else {
                    break;
                }
            }
        }
        return ans1 || ans2;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(isPossible(nums));
    }
}
