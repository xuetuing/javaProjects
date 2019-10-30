package designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

//利用容器管理多种单利
public class SingletonManager {
    private static Map<String, Object> objectMap = new HashMap<>();
    private SingletonManager() {
    }

    public static void registerService(String key, Object objectInstance){
        if(!objectMap.containsKey(key)){
            objectMap.put(key, objectInstance);
        }
    }

    public static Object getService(String key){
        return objectMap.get(key);
    }
}
