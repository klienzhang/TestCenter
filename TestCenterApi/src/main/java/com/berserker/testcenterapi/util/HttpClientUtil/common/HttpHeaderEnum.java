package com.berserker.testcenterapi.util.HttpClientUtil.common;

/**
 * Created by klien on 16/7/15.
 */
public enum HttpHeaderEnum {

    ACCEPT(1,"Accept"),
    ACCEPT_CHARSET(2,"Accept-Charset"),
    ACCEPT_ENCODING(3,"Accept-Encoding"),
    ACCEPT_LANGUAGE(4,"Accept-Language"),
    ACCEPT_RANGES(5,"Accept-Ranges"),
    AUTHORIZATION(6,"Authorization"),
    CACHE_CONTROL(7,"Cache-Control"),
    CONNECTION(8,"Connection"),
    COOKIE(9,"Cookie"),
    CONTENT_LENGTH(10,"Content-Length"),
    CONTENT_TYPE(11,"Content-Type"),
    DATE(12,"Date"),
    EXPECT(13,"Expect"),
    FROM(14,"From"),
    HOST(15,"Host"),
    IF_MATCH(16,"If-Match"),
    IF_MODIFIED_SINCE(17,"If-Modified-Since"),
    IF_NONE_MATCH(18,"If-None-Match"),
    IF_UNMODIFIED_SINCE(19,"If-Unmodified-Since"),
    IF_RANGE(20,"If-Range"),
    KEEP_ALIVE(21,"Keep-Alive"),
    MAX_FORWARDS(22,"Max-Forwards"),
    PRAGMA(23,"Pragma"),
    PROXY_AUTHORIZATION(24,"Proxy-Authorization"),
    RANGE(25,"Range"),
    REFERER(26,"Referer"),
    TE(27,"TE"),
    UPGRADE(28,"Upgrade"),
    USER_AGENT(29,"UserInfo-Agent"),
    VIA(30,"Via"),
    WARNING(31,"Warning");

    private int id;
    private String HeaderContent;

    private HttpHeaderEnum(int id, String headerContent) {
        this.id = id;
        HeaderContent = headerContent;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getHeaderContent() {
        return HeaderContent;
    }

//    public void setHeaderContent(String headerContent) {
//        HeaderContent = headerContent;
//    }
}
