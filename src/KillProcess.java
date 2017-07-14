import java.util.*;

/**
 Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

 Each process only has one parent process, but may have one or more children processes.
 This is just like a tree structure. Only one process has PPID that is 0,
 which means this process has no parent process. All the PIDs will be distinct positive integers.

 We use two list of integers to represent a list of processes,
 where the first list contains PID for each process and the second list contains the corresponding PPID.

 Now given the two lists, and a PID representing a process you want to kill,
 return a list of PIDs of processes that will be killed in the end.
 You should assume that when a process is killed,
 all its children processes will be killed. No order is required for the final answer.

 Example 1:
 Input:
 pid =  [1, 3, 10, 5]
 ppid = [3, 0, 5, 3]
 kill = 5
 Output: [5,10]
 Explanation:
     3
   /  \
  1    5
      /
     10
 Kill 5 will also kill 10.
 Note:
 The given kill id is guaranteed to be one of the given PIDs.
 n >= 1.
 *
 * Created by Mellon on 5/13/17.
 */
public class KillProcess {
    public List<Integer> killProcessDFS(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> l=new ArrayList<>();
        if(kill==0)
            return l;
        l.add(kill);
        for(int i=0;i<ppid.size();i++)
            if(ppid.get(i)==kill)
                l.addAll(killProcess(pid,ppid,pid.get(i)));
        return l;
    }


    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<ppid.size();i++){
            if(map.containsKey(ppid.get(i))){
                map.get(ppid.get(i)).add(pid.get(i));
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(pid.get(i));
                map.put(ppid.get(i), temp);
            }
        }
        List<Integer> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            res.add(parent);
            List<Integer> child = map.get(parent);
            if(child!=null)
                queue.addAll(child);
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        List<Integer> res = killProcess(pid, ppid, 5);
        Common.printIntegerList(res);
    }
}
