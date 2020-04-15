package pl.jakubtrzcinski.swapireporter.util;

import java.net.URL;

public class URLUtil {
    public static int getId(URL url){
        String[] parts = url.getPath().split("\\/");
        return Integer.parseInt(parts[parts.length-1]);
    }
    public static int getIntParam(URL url, String param){
        return Integer.parseInt(url.getQuery().replace(String.format("%s=", param), ""));
    }
}
