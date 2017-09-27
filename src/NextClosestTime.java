import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mellon on 9/23/17.
 */
public class NextClosestTime {
    public static String nextClosestTime(String time) {
        List<Integer> item = new ArrayList<>();
        for(int i = 0;i<time.length();i++){
            if(time.charAt(i)==':') continue;
            if(!item.contains(time.charAt(i)-'0')){
                item.add(time.charAt(i)-'0');
            }
        }

        Collections.sort(item);
        for(int i = time.length()-1;i>=0;i--){
            if(time.charAt(i)==':') continue;
            int index = item.indexOf(time.charAt(i)-'0');
            for(int j = index + 1;j<item.size();j++ ){
                int cur = item.get(j);
                if(cur != time.charAt(i)-'0'){
                    char[] charArray = time.toCharArray();
                    charArray[i] = (char) (cur + '0');
                    if(isValid(new String(charArray))){
                        for(int k=i+1;k<time.length();k++){
                            if(time.charAt(k)==':') continue;
                            charArray[k] = (char) (item.get(0)+'0');
                        }
                        return new String(charArray);
                    }else {
                        continue;
                    }
                }else{
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(time.charAt(0));
        sb.append(time.charAt(0));
        sb.append(':');
        sb.append(time.charAt(0));
        sb.append(time.charAt(0));
        return sb.toString();
    }

    public static boolean isValid(String time){
        String hour = time.substring(0, 2);
        String minute = time.substring(3);
        if(Integer.parseInt(hour)>=0 && Integer.parseInt(hour)<=23
                && Integer.parseInt(minute)>=0 && Integer.parseInt(minute)<=59 ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String time1 = "13:55";
        System.out.println(nextClosestTime(time1));
    }
}
