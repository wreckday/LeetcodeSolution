import java.util.*;
import java.util.PriorityQueue;

/**
 Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 Thus, the itinerary must begin with JFK.
 Note:
 If there are multiple valid itineraries,
 you should return the itinerary that has the smallest lexical order when read as a single string.
 For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

 *
 * Created by Mellon on 4/18/17.
 */
public class ReconstructItinerary {
    static Map<String, PriorityQueue<String>> targets = new HashMap<>();
    static List<String> route = new LinkedList();

    public static List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets){
            if(targets.containsKey(ticket[0])){
                targets.get(ticket[0]).offer(ticket[1]);
            }else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.offer(ticket[1]);
                targets.put(ticket[0], pq);
            }
        }
            //targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        visit("JFK");
        return route;
    }

    private static void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }

    public static void main(String[] args){
        String[][] tickets = {
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        };

        List<String> res = findItinerary(tickets);
        Common.printStringList(res);

    }
    /*   Just Eulerian path. Greedy DFS, building the route backwards when retreating.
    Starting at the first node, we can only get stuck at the ending point,
    since every node except for the first and the last node has even number of edges,
    when we enter a node we can always get out. Now we are at the destination and if all edges are visited,
    we are done, and the dfs returns to the very first state.
    Otherwise we need to "insert" the unvisited loop into corresponding position, and in the dfs method,
    it returns to the node with extra edges, starts another recursion and adds the result before the next path.
    This process continues until all edges are visited.

    All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.
    The graph must be Eulerian since we know that a Eulerian path exists.
    Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Eulerian path in the graph
    which is a valid reconstruction.
    Since the problem asks for lexical order smallest solution,
    we can put the neighbors in a min-heap. In this way,
    we always visit the smallest possible neighbor first in our trip.
    * */
}
