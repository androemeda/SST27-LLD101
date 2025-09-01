package com.example.config;

import java.nio.file.Path;

/** Wrapper that returns the singleton AppSettings instance. */
public class SettingsLoader {
    public AppSettings load(Path file) {
        return AppSettings.getInstance();
    }
}
