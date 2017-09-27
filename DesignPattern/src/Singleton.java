/**
 * Created by Mellon on 9/11/17.
 */
public class Singleton {
    // the variable should be static
    private static Singleton service;

    // should be private to not allow initiate by constructor
    private Singleton (){

    }

    // the getSingleton method should be static
    public static Singleton getService(){
        if(service == null) return new Singleton();

        return service;
    }
}
