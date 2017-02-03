import java.util.HashMap;

/**
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by Mellon on 8/18/16.
 */
public class IntegertoRoman {
    public static String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(symbols[i]);
                num = num-values[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(intToRoman(3999));


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 2);

        map.forEach((k, v) -> {
            if (k == 1)
                System.out.println("value :" + v);
        });
    }
}
