import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * Created by Mellon on 9/18/17.
 */
public class BinaryWatch {
    // 總共只有10個bit, 把hour 當作最高位占4個bit, 把minute當作低位占6個bit
    public static List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount((h << 6) + m) == num)   // Integer.bitCount(h) + Integer.bitCount(m)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }

    //*********************************************     BACKTRACKING    ***************
    public List<String> readBinaryWatchDFS(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = {8, 4, 2, 1}, nums2 = {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for (int num1 : list1) {
                if (num1 >= 12) continue;
                for (int num2 : list2) {
                    if (num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        int num = 2;
        System.out.println(readBinaryWatch(num));
    }
}
