package com.rayworks.java;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Shirley on 9/15/15.
 */
public class UrlResolver {
    public static void main(String[] args) {
        try {
            String spec =
                    //"http://username:password@host:8080/directory/file?query#ref";
                    "https://www.baidu.com";

            URL url = new URL(spec);
            System.out.println(String.format("protocol %s, host: %s"
                    ,url.getProtocol(), url.getHost()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
