/**
 * Created by Mellon on 10/1/16.
 */
public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int k = 0;
        if(abbr.length()==1&&isDigit(abbr.charAt(0))&&abbr.charAt(0)-'0'!=word.length()) return false;

        while(true){
            if(word.length()==i&&k==abbr.length()) return true;

            if(k<abbr.length()&&isDigit(abbr.charAt(k))){
                int j = 0;
                int result = 0;
                while(k<abbr.length()&&isDigit(abbr.charAt(k))){
                    result = result*10;
                    result = result + Integer.parseInt(abbr.charAt(k)+"");
                    if(j==0&&result==0){
                        return false;
                    }
                    k = k+1;
                    j++;
                }
                i = i+result;
            }else{
                if(k<abbr.length()&&i<word.length()&&abbr.charAt(k)==word.charAt(i)){
                    i++;k++;
                }else{
                    return false;
                }
            }
        }
    }

    private static boolean isDigit(char c){
        if(c>='0'&&c<='9')
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "a", abbr = "01";
        System.out.print(validWordAbbreviation(s, abbr));
    }
}
