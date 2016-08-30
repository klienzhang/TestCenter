package com.berserker.testcenterapi.util.HttpClientUtil;

import com.berserker.testcenterapi.util.HttpClientUtil.common.HttpResult;
import com.berserker.testcenterapi.util.HttpClientUtil.HCB.HCB;
import com.berserker.testcenterapi.util.HttpClientUtil.common.HttpClientConfig;
import com.berserker.testcenterapi.util.HttpClientUtil.common.HttpMethodsEnum;
import com.berserker.testcenterapi.util.HttpClientUtil.exception.HttpClientException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author KlienZhang
 *
 */
public class HttpClientUtil {
    private static Logger logger = LogManager.getLogger(HttpClientUtil.class);
    private static String DEFAULT_INENC = "UTF-8";
    private static String DEFAULT_ONENC = "UTF-8";

    /**
     * 功能描述：使用HttpClient进行get请求，并获得结果
     * @param config
     * @return
     * @throws HttpClientException
     */
    public static HttpResult get(HttpClientConfig config){
        return send(config.setMethod(HttpMethodsEnum.GET));
    }

    /**
     * 功能描述：使用HttpClient进行get请求，并获得结果
     * @param url
     * @return
     * @throws HttpClientException
     */
    public static HttpResult get(String url){
        return send(HttpClientConfig.custom().setUrl(url).setMethod(HttpMethodsEnum.GET));
    }

    /**
     * 功能描述： 使用HttpClient进行get请求，并获得结果
     * @param url
     * @param context
     * @return
     */
    public static HttpResult get(String url, HttpContext context){
        return send(HttpClientConfig.custom().setUrl(url).setMethod(HttpMethodsEnum.GET).setHttpContext(context));
    }

    /**
     * 功能描述：使用HttpClient进行get请求，并获得结果
     * @param url
     * @param headers
     * @param context
     * @param encoding
     * @return
     * @throws HttpClientException
     */
    public static HttpResult get(String url, Header[] headers, HttpContext context, String encoding){
        return send(HttpClientConfig.custom().setUrl(url).
                setMethod(HttpMethodsEnum.GET).setHeader(headers).setHttpContext(context).setInenc(encoding));
    }

    /**
     * 功能描述：使用HttpClient进行post请求，并获得结果
     * @param config
     * @return
     * @throws HttpClientException
     */
    public static HttpResult post(HttpClientConfig config){
        return send(config.setMethod(HttpMethodsEnum.POST));
    }

    /**
     * 功能描述：使用HttpClient进行post请求，并获得结果
     * @param url
     * @param map
     * @return
     * @throws HttpClientException
     */
    public static HttpResult post(String url, Object map){
        return send(HttpClientConfig.custom().setUrl(url).setEntityContents(map).setMethod(HttpMethodsEnum.POST));
    }

    /**
     * 功能描述：使用HttpClient进行post请求，并获得结果
     * @param url
     * @param map
     * @param context
     * @return
     */
    public static HttpResult post(String url, Object map, HttpContext context){
        return send(HttpClientConfig.custom().setUrl(url).setEntityContents(map).setMethod(HttpMethodsEnum.POST)
        .setHttpContext(context));
    }

    /**
     * 功能描述：使用HttpClient进行post请求，并获得结果
     * @param url
     * @param headers
     * @param context
     * @param encoding
     * @param map
     * @return
     * @throws HttpClientException
     */
    public static HttpResult post(String url, Header[] headers, HttpContext context, String encoding, Object map){
        return send(HttpClientConfig.custom().setUrl(url).
                setMethod(HttpMethodsEnum.POST).setHeader(headers).setHttpContext(context).setInenc(encoding).setEntityContents(map));
    }

    /**
     * Do HttpClient Action Point
     * @param config
     * @return
     * @throws HttpClientException
     */
    private static HttpResult send(HttpClientConfig config){
        if(config.getInenc() == null || config.getInenc() == ""){
            config.setInenc(DEFAULT_INENC);
        }
        if(config.getOnenc() == null || config.getOnenc() == ""){
            config.setOnenc(DEFAULT_ONENC);
        }

        HttpResult result = new HttpResult();
        try{
            result = fmt2String(execute(config),config.getOnenc());
        }catch (Exception e){
            logger.error(e);
            result.setExecuteSuccessfully(false).setResult(e.getMessage()).setStatusCode(-1);
        }finally {
            //Try to close Httpclient link
            if(config.getHttpClient() != null){
                try {
                    config.getHttpClient().close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return result;
    }

    /**
     * Use this method to create a new Httpclient Object
     * @return
     * @throws HttpClientException
     */
    private static CloseableHttpClient createHttpClient() throws HttpClientException{
        CloseableHttpClient httpClient = HCB.custom().build();
        logger.debug("创建Httpclient对象");
        return httpClient;
    }

    private static HttpResponse execute(HttpClientConfig config) throws HttpClientException{
        if(config == null){
            throw new HttpClientException("HttpClientConfig Object is null");
        }
        //Recreate Httpclient object if it's null
        if(config.getHttpClient() == null){
            config.setHttpClient(createHttpClient());
        }

        HttpResponse response = null;
        try{
            HttpRequestBase base = getRequestBase(config.getUrl(), config.getMethod());
            base.setHeaders(config.getHeader());
            //Avoid gzip problem
            base.setHeader("Accept-Encoding", "identity");

            if(HttpEntityEnclosingRequestBase.class.isAssignableFrom(base.getClass())){
                //HttpPost
                HttpEntity entity = map2Entity(config.getEntityContents(), config.getInenc());

                ((HttpEntityEnclosingRequestBase)base).setEntity(entity);
            }else {
                //HttpGet
                //do nothing
            }

            response = (config.getHttpContext() == null)?config.getHttpClient().execute(base):
                    config.getHttpClient().execute(base,config.getHttpContext());

            return response;
        }catch (Exception e){
            throw new HttpClientException(e);
        }
    }

    /**
     * Get HttpEntity - Support Json Only presently
     * @param object
     * @param encoding
     * @return
     */
    private static HttpEntity map2Entity(Object object, String encoding) throws UnsupportedEncodingException {
        HttpEntity entity = null;

//        Object object = null
//                ;
//
//        if(object instanceof java.lang.String){
//
//        }else if (object instanceof Map){
//
//        }

        if(object instanceof String ){
            entity = new StringEntity(String.valueOf(object));
        }else if (object instanceof Map){
            //表单
            List<NameValuePair> param = new ArrayList<NameValuePair>();
            for(Map.Entry<String,String> entry : ((Map<String,String>) object).entrySet()){
                param.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
            entity = new UrlEncodedFormEntity(param, encoding);
        }else {
            //默认String型方法解析
            entity = new StringEntity(String.valueOf(object));
        }
//        if (map != null && map.size() > 0){
//            for(Map.Entry<String, String> entry : map.entrySet()){
//                entity = new StringEntity(String.valueOf(entry.getValue()), encoding);
//            }
//        }

        return entity;
    }

    /**
     * 将HttpEntity对象转化成String
     * @param response
     * @param encoding
     * @return
     * @throws HttpClientException
     */
    private static HttpResult fmt2String(HttpResponse response, String encoding) throws HttpClientException{

        HttpResult result = new HttpResult();
        try{
            result.setStatusCode(response.getStatusLine().getStatusCode());
            logger.debug("The length of Content is " + response.getEntity().getContentLength());
            result.setResult(EntityUtils.toString(response.getEntity(), encoding));
            logger.info("Content is " + result.getResult());
            result.setExecuteSuccessfully(true);

            EntityUtils.consume(response.getEntity());

        } catch (Exception e){
            throw new HttpClientException(e);
        }finally {
            closeResponse(response);
        }

        return result;
    }

    /**
     * 讲HttpEntity对象转化成OutputStream，比如在上传下载File时需要用到
     * @param response
     * @return
     * @throws HttpClientException
     */
    private static OutputStream fmt2Stream(HttpResponse response, OutputStream stream) throws HttpClientException{
        try{
            response.getEntity().writeTo(stream);
            EntityUtils.consume(response.getEntity());
        }catch (Exception e){
            throw new HttpClientException(e);
        }finally {
            closeResponse(response);
        }

        return stream;
    }

    /**
     * 创建HttpRequest对象
     * @param url
     * @param methodsEnum
     * @return
     */
    private static HttpRequestBase getRequestBase(String url, HttpMethodsEnum methodsEnum){
        HttpRequestBase base = null;
        switch (methodsEnum.getCode()){
            case 0:
                base = new HttpGet(url);
                logger.debug("Create HttpGet Successfully");
                break;
            case 1:
                base = new HttpPost(url);
                logger.debug("Create HttpPost Successfully");
                break;
            case 2:
                base = new HttpPut(url);
                logger.debug("Create HttpPut Successfully");
                break;
            case 3:
                base = new HttpDelete(url);
                logger.debug("Create HttpDelete Successfully");
                break;
            //Default method is HttpPost
            default:
                base = new HttpPost(url);
                logger.debug("Create HttpPost Successfully");
                break;
        }

        return base;
    }

    /**
     * 关闭并释放HttpResponse对象
     * @param response
     */
    private static void closeResponse(HttpResponse response){
        if(response == null){
            return;
        }
        try{
            if(CloseableHttpResponse.class.isAssignableFrom(response.getClass())) {
                ((CloseableHttpResponse) response).close();
            }
        }catch (Exception e){
            logger.error(e);
        }

    }

}
