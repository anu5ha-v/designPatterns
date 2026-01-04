package org.learnSpring;

import java.util.HashMap;

public class YamlConfigSource implements ConfigSource{
    @Override
    public HashMap<String, String>  readConfig() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("config","yaml");
        String configType = "yaml";

        System.out.println("reading from Yaml Config Source");

        System.out.println("The config type is:"+ configType);

        return hashMap;
    }
}
