package com.endava.Twitter.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReader {

    private static Properties properties = new Properties();

    static {
        InputStream is = EnvReader.class.getClassLoader().getResourceAsStream("env.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseuri(){
        return properties.getProperty("baseUri");
    }


    public static String getBasePath(){
        return properties.getProperty("basePath");
    }

    public static String getApiKey(){
        return properties.getProperty("apiKey");
    }

    public static String getApiSecret(){
        return properties.getProperty("apiSecret");
    }

    public static String getAccessToken(){
        return properties.getProperty("accessToken");
    }

    public static String getAccessSecret(){
        return properties.getProperty("accessSecret");
    }

    public static String getPublishUri(){
        return properties.getProperty("publishUri");
    }

    public static String getPublishPath(){
        return properties.getProperty("publishPath");
    }


}
