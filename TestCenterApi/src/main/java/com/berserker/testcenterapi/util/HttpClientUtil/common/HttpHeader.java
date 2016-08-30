package com.berserker.testcenterapi.util.HttpClientUtil.common;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klien on 16/7/15.
 */
public class HttpHeader {

    private Map<String, Header> headerMaps = new HashMap<String, Header>();

    private HttpHeader() {};

    public static HttpHeader custom(){
        return new HttpHeader();
    }

    /**
     * set Http header manually
     * @param key
     * @param value
     * @return
     */
    public HttpHeader setParameterManual(String key, String value) {
        headerMaps.put(key, new BasicHeader(key, value));
        return this;
    }

    /**
     * 指定客户端能够接收的内容类型
     * 例如：Accept: text/plain, text/html
     *
     * @param accept
     */
    public HttpHeader accept(String accept) {
        headerMaps.put(HttpHeaderEnum.ACCEPT.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.ACCEPT.getHeaderContent(), accept));
        return this;
    }

    /**
     * 浏览器可以接受的字符编码集
     * 例如：Accept-Charset: iso-8859-5
     *
     * @param acceptCharset
     */
    public HttpHeader acceptCharset(String acceptCharset) {
        headerMaps.put(HttpHeaderEnum.ACCEPT_CHARSET.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.ACCEPT_CHARSET.getHeaderContent(), acceptCharset));
        return this;
    }

    /**
     * 指定浏览器可以支持的web服务器返回内容压缩编码类型
     * 例如：Accept-Encoding: compress, gzip
     *
     * @param acceptEncoding
     */
    public HttpHeader acceptEncoding(String acceptEncoding) {
        headerMaps.put(HttpHeaderEnum.ACCEPT_ENCODING.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.ACCEPT_ENCODING.getHeaderContent(), acceptEncoding));
        return this;
    }

    /**
     * 浏览器可接受的语言
     * 例如：Accept-Language: en,zh
     *
     * @param acceptLanguage
     */
    public HttpHeader acceptLanguage(String acceptLanguage) {
        headerMaps.put(HttpHeaderEnum.ACCEPT_LANGUAGE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.ACCEPT_LANGUAGE.getHeaderContent(), acceptLanguage));
        return this;
    }

    /**
     * 可以请求网页实体的一个或者多个子范围字段
     * 例如：Accept-Ranges: bytes
     *
     * @param acceptRanges
     */
    public HttpHeader acceptRanges(String acceptRanges) {
        headerMaps.put(HttpHeaderEnum.ACCEPT_RANGES.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.ACCEPT_RANGES.getHeaderContent(), acceptRanges));
        return this;
    }

    /**
     * HTTP授权的授权证书
     * 例如：Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     *
     * @param authorization
     */
    public HttpHeader authorization(String authorization) {
        headerMaps.put(HttpHeaderEnum.AUTHORIZATION.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.AUTHORIZATION.getHeaderContent(), authorization));
        return this;
    }

    /**
     * 指定请求和响应遵循的缓存机制
     * 例如：Cache-Control: no-cache
     *
     * @param cacheControl
     */
    public HttpHeader cacheControl(String cacheControl) {
        headerMaps.put(HttpHeaderEnum.CACHE_CONTROL.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.CACHE_CONTROL.getHeaderContent(), cacheControl));
        return this;
    }

    /**
     * 表示是否需要持久连接（HTTP 1.1默认进行持久连接）
     * 例如：Connection: close 短链接； Connection: keep-alive 长连接
     *
     * @param connection
     * @return
     */
    public HttpHeader connection(String connection) {
        headerMaps.put(HttpHeaderEnum.CONNECTION.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.CONNECTION.getHeaderContent(), connection));
        return this;
    }

    /**
     * HTTP请求发送时，会把保存在该请求域名下的所有cookie值一起发送给web服务器
     * 例如：Cookie: $Version=1; Skin=new;
     *
     * @param cookie
     */
    public HttpHeader cookie(String cookie) {
        headerMaps.put(HttpHeaderEnum.COOKIE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.COOKIE.getHeaderContent(), cookie));
        return this;
    }

    /**
     * 请求内容长度
     * 例如：Content-Length: 348
     *
     * @param contentLength
     */
    public HttpHeader contentLength(String contentLength) {
        headerMaps.put(HttpHeaderEnum.CONTENT_LENGTH.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.CONTENT_LENGTH.getHeaderContent(), contentLength));
        return this;
    }

    /**
     * 请求的与实体对应的MIME信息
     * 例如：Content-Type: application/x-www-form-urlencoded
     *
     * @param contentType
     */
    public HttpHeader contentType(String contentType) {
        headerMaps.put(HttpHeaderEnum.CONTENT_TYPE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.CONTENT_TYPE.getHeaderContent(), contentType));
        return this;
    }

    /**
     * 请求发送的日期和时间
     * 例如：Date: Tue, 15 Nov 2010 08:12:31 GMT
     *
     * @param date
     * @return
     */
    public HttpHeader date(String date) {
        headerMaps.put(HttpHeaderEnum.DATE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.DATE.getHeaderContent(), date));
        return this;
    }

    /**
     * 请求的特定的服务器行为
     * 例如：Expect: 100-continue
     *
     * @param expect
     */
    public HttpHeader expect(String expect) {
        headerMaps.put(HttpHeaderEnum.EXPECT.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.EXPECT.getHeaderContent(), expect));
        return this;
    }

    /**
     * 发出请求的用户的Email
     * 例如：From: user@email.com
     *
     * @param from
     */
    public HttpHeader from(String from) {
        headerMaps.put(HttpHeaderEnum.FROM.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.FROM.getHeaderContent(), from));
        return this;
    }

    /**
     * 指定请求的服务器的域名和端口号
     * 例如：Host: blog.csdn.net
     *
     * @param host
     * @return
     */
    public HttpHeader host(String host) {
        headerMaps.put(HttpHeaderEnum.HOST.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.HOST.getHeaderContent(), host));
        return this;
    }

    /**
     * 只有请求内容与实体相匹配才有效
     * 例如：If-Match: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifMatch
     * @return
     */
    public HttpHeader ifMatch(String ifMatch) {
        headerMaps.put(HttpHeaderEnum.IF_MATCH.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.IF_MATCH.getHeaderContent(), ifMatch));
        return this;
    }

    /**
     * 如果请求的部分在指定时间之后被修改则请求成功，未被修改则返回304代码
     * 例如：If-Modified-Since: Sat, 29 Oct 2010 19:43:31 GMT
     *
     * @param ifModifiedSince
     * @return
     */
    public HttpHeader ifModifiedSince(String ifModifiedSince) {
        headerMaps.put(HttpHeaderEnum.IF_MODIFIED_SINCE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.IF_MODIFIED_SINCE.getHeaderContent(), ifModifiedSince));
        return this;
    }

    /**
     * 如果内容未改变返回304代码，参数为服务器先前发送的Etag，与服务器回应的Etag比较判断是否改变
     * 例如：If-None-Match: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifNoneMatch
     * @return
     */
    public HttpHeader ifNoneMatch(String ifNoneMatch) {
        headerMaps.put(HttpHeaderEnum.IF_NONE_MATCH.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.IF_NONE_MATCH.getHeaderContent(), ifNoneMatch));
        return this;
    }

    /**
     * 如果实体未改变，服务器发送客户端丢失的部分，否则发送整个实体。参数也为Etag
     * 例如：If-Range: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifRange
     * @return
     */
    public HttpHeader ifRange(String ifRange) {
        headerMaps.put(HttpHeaderEnum.IF_RANGE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.IF_RANGE.getHeaderContent(), ifRange));
        return this;
    }

    /**
     * 只在实体在指定时间之后未被修改才请求成功
     * 例如：If-Unmodified-Since: Sat, 29 Oct 2010 19:43:31 GMT
     *
     * @param ifUnmodifiedSince
     * @return
     */
    public HttpHeader ifUnmodifiedSince(String ifUnmodifiedSince) {
        headerMaps.put(HttpHeaderEnum.IF_UNMODIFIED_SINCE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.IF_UNMODIFIED_SINCE.getHeaderContent(), ifUnmodifiedSince));
        return this;
    }

    /**
     * 限制信息通过代理和网关传送的时间
     * 例如：Max-Forwards: 10
     *
     * @param maxForwards
     * @return
     */
    public HttpHeader maxForwards(String maxForwards) {
        headerMaps.put(HttpHeaderEnum.MAX_FORWARDS.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.MAX_FORWARDS.getHeaderContent(), maxForwards));
        return this;
    }

    /**
     * 用来包含实现特定的指令
     * 例如：Pragma: no-cache
     *
     * @param pragma
     * @return
     */
    public HttpHeader pragma(String pragma) {
        headerMaps.put(HttpHeaderEnum.PRAGMA.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.PRAGMA.getHeaderContent(), pragma));
        return this;
    }

    /**
     * 连接到代理的授权证书
     * 例如：Proxy-Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     *
     * @param proxyAuthorization
     */
    public HttpHeader proxyAuthorization(String proxyAuthorization) {
        headerMaps.put(HttpHeaderEnum.PROXY_AUTHORIZATION.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.PROXY_AUTHORIZATION.getHeaderContent(), proxyAuthorization));
        return this;
    }

    /**
     * 只请求实体的一部分，指定范围
     * 例如：Range: bytes=500-999
     *
     * @param range
     */
    public HttpHeader range(String range) {
        headerMaps.put(HttpHeaderEnum.RANGE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.RANGE.getHeaderContent(), range));
        return this;
    }

    /**
     * 先前网页的地址，当前请求网页紧随其后,即来路
     * 例如：Referer: http://www.zcmhi.com/archives/71.html
     *
     * @param referer
     */
    public HttpHeader referer(String referer) {
        headerMaps.put(HttpHeaderEnum.REFERER.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.REFERER.getHeaderContent(), referer));
        return this;
    }

    /**
     * 客户端愿意接受的传输编码，并通知服务器接受接受尾加头信息
     * 例如：TE: trailers,deflate;q=0.5
     *
     * @param te
     */
    public HttpHeader te(String te) {
        headerMaps.put(HttpHeaderEnum.TE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.TE.getHeaderContent(), te));
        return this;
    }

    /**
     * 向服务器指定某种传输协议以便服务器进行转换（如果支持）
     * 例如：Upgrade: HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11
     *
     * @param upgrade
     */
    public HttpHeader upgrade(String upgrade) {
        headerMaps.put(HttpHeaderEnum.UPGRADE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.UPGRADE.getHeaderContent(), upgrade));
        return this;
    }

    /**
     * UserInfo-Agent的内容包含发出请求的用户信息
     *
     * @param userAgent
     * @return
     */
    public HttpHeader userAgent(String userAgent) {
        headerMaps.put(HttpHeaderEnum.USER_AGENT.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.USER_AGENT.getHeaderContent(), userAgent));
        return this;
    }

    /**
     * 关于消息实体的警告信息
     * 例如：Warn: 199 Miscellaneous warning
     *
     * @param warning
     * @return
     */
    public HttpHeader warning(String warning) {
        headerMaps.put(HttpHeaderEnum.WARNING.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.WARNING.getHeaderContent(), warning));
        return this;
    }

    /**
     * 通知中间网关或代理服务器地址，通信协议
     * 例如：Via: 1.0 fred, 1.1 nowhere.com (Apache/1.1)
     *
     * @param via
     * @return
     */
    public HttpHeader via(String via) {
        headerMaps.put(HttpHeaderEnum.VIA.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.VIA.getHeaderContent(), via));
        return this;
    }

    /**
     * 设置此HTTP连接的持续时间（超时时间）
     * 例如：Keep-Alive: 300
     *
     * @param keepAlive
     * @return
     */
    public HttpHeader keepAlive(String keepAlive) {
        headerMaps.put(HttpHeaderEnum.KEEP_ALIVE.getHeaderContent(),
                new BasicHeader(HttpHeaderEnum.KEEP_ALIVE.getHeaderContent(), keepAlive));
        return this;
    }

    private String get(String headName) {
        if (headerMaps.containsKey(headName)) {
            return headerMaps.get(headName).getValue();
        }
        return "";
    }

    /**
     * 返回header头信息
     *
     * @return
     */
    public Header[] build() {
        Header[] headers = new Header[headerMaps.size()];
        int i = 0;
        for (Header header : headerMaps.values()) {
            headers[i] = header;
            i++;
        }
        return headers;
    }
}
