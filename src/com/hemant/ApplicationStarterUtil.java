package com.axway.tnt.test;

import java.io.IOException;

public class ApplicationStarterUtil {
    public static void main(String args[])
    {
        ApplicationStarterUtil app = new ApplicationStarterUtil();
        Runtime runtime = Runtime.getRuntime();
        app.startSpecific(runtime,"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","https://javaconceptoftheday.com");

    }

    public void start(Runtime runtime,String application)
    {
        try {
            runtime.exec(application);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startSpecific(Runtime runtime,String application,String document)
    {
        String s[] = new String[]{ application,document};
        try {
            runtime.exec(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(Runtime runtime,String application)
    {
        try {
            runtime.exec(application).destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
