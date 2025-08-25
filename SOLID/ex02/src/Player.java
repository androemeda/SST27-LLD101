public class Player {
    private Decoder decoder;
    private UIRenderer renderer;
    private Cache cache;
    
    public Player(Decoder decoder, UIRenderer renderer, Cache cache) {
        this.decoder = decoder;
        this.renderer = renderer;
        this.cache = cache;
    }
    
    void play(byte[] fileBytes) {
        Frame frame = decoder.decode(fileBytes);
        renderer.render(fileBytes.length);
        cache.store(frame);
    }
}