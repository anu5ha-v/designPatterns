package org.learnSpring;

import java.util.HashMap;

public class ConfigurationManager {
    ConfigSourceFactory configSourceFactory = new ConfigSourceFactory();
    HashMap<String, String> configuration = new HashMap<>();
    public static volatile ConfigurationManager instance;
    private ConfigurationManager(ConfigSource configSource){
//        if(type.equalsIgnoreCase("yaml")) {
            this.setConfig("type","random");
            this.setConfig("set","data1");
            this.getConfig("type");
            this.loadFromSource(configSource);
//            instance.loadFromSource(configSourceFactory.createSource("yaml","path"));
//        }
//        else if(type.equalsIgnoreCase("json")){
//            instance.setConfig("type","json");
//            instance.setConfig("set","data2");
//            instance.getConfig("type");
//            instance.loadFromSource(configSourceFactory.createSource("json","path"));
//        }
//        else if(type.equalsIgnoreCase("properties")){
//            instance.setConfig("type","properties");
//            instance.setConfig("set","data3");
//            instance.getConfig("type");
//            instance.loadFromSource(configSourceFactory.createSource("properties","path"));
//        }
    }

    public static ConfigurationManager getInstance(ConfigSource configSource) {
        if(instance == null){
            synchronized (ConfigurationManager.class){
                if(instance == null)
                    instance = new ConfigurationManager(configSource);
            }
        }
        return instance;
    }

    public String getConfig(String key){
        configuration.get(key);
        System.out.println(configuration.get(key));
        return key;
    }

    public void setConfig(String key, String value){
        configuration.put(key, value);
    }

    public void loadFromSource(ConfigSource source){
        source.readConfig();
    }
}
