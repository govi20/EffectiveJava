package item;

public class Client {
    public static void main(String[] args) {
        CustomDate today = CustomDate.today ();
        System.out.println (today);
        CustomDate yesterday = CustomDate.yesterday ();
        System.out.println (yesterday);
        CustomDate tomorrow = CustomDate.tomorrow ();
        System.out.println (tomorrow);
    }
}
