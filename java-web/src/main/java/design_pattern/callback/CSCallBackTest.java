package design_pattern.callback;

public class CSCallBackTest {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMSG("1","2");
    }
}
