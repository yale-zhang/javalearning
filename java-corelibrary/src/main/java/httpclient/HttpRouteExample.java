package httpclient;

public class HttpRouteExample {

    /**
     * http 连接路由
     *
     * HttpClient能够直接或通过可能包含多个中间连接的路由-也称为跳转来建立到目标主机的连接。
     * HttpClient 将连接路由区分为平面路由,隧道路由和分层路由。
     * 使用多个中间代理来隧接到目标主机被称为代理链。
     *      平面路由通过连接到目标主机或仅一次的代理来建立。
     *      隧道路由通过代理链连接到首个隧道从而到达目标主机来建立。(不通过代理的路由不能成为隧道路由。)
     *      分层路由通过已有连接上面的分层协议来建立。( 只有在到达目标主机的隧道，或者不通过代理的直连之上，协议才能被分层。)
     *
     * 连接的持久性
     *  #打开的连接能够重用于执行多次请求，就可以实现更高的数据吞吐量。
     *
     *  HTTP/1.1协议规定每个缺省的HTTP连接都可以重用于多次请求。
     *  符合HTTP/1.0协议的端点同样可以通过一种机制明示它们的优先权来维持连接的可用性并将其用于多次请求。
     *
     *  HTTP代理还可以维持空闲连接存活一段时间，以防后续请求需要用到同一目标主机的连接。
     *  通常称维持连接存活的能力为连接持久性，HttpClient完全支持这种能力。
     *
     *  路由计算
     *  RouteInfo接口表示通过一个或多个中间步骤或跳转最终到达目标主机的的路由信息。
     *  Interface RouteInfo
     *       All Known Implementing Classes:HttpRouteExample, RouteTracker
     *       HttpTracker是RouteInfo接口的可变实现类，由HttpClient在内部使用于追踪到最终路由目标主机的剩余跳转数。
     *       HttpTracker类可以在成功执行跳转到下一个路由目标之后被更新。
     *
     *       HttpRouteDirector类是一个帮助类，可用于计算路由中的下一步， 这个类在HttpClient内部使用。
     *       HttpRoutePlanner是一个接口，表示基于执行上下文来计算到给定目标的完整路由的策略。
     *
     */
}
