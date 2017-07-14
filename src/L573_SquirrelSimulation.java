/**
 There's a tree, a squirrel, and several nuts.
 Positions are represented by the cells in a 2D grid.
 Your goal is to find the minimal distance for the squirrel
 to collect all the nuts and put them under the tree one by one.

 The squirrel can only take at most one nut at one time
 and can move in four directions - up, down, left and right, to the adjacent cell.
 The distance is represented by the number of moves.

 *
 * Created by Mellon on 5/10/17.
 */
public class L573_SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0, maxDiff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            // distance between tree and nut i
            int dist = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            sum += 2*dist;
            // distance between squirrel and nut i
            int dist2 = Math.abs(squirrel[0] - nut[0]) + Math.abs(squirrel[1] - nut[1]);
            maxDiff = Math.max(maxDiff, dist - dist2);
        }
        return sum - maxDiff;
    }
    /*
    Proof:
    Let the minimum distance from each nut to the tree be a_1, ..., a_n
    and let the minimum distance from each nut to the initial squirrel position be b_1, ..., b_n.
    Note that the minimum distance between two positions in the matrix is determined by their Manhattan distance.

    Then, if the squirrel were to start at the tree,
    then the minimum total distance required to collect all the nuts is 2a_1 + ... + 2a_n.
    However, since the squirrel starts elsewhere,
    we just need to substitute one of the 2a_i terms with a_i + b_i.
    Or equivalently, we replace one of the a_i terms in the sum with b_i.
    To minimize the total sum value at the end, we choose i that maximizes a_i - b_i.
    想像松鼠站在樹上時, 距離為樹到各個栗子距離乘二, 2(a1+a2+a3)。
    現在松鼠在別地方, 所以距離為松鼠到某一顆栗子的距離+那顆栗子到樹的距離 ＋ 2(a2+a3)
    同等於這個公式(a1+b1)+a2+a2+a3+a3  = a1+a1+a2+a2+a3+a3 - (a1-b1)
    find the maximum ai-bi, so the sum will be shortest path.
    * */
}
