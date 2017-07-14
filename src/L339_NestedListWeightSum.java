/**
 * Created by Mellon on 4/7/16.
 *
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

 Example 2:
 Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */


import java.util.ArrayList;
import java.util.List;

/**
* // This is the interface that allows for creating nested lists.
* // You should not implement it, or speculate about its implementation
* public interface NestedInteger {
*
*     // @return true if this NestedInteger holds a single integer, rather than a nested list.
*     public boolean isInteger();
*
*     // @return the single integer that this NestedInteger holds, if it holds a single integer
*     // Return null if this NestedInteger holds a nested list
*     public Integer getInteger();
*
*     // @return the nested list that this NestedInteger holds, if it holds a nested list
*     // Return null if this NestedInteger holds a single integer
*     public List<NestedInteger> getList();
* }
*/
public class L339_NestedListWeightSum {
    static int sum=0;

    public int depthSum(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return sum;
    }

    private void helper(List<NestedInteger> nestedList, int level){

        for(int i=0;i<nestedList.size();i++){
            if(!nestedList.get(i).isInteger()){
                helper(nestedList.get(i).getList(), level+1);
            }else{
                sum = sum + nestedList.get(i).getInteger()*level;
            }
        }
    }
}

 class NestedInteger {
    public boolean isInteger(){
        return true;
    };
    public Integer getInteger(){
        return 3;
    }
    public List<NestedInteger> getList(){
        return new ArrayList<>();
    }
}
/*
* The algorithm takes O(N) time,
* where N is the total number of nested elements in the input list.
* For example, the list [ [[[[1]]]], 2 ] contains 4 nested lists and 2 nested integers (1 and 2), so N=6.

In terms of space, at most O(D) recursive calls are placed on the stack,
where D is the maximum level of nesting in the input.
For example, D=2 for the input [[1,1],2,[1,1]], and D=3 for the input [1,[4,[6]]].
* */