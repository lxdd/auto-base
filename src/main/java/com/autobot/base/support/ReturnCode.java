package com.autobot.base.support;

/**   
* 共同返回-Code
* @author (li_xiaodong)
* @date 2015年10月13日 上午10:32:57
*/
public interface ReturnCode
{
    /**
     * 成功  返回码  "200"
     */
    String SUCCESS = "200";
    
    /**
    * 失败  返回码     "-1"
    */
    String FAILURE = "-1";
    
    /**
     * 必填参数不能为空  返回吗  "900"
     */
    String PARAM_NULL = "900";
    
    /**
     * 成功  返回码  "1", 专供房友
     * 
     */
    String FY_SUCCESS = "1";
    
    /**
    * 失败  返回码     "2", 专供房友
    */
    String FY_FAILURE = "2";
    
    /*******************************4×× 客户错误 begin *****************************************/
    /**
     *  Bad Request1、语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。2、请求参数有误。
     */
    String BAD_REQUEST = "400";
    
    /**
    * Unauthorized:当前请求需要用户验证。该响应必须包含一个适用于被请求资源的 WWW-Authenticate 信息头用以询问用户信息。
    * 客户端可以重复提交一个包含恰当的 Authorization 头信息的请求。如果当前请求已经包含了 Authorization 证书，那么401响应代表着服务器验证已经拒绝了那些证书。
    * 如果401响应包含了与前一个响应相同的身份验证询问，且浏览器已经至少尝试了一次验证，那么浏览器应当向用户展示响应中包含的实体信息，因为这个实体信息中可能包含了相关诊断信息。
    */
    String UNAUTHORIZED = "401";
    
    /**
     * Forbidden:服务器已经理解请求，但是拒绝执行它。与401响应不同的是，身份验证并不能提供任何帮助，而且这个请求也不应该被重复提交。
     * 如果这不是一个 HEAD 请求，而且服务器希望能够讲清楚为何请求不能被执行，那么就应该在实体内描述拒绝的原因。
     * 当然服务器也可以返回一个404响应，假如它不希望让客户端获得任何信息。
     */
    String FORBIDDEN = "403";
    
    /**
     *  Not Found:请求失败，请求所希望得到的资源未被在服务器上发现。没有信息能够告诉用户这个状况到底是暂时的还是永久的。
     *  假如服务器知道情况的话，应当使用410状态码来告知旧资源因为某些内部的配置机制问题，已经永久的不可用，而且没有任何可以跳转的地址。
     *  404这个状态码被广泛应用于当服务器不想揭示到底为何请求被拒绝或者没有其他适合的响应可用的情况下。出现这个错误的最有可能的原因是服务器端没有这个页面。
     */
    String FOUND = "404";
    
    /**
     * Request Timeout:请求超时。客户端没有在服务器预备等待的时间内完成一个请求的发送。客户端可以随时再次提交这一请求而无需进行任何更改。
     */
    String REQUEST_TIMEOUT = "408";
    
    /*******************************4×× 客户错误 end *****************************************/
    
    /*******************************5×× 服务器错误 begin *****************************************/
    /**
     * 程序执行错误  返回吗  "500"
     */
    String EXECUTE_ERROR = "500";
    
    /**
     * Internal Server Error:服务器遇到了一个未曾预料的状况，导致了它无法完成对请求的处理。一般来说，这个问题都会在服务器端的源代码出现错误时出现。
     */
    String INTERNAL_SERVER_ERROR = "500";
    
    /*******************************5×× 服务器错误end *****************************************/
    
    /**
     * 写入日志错误  返回码"5001" 
     */
    String WRITE_LOG_ERROR = "5001";
    
}
