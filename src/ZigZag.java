/**
 * Created by Mellon on 1/17/15.
 */
public class ZigZag {

    public static String convert(String s, int nRows) {
        if(s == null || s.length()==0)
            return null;
        if(s.length() <= nRows)
            return s;

        StringBuilder res = new StringBuilder();
        int step = 2 * nRows -2;

        for(int i=0;i<nRows;i++)
        {
            if(i==0 || i==nRows-1)
            {
                for(int j=i;j<s.length();j=j+step)
                {
                    res.append(s.charAt(j));
                }
            }
            else
            {
                int j = i;
                boolean flag = false;
                int step1 = 2*(nRows-j)-2;
                int step2 = step-step1;
                while(j<s.length())
                {
                    res.append(s.charAt(j));
                    if(flag){
                       j=j+step2;
                       flag=false;
                    }else{
                       j=j+step1;
                       flag=true;
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(convert("ABC",3));
    }
}
