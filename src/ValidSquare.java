/**
 * Created by Mellon on 5/20/17.
 */
public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // p1 - p2
        int p1_p2 = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        int p1_p3 = (p1[0]-p3[0])*(p1[0]-p3[0])+(p1[1]-p3[1])*(p1[1]-p3[1]);
        int p1_p4 = (p1[0]-p4[0])*(p1[0]-p4[0])+(p1[1]-p4[1])*(p1[1]-p4[1]);
        int p2_p3 = (p2[0]-p3[0])*(p2[0]-p3[0])+(p2[1]-p3[1])*(p2[1]-p3[1]);
        int p2_p4 = (p2[0]-p4[0])*(p2[0]-p4[0])+(p2[1]-p4[1])*(p2[1]-p4[1]);
        int p3_p4 = (p3[0]-p4[0])*(p3[0]-p4[0])+(p3[1]-p4[1])*(p3[1]-p4[1]);
        if(p1_p2==0 || p1_p3==0 || p1_p4==0 || p2_p3==0 || p2_p4==0 || p3_p4==0) return false;

        if(p1_p2>p1_p3){

            if((p1_p2==p3_p4)&&(p1_p3==p1_p4) && (p1_p3 == p2_p3) &&(p1_p3 == p2_p4) && (p1_p2==2*p1_p3)) return true;
        }else if(p1_p3>p1_p4){

            if((p1_p3==p2_p4)&&(p1_p2==p1_p4) && (p1_p2 == p2_p3) &&(p1_p2 == p3_p4) && (p1_p3==2*p1_p4)) return true;
        }else{
            if((p1_p4==p2_p3)&&(p1_p2==p1_p3) && (p1_p2 == p2_p4) &&(p1_p2 == p3_p4) && (p1_p4==2*p1_p3)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] p1 = {0, 0};
        int[] p2 = {0, 0};
        int[] p3 = {0, 0};
        int[] p4 = {0, 0};
        boolean res = validSquare(p1, p2, p3, p4);
        System.out.print(res);
    }
}
