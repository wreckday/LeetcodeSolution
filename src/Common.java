import java.util.List;

/**
 * Created by Mellon on 5/10/16.
 */
public final class Common extends Object{
    public static void printNestedList(List<List<Integer>> res){
        for(List<Integer> integerList: res){
            System.out.print("[");
            for(int i=0;i<integerList.size();i++){
                System.out.print(integerList.get(i));
                if(i<integerList.size()-1)
                    System.out.print(", ");
            }

            System.out.println("]");
        }
    }

    public static void printIntegerList(List<Integer> integerList){
            System.out.print("[");
            for(int i=0;i<integerList.size();i++){
                System.out.print(integerList.get(i));
                if(i<integerList.size()-1)
                    System.out.print(", ");
            }

            System.out.println("]");
    }

    public static void printNestedStringList(List<List<String>> res){
        for(List<String> integerList: res){
            System.out.print("[");
            for(int i=0;i<integerList.size();i++){
                System.out.print(integerList.get(i));
                if(i<integerList.size()-1)
                    System.out.print(", ");
            }

            System.out.println("]");
        }
    }

    public static void printStringList(List<String> integerList){
        System.out.print("[");
        for(int i=0;i<integerList.size();i++){
            System.out.print(integerList.get(i));
            if(i<integerList.size()-1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

    public static void printIntegerArray(int[] integerList){
        System.out.print("[");
        for(int i=0;i<integerList.length;i++){
            System.out.print(integerList[i]);
            if(i<integerList.length-1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

}
