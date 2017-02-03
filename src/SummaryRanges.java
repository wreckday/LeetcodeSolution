import java.util.ArrayList;
import java.util.List;

/**
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 * Created by Mellon on 10/14/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;

        List<String> result = new ArrayList<String>();

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (num != nums[i]) {
                result.add(num + "->" + nums[i]);
            } else {
                result.add(Integer.toString(num));
            }
        }

        return result;
    }
}
