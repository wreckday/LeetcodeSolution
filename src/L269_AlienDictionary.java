import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 *
 * Derive the order of letters in this language.

 For example,
 Given the following words in dictionary,

 [
    "wrt",
    "wrf",
    "er",
    "ett",
    "rftt"
 ]
 The correct order is: "wertf".

 Note:
 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 * Created by Mellon on 5/22/16.
 */
public class L269_AlienDictionary {
    public static String alienOrder(String[] words) {
        // build graph
        Map<Character, Set<Character>> map=new HashMap<>(); // Map<cur, next nodes set>   The characters in set come after the key.
        Map<Character, Integer> degree=new HashMap<>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        // topological sort
        Queue<Character> q=new LinkedList<>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
/*
The key to this problem is:

A topological ordering is possible if and only if the graph has no directed cycles
Let's build a graph and perform a DFS. The following states made things easier.

visited[i] = -1. Not even exist.
visited[i] = 0. Exist. Non-visited.
visited[i] = 1. Visiting.
visited[i] = 2. Visited.
* */
    private static final int N = 26;
    public static String alienOrderDFS(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph2(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public static boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public static void buildGraph2(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

 /*
    The description said the words are sorted lexicographically, not the individual letters. As an example, consider these words from the English dictionary:

    game,
    zebra,
    zoo
    See? The word zoo doesn't imply the ordering z < o.
*/
    public static void main(String[] args){
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words1 = {"z", "z"};
        String[] words2 = {"wrt", "tas", "was"};
        String sortResult = alienOrder(words2);
        System.out.println(sortResult);
    }
}
