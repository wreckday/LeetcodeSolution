import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mellon on 11/8/15.
 */
public class BullsandCows {
    public static String getHint(String secret, String guess) {
        Map<Integer, Integer> secret_table = new HashMap<Integer, Integer>();
        Map<Integer, Integer> quess_table = new HashMap<Integer, Integer>();
        for(int i=0;i<secret.length();i++){
            if(secret_table.containsKey((int)secret.charAt(i))){
                secret_table.put((int)secret.charAt(i), secret_table.get((int)secret.charAt(i))+1);
            }else{
                secret_table.put((int)secret.charAt(i), 1);
            }
        }

        for(int i=0;i<guess.length();i++){
            if(quess_table.containsKey((int)guess.charAt(i))){
                quess_table.put((int)guess.charAt(i), quess_table.get((int)guess.charAt(i))+1);
            }else{
                quess_table.put((int)guess.charAt(i), 1);
            }
        }

        int sum = 0;
        for(Integer e : quess_table.keySet()){
            if(secret_table.containsKey(e)){
                sum = sum + Math.min((int)quess_table.get(e), (int)secret_table.get(e));
            }
        }

        int a = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i))
                a++;
        }
        int b = sum-a;
        return a + "A" + b + "B";

    }

    public static void main(String[] args){
        String secret = "1234";
        String guess = "3214";
        String hint = getHint(secret, guess);
        System.out.println(hint);

    }

}
