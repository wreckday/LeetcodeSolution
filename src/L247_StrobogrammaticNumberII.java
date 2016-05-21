//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Find all strobogrammatic numbers that are of length = n.
//
// For example,
// Given n = 2, return ["11","69","88","96"].
// *
// * Created by Mellon on 5/17/16.
// */
//public class L247_StrobogrammaticNumberII {
//    public static List<String> findStrobogrammatic(int n) {
//        char[] candidates = {'0', '1', '6', '8', '9'};
//        List<String> res = new ArrayList<>();
//        helper(n, candidates, new StringBuilder(), res);
//        return res;
//    }
//
//    private static void helper(int n, char[] candidates, StringBuilder sb, List<String> res){
//        // base case
//        String str = sb.toString();
//        if(str.length()>=n/2 && str.length()%2==0) {
//            if (str.length() == n / 2) {
//                // generate other half
//                if (isStrobogrammatic(generate(str))) {
//                    res.add(str);
//                }
//            }
//
//            return;
//        }
//
//        for(int i=0;i<candidates.length;i++){
//            sb.append(candidates[i]);
//            helper(n, candidates, sb, res);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
//
//    private static boolean isStrobogrammatic(String num) {
//        if(num == null || num.length()==0) return false;
//        int l=0;
//        int r=num.length()-1;
//
//
//        if(num.charAt(0)=='0')
//            return false;
//
//        while(l<=r){
//
//            if(num.charAt(l)-'0'==0 && num.charAt(r)-'0'==0
//                    || num.charAt(l)-'0'==1 && num.charAt(r)-'0'==1
//                    || num.charAt(l)-'0'==8 && num.charAt(r)-'0'==8){
//                l++;r--;
//            }
//            else if(num.charAt(l)-'0'==6 && num.charAt(r)-'0'==9 || num.charAt(l)-'0'==9 && num.charAt(r)-'0'==6){
//                l++; r--;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static String generate(String str){
//
//    }
//
//    public static void main(String[] args){
//        List<String> res = findStrobogrammatic(4);
//        Common.printStringList(res);
//    }
//}
