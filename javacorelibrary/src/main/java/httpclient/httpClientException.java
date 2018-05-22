package httpclient;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

public class httpClientException {

    /**
     *  HTTP 传输安全
     *  HTTP协议并不适用于所有类型的应用程序。
     *  HTTP是一个简单的面相request/response的协议，它的设计初衷是为了支持静态或动态地生成内容检索。
     *
     *  不支持事务
     *  比如，当HTTP服务器成功地接收并处理了客户端发送的请求，生成相应并发送回状态码，那么它会就认为完成了约定的内容。
     *  如果由于读超时，请求取消或者系统崩溃等原因导致客户端无法成功接收到响应，那么服务器不会试图去回滚事务。如果客户端决定重试相同的请求,服务器最终将不可避免地多次执行相同的事务。
     *  在某些情况下，这有可能导致应用程序的数据污染或状态不一致。
     *
     *   尽管HTTP从未被设计成支持事务处理，但是它仍然可以作为一种在特定条件下满足特殊任务的传输协议。
     *   为了保证HTTP传输层的安全性，系统必须保证应用层中的HTTP方法是幂等的。
     */

    /**
     * 幂等方法
     *
     * HTTP/1.1规范定义了一个幂等方法[N > 0 的多次请求同单次请求产生的效果一样（除了错误或过期问题），这样的方法具有“幂等性”的性质]。
     *
     *异常自动恢复

     默认情况下HttpClient尝试从I/O exception中自动恢复。默认的自动恢复机制只局限于少数已知的安全的异常。

     HttpClient不会试图从任何逻辑或HTTP协议错误(衍生自HttpException类)中恢复。
     HttpClient将自动重试那些被认为是等幂的方法。
     HttpClient将自动重试那些因传输异常而失败但是HTTP请求仍然会被发送到目标服务器的方法。（即请求还没有完全被发送到服务器端）
     */

    /**
     * 请求重试
     * 为了使自定义异常恢复机制有效，实现了HttpRequestRetryHandler接口。
     */
    public void RetryHandler() throws Exception{
        HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler(){
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= 5) {
                // Do not retry if over max retry count
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                // Timeout
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                // Unknown host
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {
                // Connection refused
                    return false;
                }
                if (exception instanceof SSLException) {
                // SSL handshake exception
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent) {
                // Retry if the request is considered idempotent
                    return true;
                }
                return false;
            }
        };
        CloseableHttpClient httpclient = HttpClients.custom()
                .setRetryHandler(myRetryHandler)
                .build();

        //为了处理安全自动的重试RFC-2616协议中定义的请求方法GET，HEAD，PUT，DELETE，OPTIONS和TRACE，
        // 可以用StandardHttpRequestRetryHandler代替使用默认的。

        //中止请求
        /**
         * 在某些情况下，由于服务器端的高负载或者客户端存在过多的并发请求问题，HTTP请求不能在预期时间内执行完毕。
         * 需要提前中止请求并开启阻塞在I/O操作的线程。
         *
         * 通过HttpUriRequest#abort()方法，可以在任何阶段中止由HttpClient执行的HTTP请求。
         */
    }
}
