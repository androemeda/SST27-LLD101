package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade facade = new VideoPipelineFacade();
        Path out = facade.process(Path.of("in.mp4"), Path.of("out.mp4"), 0.5, true, 0);
        System.out.println("Wrote " + out);
    }
}
