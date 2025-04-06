package com.bridgelabz.javareflections.intermediateproblems;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ABC123XYZ";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticFields {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration();
            Class<?> cls = cfg.getClass();
            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true);

            field.set(null, "NEW_KEY_456CDE");
            System.out.println(cfg.getApiKey());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
