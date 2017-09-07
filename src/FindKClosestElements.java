import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mellon on 8/12/17.
 */
public class FindKClosestElements {
    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int l=0;
        int r= arr.size()-1;
        List<Integer> res = new ArrayList<>();

        while(l<=r){
            int m = l+(r-l)/2;
            if(arr.get(m)>x){
                r = m-1;
            }else if(arr.get(m)<x){
                l = m+1;
            }else {
                r = m;
                break;
            }
        }
        int index = r;
        int index2 = r+1;
        while(k>0){
            if(index>=0&&index2<arr.size()){
                if(Math.abs(arr.get(index)-x)<=Math.abs(arr.get(index2)-x)){
                    res.add(arr.get(index));
                    index--;
                }else if(Math.abs(arr.get(index)-x)>Math.abs(arr.get(index2)-x)){
                    res.add(arr.get(index2));
                    index2++;
                }
            }else if(index2<arr.size()){
                res.add(arr.get(index2));
                index2++;
            }else {
                res.add(arr.get(index));
                index--;
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args){
        List<Integer> input= Arrays.asList(1,2,3,4,5);
        System.out.println(findClosestElements(input, 4, 3));

        List<Integer> input2= Arrays.asList(1,2,3,4,5);
        System.out.println(findClosestElements(input2, 4, 8));
    }
}
