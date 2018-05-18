package httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class httpClient_1_2 {

    /** 1.2 httpclient 接口
     *
     * HttpClient 接口的实现是线程安全的。建议执行多次请求都使用该类的同一个实例。
     *
     * 该接口表示最基本的http请求执行要约
     * 保留连接管理，状态管理，认证和处理重定向的细节到各自的实现中。
     *
     * 可以使用额外的功能来装饰接口,如响应内容缓存
     * 通常 httpclient 接口的实现负债特定方面的http协议，比如重定向，身份认证处理，对连接的持久化和维持连接存活长短的决策之类的
     * 多个处理程序和决策接口实现的门面。
     *
     * 可以选择性的将一些自定义的，基于特定应用的实现来替换默认的
     */

    public void httpClientInterface() throws Exception{
        ConnectionKeepAliveStrategy keepAliveStrat  = new DefaultConnectionKeepAliveStrategy(){
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1){
                    keepAlive = 5000; //keep connections alive 5 seconds if a keep-alive value has not be explicity set by server
                }
                return keepAlive;
            }
        };
        CloseableHttpClient httpclient = HttpClients.custom().setKeepAliveStrategy(keepAliveStrat).build();
        try {

        } finally {
            //当CloseableHttpClient类的一个实例不再被调用或即将超出连接管理器关联的范围时，必须调用close方法来关闭
            httpclient.close();
        }
    }
    /**
     *  1.3 HTTP执行上下文
     *
     *  http起初被设计成一种无状态的，面向请求和响应的协议
     *
     *  实际应用需要在请求-响应切换过程中保存状态信息。
     *
     *  为了使应用能维持处理状态，httpclient允许http请求可以在一个特殊的上下文环境（HttpContext）中执行。
     *  如果一个context在连续的http请求中被复用，那么这些逻辑相关的请求可以参与到同一个逻辑回话中。
     *  一个应用程序可以在请求执行之前填充上下文属性或者在请求执行完成之后检查上下文。
     *
     *  httpcontext可以保存多个对象，因而他在多个线程共享可能并不安全。
     *  推荐每个线程维持各自的HttpContext
     *
     *  在http请求执行的过程中，httpClient向context添加了一下属性：
     *  HttpConnection 表示与目标服务器的实际连接
     *  HttpHost  表示连接的目标
     *  HttpRoute 表示连接的路由
     *  HttpRequest 表示Http请求
     *  HttpResponse 表示Http响应
     *  lang.Boolean 表示请求是否被完整的发送到目标
     *  RequestConfig 表示请求的配置
     *  List<URL> 表示在请求处理过程中接收到的一组重定向的地址集合
     *
     */

    // 使用HttpContext这个适配器类来简化操作上下文状态

    //HttpClientContext
    /**
     * 处于同一个逻辑相关的会话中多个请求应该使用同一个HttpContext实例进行处理，以此来保证会话上下文和状态信息在请求之间自动传播
     *
     */


}
