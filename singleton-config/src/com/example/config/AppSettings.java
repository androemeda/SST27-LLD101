package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
      private final Properties props = new Properties();

      private static final AppSettings INSTANCE = new AppSettings();

      //Private constructor
      private AppSettings() {
        // Load the default config file during initialization
        String configFile = System.getProperty("config.file", "app.properties");
        loadFromFile(Path.of(configFile));
      }

      public static AppSettings getInstance() {
          return INSTANCE;
      }

      public String get(String key) {
          return props.getProperty(key);
      }

       private void loadFromFile(Path file) {
            try (InputStream in = Files.newInputStream(file)) {
                props.load(in);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
  }