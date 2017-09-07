import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 *
 * https://www.youtube.com/watch?v=SwN4LgOw6mo
 * Created by Mellon on 5/22/16.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        //prerequisites[ready][pre]    [1, 0]   [2, 0]  [3, 1]  [3, 2]
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int[] pair: prerequisites){
            indegree[pair[0]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            for(int[] pair : prerequisites){
                if(pair[1]==course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]]==0){
                        queue.add(pair[0]);
                    }
                }
            }
        }
        return numCourses==0;
    }

    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        // 0....n-1
        // build a directed graph from prerequisites
        List<List<Integer>> inDegree = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            inDegree.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            inDegree.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        // start from each course and see if any cycle exists in the path
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, inDegree, visited)) return false;
        }
        return true;
    }

    // time O(V+E), space O(numCourse)
    private static boolean dfs(int course, List<List<Integer>> inDegree, int[] visited ){
        if(visited[course]==-1) return false;
        if(visited[course]==1) return true; // visit[i] == 1说明i点没有环经过，
        // 我们再遍历其他点时又遇到了i点的话，如果其值为1就直接返回true，不用再去检查i所能到达的其他点
        // 因为之前已经检查过了，相当于一种cache的方法，是很常见的优化DFS的方法。
        visited[course] = -1;
        for(Integer in: inDegree.get(course)){
            if(!dfs(in, inDegree, visited)) return false;
        }
        visited[course] = 1;
        return true;
    }

    public static void main(String[] args){
      //  canFinish(int numCourses, int[][] prerequisites)
        /*
        ->1->
      0       3
        ->2->

        */
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish1(numCourses, prerequisites));
        System.out.println(canFinishDFS(numCourses, prerequisites));
    }
}
