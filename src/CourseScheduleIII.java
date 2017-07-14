import java.util.Arrays;
import java.util.PriorityQueue;

/**
 There are n different online courses numbered from 1 to n.
 Each course has some duration(course length) t and closed on dth day.

 A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.

 Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 *
 * Created by Mellon on 6/24/17.
 */
public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        // sort by end date
        Arrays.sort(courses, (a, b)->a[1]-b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = courses.length;
        int time = 0;
        for(int i = 0;i < n;i++){
            int[] c = courses[i];
            time += c[0];
            pq.add(-c[0]);
            while(time > c[1]){ // when total time greater than end date
                time += pq.poll();  // remove the longest course (e.g. "-1000", -500, -100)
            }
        }
        return pq.size();
    }

    public static void main(String[] args){
        int[][] courses = {
                {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
        };

        scheduleCourse(courses);
    }
}
