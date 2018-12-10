package httpclient;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

import java.net.URI;
import java.util.List;

public class redirectHandling {
    /**
     *  重定向
     *  HttpClient能够处理所有类型的自动重定向，除了被那些需要用户干预被HTTP规范明确禁止的。
     *
     *  考虑到根据HTTP规范中其他被转为GET请求的POST和PUT请求的重定向（状态码303），
     *
     */

    public void httpClientRedirect() throws Exception{
        //可以使用一个自定义的重定向策略来降低HTTP规范强制规定的POST方法自动重定向的限制。
        /*LaxRedirectStrategy strategy = new LaxRedirectStrategy();
        HttpClients.custom()
                .setRedirectStrategy(strategy)
                .build();*/

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        HttpGet httpget = new HttpGet("http://localhost:8080/");
        CloseableHttpResponse response = httpClient.execute(httpget, context);
        //默认地，HTTP/1.0、HTTP/1.1通常使用相对请求URIs。同样，原始请求可以被重定向到其他位置。
        try {
            HttpHost target = context.getTargetHost();
            List<URI> redirectLocations = context.getRedirectLocations();
            //用公共方法URIUtils#resolve构建生成最终请求的解释绝对URI。
            URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
            System.out.println("Final HTTP location: " + location.toASCIIString());
            // Expected to be an absolute URI
        } finally {
            response.close();
        }
    }
}
