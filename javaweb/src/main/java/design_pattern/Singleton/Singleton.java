package design_pattern.Singleton;

public class Singleton {
    /*private volatile static Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {
        //single checked
        if (instance == null) {
            synchronized (Singleton.class) {
                //double checked
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }*/
    //static final field
    //static nested class
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

