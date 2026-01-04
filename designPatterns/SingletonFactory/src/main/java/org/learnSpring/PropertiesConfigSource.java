package org.learnSpring;

import java.util.HashMap;

public class PropertiesConfigSource implements ConfigSource{
    @Override
    public HashMap<String, String> readConfig() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("config","yaml");
        String configType = "properties";

        System.out.println("reading from Properties Config Source");

        System.out.println("The config type is:"+ configType);

        return hashMap;
    }
}
