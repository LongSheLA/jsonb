package com.example.demo.utils;

import com.example.demo.entity.Monitor;
import com.example.demo.entity.Person;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*********************************************
 *
 * 此工具类专门用于postgrel sql jsonb数据格式
 * 查出的map与object、Array的互转
 *
 * @auth jiangdongdong
 * *******************************************
 */
public class JsonbUtils {


    /**
     * object 转 map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String,Object> objectToMap(Object obj) throws Exception{
        if(obj == null) return null;
        Map<String,Object> map = new HashMap<String,Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }
        return map;
    }





//    public static void main(String[] args){
//        try{
//            Monitor m = new Monitor();
//            m.setName("hhhhh");
//            Map<String, Object> stringObjectMap = objectToMap(m);
//            System.out.print(stringObjectMap.get("name"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

}
