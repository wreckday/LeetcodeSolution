/**
 * Created by Mellon on 9/11/17.
 */
public class SingletonExample {
    // purpose : this won't work since it's singleton
    //Singleton singleton = new Singleton();

    public static void main(String[] args){
        Singleton singletonService = Singleton.getService();
    }
}
