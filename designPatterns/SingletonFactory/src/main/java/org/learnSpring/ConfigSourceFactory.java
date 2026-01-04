package org.learnSpring;

public class ConfigSourceFactory {
    public ConfigSource createSource(String type, String filePath){
        if(type.equalsIgnoreCase("json"))
            return new JsonConfigSource();
        else if(type.equalsIgnoreCase("properties"))
            return new PropertiesConfigSource();
        else if(type.equalsIgnoreCase("yaml"))
            return new YamlConfigSource();
        else
            return null;
    }
    public static void main(String[] args) {
        ConfigSourceFactory configSourceFactory = new ConfigSourceFactory();

        ConfigSource configSource1 = configSourceFactory.createSource("json","path");
        ConfigurationManager configurationManager1 = ConfigurationManager.getInstance(configSource1);
        configurationManager1.loadFromSource(configSource1);

        ConfigSource configSource2 = configSourceFactory.createSource("yaml","path");
        ConfigurationManager configurationManager2 = ConfigurationManager.getInstance(configSource1);
        configurationManager2.loadFromSource(configSource2);

        ConfigSource configSource3 = configSourceFactory.createSource("properties","path");
        ConfigurationManager configurationManager3 = ConfigurationManager.getInstance(configSource1);
        configurationManager3.loadFromSource(configSource3);

    }
}