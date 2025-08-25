public class LastFrameCache extends Cache {
    private Frame lastFrame;
    
    public void store(Frame frame) {
        this.lastFrame = frame;
        System.out.println("Cached last frame? " + (lastFrame != null));
    }
    
    public boolean hasFrame() {
        return lastFrame != null;
    }
}