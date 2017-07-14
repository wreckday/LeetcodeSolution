import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mellon on 2/18/17.
 */
public class BeautifulArrangement {
    private static int count = 0;
    public static int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        helper(N, visited, new ArrayList<>());
        return count;
    }

    private static void helper(int N, boolean[] visited, List<Integer> items){
        if(items.size()==N) {
            count ++;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                items.add(i + 1);
                if( (i+1) % items.size() ==0 || items.size() % (i+1)  == 0){
                    helper(N, visited, items);
                }
                items.remove(items.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(1));
    }
}
