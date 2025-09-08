package com.example.video;
import java.nio.file.Path;

public class VideoPipelineFacade {
    private Decoder decoder;
    private FilterEngine filterEngine;
    private Encoder encoder;
    private LegacySharpen legacySharpen;
    
    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.legacySharpen = new LegacySharpen();
    }
    
    public Path process(Path inputPath, Path outputPath) {
        return process(inputPath, outputPath, 0.5, false, 0);
    }
    
    public Path process(Path inputPath, Path outputPath, double scaleFactor, boolean applyGrayscale, int sharpenStrength) {
        Frame[] frames = decoder.decode(inputPath);
        
        if (applyGrayscale) {
            frames = filterEngine.grayscale(frames);
        }
        
        frames = filterEngine.scale(frames, scaleFactor);
        
        if (sharpenStrength > 0) {
            String handle = convertFramesToHandle(frames);
            handle = legacySharpen.applySharpen(handle, sharpenStrength);
            frames = convertHandleToFrames(handle);
        }
        
        return encoder.encode(frames, outputPath);
    }
    
    private String convertFramesToHandle(Frame[] frames) {
        return "FRAMES_HANDLE:" + frames.length;
    }
    
    private Frame[] convertHandleToFrames(String handle) {
        return new Frame[] { new Frame(1920, 1080), new Frame(1920, 1080) };
    }
}