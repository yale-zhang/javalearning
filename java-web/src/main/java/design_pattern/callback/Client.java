package design_pattern.callback;

public class Client implements CSCallBack{

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    //action
    public void sendMSG(final String a,final String b){
        System.out.println("客户端:发送消息"+a+"   "+b);
        new Thread(new Runnable() {
            @Override
            public void run() {
               server.toEvaluator(Client.this::process,a, b);
            }
        }).start();
    }
    @Override
    public void process(String status) {
        System.out.println(status);
    }
}
