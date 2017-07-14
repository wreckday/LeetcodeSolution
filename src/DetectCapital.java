/**
 * Created by Mellon on 2/18/17.
 */
public class DetectCapital {
    public boolean detectCapitalUseRex(String word) {
        return word.matches("[A-Z]*") || word.matches("[A-Z]?[a-z]+");
    }
    public static boolean detectCapitalUse(String word) {
        if(word == null || word.length()==0) return false;
        boolean allCapital = true;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a'&&word.charAt(i)<='z'){
                allCapital = false;
            }
        }

        if(allCapital) return true;

        boolean isCapital = true;
        if(word.charAt(0)>='A'&&word.charAt(0)<='Z'){
            for(int i=1;i<word.length();i++){
                if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                    isCapital = false;
                }
            }
        } else{
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                    isCapital = false;
                }
            }
        }

        return isCapital;
    }

    public boolean detectCapitalUse2(String word) {
        int capitalCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCount++;
            }
        }
        if (capitalCount == word.length()) {
            return true;
        }
        if (capitalCount == 0) {
            return true;
        }
        if (capitalCount == 1 && Character.isUpperCase(word.charAt(0)) && word.length() > 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("FlAg"));
    }
}
