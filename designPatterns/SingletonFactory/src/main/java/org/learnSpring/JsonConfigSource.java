package org.learnSpring;

import java.util.HashMap;

public class JsonConfigSource implements ConfigSource{
    @Override
    public HashMap<String, String> readConfig() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("config","json");
        String configType = "json";


        System.out.println("reading from Json Config Source");

        System.out.println("The config type is:"+ configType);

        return hashMap;
    }
}
