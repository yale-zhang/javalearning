package httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpUtil {
    /**
     * 执行一个HTTP GET请求，返回请求响应的HTML
     *
     * @param url                 请求的URL地址
     * @param queryString 请求的查询参数,可以为null
     * @return 返回请求响应的HTML
     */
    public static String doGet(String url,String path, String queryString) throws Exception{
        CloseableHttpClient httpclient  = HttpClients.createDefault();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URI uriParam = new URIBuilder().build();
            if (StringUtils.isNotBlank(queryString)){
                URLEncodedUtils.parse(queryString, Consts.UTF_8);
                uriParam = new URIBuilder()
                        .setScheme("http")
                        .setHost(url)
                        .setPath(path)
                        .setCustomQuery(queryString)
                        .build();
            }
            HttpGet method = new HttpGet();
            method.setURI(uriParam);
            CloseableHttpResponse response =  httpclient.execute(method);
            HttpEntity entity = response.getEntity();
            entity.writeTo(baos);
            baos.close();
            response.close();
        } catch (URISyntaxException e) {
            //LOG.error("执行Http GET 请求时，编码查询字符“"+queryString+"”发生异常!",e);
        } catch (IOException e) {
            //LOG.error("执行HTTP Get请求" + url + "时，发生异常！", e);
        }
        return new String(baos.toByteArray(),Consts.UTF_8);
    }
}
