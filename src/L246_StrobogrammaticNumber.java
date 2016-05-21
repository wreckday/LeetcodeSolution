/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 * Created by Mellon on 5/17/16.
 */
public class L246_StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        int l=0;
        int r=num.length()-1;

        while(l<=r){

            if(num.charAt(l)-'0'==0 && num.charAt(r)-'0'==0
                    || num.charAt(l)-'0'==1 && num.charAt(r)-'0'==1
                    || num.charAt(l)-'0'==8 && num.charAt(r)-'0'==8){
                l++;r--;
            }
            else if(num.charAt(l)-'0'==6 && num.charAt(r)-'0'==9 || num.charAt(l)-'0'==9 && num.charAt(r)-'0'==6){
                l++; r--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("101"));
    }
}
