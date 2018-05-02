package design_pattern.Singleton;

public class main {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.err.print(instance.hashCode());// hashCode:1846274136
        //design_pattern.Singleton.Singleton@6e0be858
    }
}
