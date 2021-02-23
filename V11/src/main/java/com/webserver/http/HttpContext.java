package com.webserver.http;
import java.util.HashMap;
import java.util.Map;
/**
 * 定义一个静态的Map类，用来存放所有和HTTP协议相关的固定不变的内容
 */
public class HttpContext {
    /**
     * 资源后缀名与响应头Content-Type值的对应关系(键值对)
     * Key:资源后缀名
     * vaLue:Content-Type对应的值
     */
    private static Map<String,String> mimeMapping = new HashMap<>();

    /* 静态块 */
    static{
        initMimeMapping();
    }

    /* MimeMapping属性的方法 */
    private static void initMimeMapping(){
        mimeMapping.put("html","text/html");
        mimeMapping.put("css","text/css");
        mimeMapping.put("js","application/javascript");
        mimeMapping.put("png","image/png");
        mimeMapping.put("jpg","image/jpeg");
        mimeMapping.put("gif","image/gif");
    }

    /* 提供一个公开的VaLue获取方法，请求方提供Key,我们返回一个VaLue */
    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
}
