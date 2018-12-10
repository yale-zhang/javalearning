#### httpclient
* 1.1 执行请求   
   用户提供一个请求对象，httpclient发送该请求到目标服务器，服务器返回相应的响应对象,如果执行未成功则抛出一个异常。
      HttpClients  
* 1.1.1 http请求  
 HTTP请求的URI包含协议方案，主机名，可选的端口，资源路径，可选查询和可选片段。  
 **HttpClient 提供 URIBuilder 实用类来简化请求 URL的创建和修改.**
 * 1.1.2 http 响应
