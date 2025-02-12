package org.onboard.collections.properties;

public class Main {
    public static void main(String[] args) {

        Config config = new Config();
        System.out.println(config.get("key1"));
        System.out.println(config.get("key2"));
        config.remove("key1");
        System.out.println(config.get("key1"));
        config.save();
        System.out.println(config.get("key1"));
        config.set("default.filenames", "default2");
        config.save();
        config.reset();
        System.out.println(config.get("key1"));
    }
}
