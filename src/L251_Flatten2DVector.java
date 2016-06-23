import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
    [1,2],
    [3],
    [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,2,3,4,5,6].
 *
 * Created by Mellon on 5/27/16.
 */
public class L251_Flatten2DVector {
    public static void main(String[] args){
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> l1= new ArrayList<>();
        l1.add(-1);
//        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        //l2.add(3);
        List<Integer> l3 = new ArrayList<>();
//        l3.add(4);
//        l3.add(5);
        //l3.add(6);
//        List<Integer> l4 = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);
//        input.add(l4);

        Vector2D i = new Vector2D(input);
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }
}
/*
class Vector2D implements Iterator<Integer> {
    int indexList, indexEle;
    List<List<Integer>> vec;

    public Vector2D(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }
    @Override
    public Integer next() {
        int val =  vec.get(indexList).get(indexEle);
        indexEle++;
        return val;
    }
    @Override
    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
*/
class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}
