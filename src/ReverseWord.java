/**
 * Created by Hsiang-Ting Yang on 5/30/15.
 */
public class ReverseWord {
    public static String reverseWords2(String s) {
        s = s.trim();
        if(s.equals("")) return s;
        StringBuilder newStr = new StringBuilder();

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i+1)!=' '||s.charAt(i)!=' ')
                newStr.append(s.charAt(i));
        }

        if(s.charAt(s.length()-1)!= ' ')
            newStr.append(s.charAt(s.length()-1));

        String s1 = reverseHelper(newStr.toString());
        String[] arr = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String e:arr){
            sb.append(reverseHelper(e));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static String reverseHelper(String str){
        char[] a = str.toCharArray();
        int l=0;
        int r= str.length()-1;
        char temp = ' ';
        while(l<r){
            temp = a[r];
            a[r] = a[l];
            a[l]=temp;
            l++;
            r--;
        }
        return new String(a);
    }

    public static String reverseWords(String s) {
        if(s==null) return null;
        s = s.trim();
        if(s.length()==0) return "";

        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(i!=s.length()-1 && s.charAt(i) ==' ' && s.charAt(i+1) ==' ')
                continue;
            res.append(s.charAt(i));
        }
        s = res.toString();
        String[] a = s.split(" ");
        String result ="";
        for(int i = a.length-1; i>-1; i--){
            result = result + a[i];

            if(i!=0)
                result = result + " ";
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(reverseWords("hello word"));
    }
}
