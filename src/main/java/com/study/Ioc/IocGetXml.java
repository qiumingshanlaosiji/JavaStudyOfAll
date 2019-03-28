package com.study.Ioc;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @description 自实现iocxml解析
 * @date 2018/12/26
 */
public class IocGetXml {

    public Object analysisXml() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.解析xml
        List<Element> elements = getXmlInfo("aaa.xml");
        //2.获取class地址
        String className = getBeanClass(elements, "person");
        //3.获取实例化信息
        return Class.forName(className).newInstance();
    }

    private String getBeanClass(List<Element> elements, String id) {

        for (Element element : elements) {
            //获取属性值
            String beanValue = element.attributeValue("id");
            if (StringUtils.isNotEmpty(beanValue)) {
                if (beanValue == id) {
                    return element.attributeValue("class");
                }
            } else {
                throw new RuntimeException("未找到这个节点");
            }

        }
        return null;
    }

    private List<Element> getXmlInfo(String xmlPath) {
        try {
            //字符串为空判断

            if (StringUtils.isEmpty(xmlPath)) {
                throw new Exception("路径为空");
            }
            SAXReader saxReader = new SAXReader();
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("aaaa.xml");
            Document document = saxReader.read(resourceAsStream);
            //获取所有的根节点
            Element element = document.getRootElement();
            return element.elements();
        } catch (Exception e) {
            return null;
        }
    }

}
