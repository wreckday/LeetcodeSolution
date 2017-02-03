/**
 * Created by Mellon on 1/11/17.
 */
public class QuickUnion {
    private int[] id;
    public QuickUnion(int n){
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i] = i;
        }
    }
    public int find(int p){
        while(p != id[p]){
            id[p]=id[id[p]]; // path compression
            p = id[p];  // chase parent's pointers until reach root
        }
        return p;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);   // check if p and q have same root
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        id[i] = j;   // change root of p point to root of q
    }
}
