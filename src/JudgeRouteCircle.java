/**
 * Created by Mellon on 8/12/17.
 */
public class JudgeRouteCircle {
    public static boolean judgeCircle(String moves) {
        if(moves==null || moves.length()==0) return false;
        int[] location = {0, 0};
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                location[1] += 1;
            }else if(moves.charAt(i)=='R'){
                location[0] += 1;
            }else if(moves.charAt(i)=='D'){
                location[1] -= 1;
            }else {
                location[0] -= 1;
            }
        }
        return location[0]==0&&location[1]==0;
    }

    public static void main(String[] args){
        System.out.println(judgeCircle("LL"));
    }
}
