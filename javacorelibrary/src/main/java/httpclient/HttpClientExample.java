package httpclient;


import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class HttpClientExample {
    //1.1 执行请求

    public static void httpclient() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //生成内容实体
        File file = new File("someone.txt");
        /**
         * HttpClient提供了一些可以通过 HTTP 连接来高效地流出内容的类。 这些类的实例可以与封闭像 POST 和 PUT请求的实体相关联，
         使得实体内容装入流出的HTTP 请求。
          StringEntity,ByteArrayEntity,InputStreamEntity,FileEntity.(InputStreamEntity是不可重复的，仅能从底层数据流读取一次内容)

        FileEntity fileEntity = new FileEntity(file, ContentType.create("text/plain", "UTF-8"));*/
        /**
         * html表单
         *
         * #许多应用程序需要模拟一个提交 HTML 表单的过程
         * 例如，登录web应用或提交数据。
         * HttpClient 提供了实体类UrlEncodedFormEntity来使这个过程变得容易.
         */
        ArrayList<NameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("param1","value1"));
        formparams.add(new BasicNameValuePair("param2","value2"));
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

        /**
         * 内容分快 / 当使用的HTTP协议不支持块编码，比如使用HTTP/1.0协议时，这个值就会被忽略。
         *
         * 开始传输前，通常建议让 HttpClient 选择基于HTTP消息属性的最适当的传输编码方式。
         不过当设置HttpEntity#setChunked()方法为true时，通知HttpClient该块编码是首选。
         */
        StringEntity stringEntity = new StringEntity("important message", ContentType.create("plain/text", Consts.UTF_8));
        stringEntity.setChunked(true);
        //HttpGet httpentity  = new HttpGet("http://localhost/");
        HttpPost httpentity  = new HttpPost("http://localhost/action.do");
        httpentity.setEntity(stringEntity);
        //  执行请求
        CloseableHttpResponse response = httpclient.execute(httpentity);
        try {
            HttpEntity entity = response.getEntity();
            if(entity!=null){
                long len = entity.getContentLength();
                if (len != -1 && len < 2048) {
                    //HttpClient 配置了entityutils类从实体中获取内容或信息,
                    //但只有在响应实体来自受信任的http服务器和长度是已知和有限的情况下才推荐使用
                    System.out.println(EntityUtils.toString(entity));
                } else {
                    /**
                     * 某些情况下需要能够读取实体内容超过一次。
                     * 这种情况下的实体内容必须以某种方式缓存在内存或磁盘上。
                     * 解决办法 the BufferedHttpEntity类来包装源实体，这将使原实体的内容被读入到内存缓冲区
                     */
                    BufferedHttpEntity httpEntity = new BufferedHttpEntity(entity);

                    InputStream instream  = entity.getContent();
                    try {
                        int read = instream.read();
                    } finally {
                        // 确保低级别资源的释放
                        // 关闭内容流
                        instream.close();
                    }
                }
            }
        } finally {
            //关闭响应
            response.close();
        }
    }

    /**
     * 响应处理程序
     *
     * 处理响应使用ResponseHandler接口
     * handleResponse(HttpResponse response) 方法
     * 当使用ResponseHandler接口,无论是否请求执行成功或引发异常，Httpclient 都自动关闭来确保释放的连接返回到管理器
     */
    public void UrlEncodedForm(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://localhost/json");

        //ResponseHandler<MyJsonObject> rh = new ResponseHandler<MyJsonObject>() {
            /*@Override
            public JsonObject handleResponse(
                    final HttpResponse response) throws IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(
                            statusLine.getStatusCode(),
                            statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                Gson gson = new GsonBuilder().create();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                return gson.fromJson(reader, MyJsonObject.class);
            }
        };
        MyJsonObject myjson = client.execute(httpget, rh);*/
    }

}
