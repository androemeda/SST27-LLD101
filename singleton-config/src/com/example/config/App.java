package com.example.config;

public class App {
    public static void main(String[] args) throws Exception {

        AppSettings settings = AppSettings.getInstance();
        System.out.println("app.name=" + settings.get("app.name"));
        System.out.println("instance=" + System.identityHashCode(settings));
        
        // Test
        System.out.println("same instance=" + System.identityHashCode(AppSettings.getInstance()));
    }
}
