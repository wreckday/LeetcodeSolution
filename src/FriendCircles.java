/**
 There are N students in a class. Some of them are friends, while some are not.
 Their friendship is transitive in nature.
 For example, if A is a direct friend of B, and B is a direct friend of C,
 then A is an indirect friend of C.
 And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class.
 If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.


 Example 2:
 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.

 *
 * Created by Mellon on 4/6/17.
 */
public class FriendCircles {
    public static int findCircleNum(int[][] M) {
        int circle = M.length;
        int[] roots = new int[M.length];
        for(int i=0;i<roots.length;i++){
            roots[i] = i;
        }
        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M.length;j++){
                if(M[i][j] == 1){
                    int root1 = find(i, roots);
                    int root2 = find(j, roots);
                    if(root1 != root2) {
                        roots[root1] = root2; // union
                        circle--;
                    }

                }
            }
        }
        return circle<=0?1:circle;
    }

    private static int find(int id, int[] roots){
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }

    public static void main(String[] args){
        int[][] friends = {{1,1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] friends2 = {{1,1, 0}, {1,1,0}, {0, 0, 1}};
        int[][] friends3 = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] friends4 = {
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}
        };
//        System.out.println(findCircleNum(friends));
//        System.out.println(findCircleNum(friends2));
//        System.out.println(findCircleNum(friends3));
        System.out.println(findCircleNum(friends4));
    }
}
