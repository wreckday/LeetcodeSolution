import java.util.*;

/**
 * Created by Mellon on 5/22/16.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();
            res[index++] = course;
            for(int[] pair : prerequisites){
                if(pair[1]==course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]]==0){
                        queue.add(pair[0]);
                    }
                }
            }
        }

        if(numCourses==0){
            return res;
        }
        return new int[0];
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


        // 1->0
        int numCourses1 = 2;
        int[][] prerequisites1 = {{0,1}};

        //Common.printIntegerArray(findOrder(numCourses, prerequisites));
        Common.printIntegerArray(findOrder(numCourses1, prerequisites1));
    }
}
