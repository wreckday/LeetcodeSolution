import java.util.*;

/**
 * Created by Mellon on 2/8/15.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] S) {
        //error check
        if(S==null)
            return null;
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);

        for(int n=0;n<S.length;n++){
            int count = res.size();
            for(int i=0;i<count;i++){
                List<Integer> elem = new ArrayList<Integer>(res.get(i));
                elem.add(S[n]);
                res.add(elem);

            }
        }

        return res;
    }

    public static List<List<Integer>> subsetsWithDup(int[] num) {
        // error check
        if(num==null)
            return null;
        // sort array
        Arrays.sort(num);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);

        int last = 1;
        int current = last;

        for(int i=0;i<num.length;i++){
            int count = res.size();

            if(i>0&&num[i]==num[i-1]){

                for(int j=last;j<count;j++){

                    List<Integer> cur = new ArrayList<Integer>(res.get(j));
                    cur.add(num[i]);
                    res.add(cur);
                }

            }else
            {
                for(int j=0;j<count;j++){

                    List<Integer> cur = new ArrayList<Integer>(res.get(j));
                    cur.add(num[i]);
                    res.add(cur);
                }
            }

            last = current;
            current = res.size();
        }
        return res;
    }

    public static List<List<Integer>> subsetBits(int[] nums) {
        //error check
        if(nums==null)
            return null;

        // sort array
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int bit = 2<<(nums.length-1);

        for(int i=0;i<bit;i++){
            List<Integer> item = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i>>j&1)==1){
                    item.add(nums[j]);
                }
            }
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args){
        int[] a = {1,2,3};
        printArrayListList(subsets(a));
        System.out.println();
        List<List<Integer>> res2 = subsetBits(a);
        printArrayListList(res2);

    }

    private static void printArrayListList(List<List<Integer>> res){
        for(List<Integer> list : res){
            System.out.print("[");
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.print("]");
        }
    }


}
