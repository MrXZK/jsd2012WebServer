package com.webserver.http;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
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
    private static void initMimeMapping() {
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read("./config/web.xml");
            Element root = doc.getRootElement();
            List<Element> list = root.elements("mime-mapping");
            for (Element element : list) {
                String key = element.elementText("extension");
                String value = element.elementText("mime-type");
                mimeMapping.put(key, value);
            }
            System.out.println(mimeMapping.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 提供一个公开的VaLue获取方法，请求方提供Key,我们返回一个VaLue */
    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
        public static void main(String[] args) {
            String type = getMimeType("png");
            System.out.println(type);
        }
}
