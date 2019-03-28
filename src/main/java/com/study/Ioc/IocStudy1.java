package com.study.Ioc;

//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.support.odps.CodecCheck;
//import javafx.scene.layout.BorderImage;
//import netscape.javascript.JSObject;
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @description ioc学习
 * @date 2018/12/6
 */
public class IocStudy1 {

//    @Test
//    public void test() {
//
//        String jsonStr = "{\"MobileContext\":{\"Version\":\"6160\",\"DeviceId\":\"3cc635fc834f4c0b244851bf10d9eae0\",\"Source\":\"IPhone\",\"Extend\":\"\",\"SequenceId\":null,\"TimeStamp\":null,\"AppStoreId\":\"\",\"Idfa\":\"DD8B589E-AF98-4D01-93BD-1803A174668B\",\"IpAddress\":\"172.17.12.197\",\"Latitude\":31.229749232415141,\"Longitude\":121.3998264403784,\"PhoneIMSI\":null,\"PhoneMAC\":null,\"PromotionId\":\"\",\"PromotionUrl\":\"\",\"sessionId\":null},\"RequestParam\":{\"VipNo\":\"1800016039\"}}";
//        JSONObject jsonObject = new JSONObject();
//        JSONObject parseObject = jsonObject.parseObject(jsonStr);
//        JSONArray array = parseObject.getJSONArray("MobileContext");
//        for (Object obj : array) {
//            JSONObject jsonObject1 = (JSONObject) obj;
//            String device = jsonObject1.getString("DeviceId");
//        }
//    }
//
//    //xml解析
//    public void Test2() throws Exception {
//
//        SAXReader saxReader = new SAXReader();
//        Document read = saxReader.read(new File(""));
//        //节点属性
//        Element root = read.getRootElement();
//        List<Attribute> list = root.attributes();
//        for (Attribute attr : list) {
//            String name = attr.getName();
//            String value = attr.getText();
//        }
//    }

    //反射
    //三种方式
    public void Test3() throws Exception {

        Class<?> forName = Class.forName("com.study.Ioc.A");
        Object instance = forName.newInstance();
        A a = (A) instance;

    }
}

class A {

    public String a;

    public int b;

}
