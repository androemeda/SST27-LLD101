public class Demo02 {
    public static void main(String[] args) {
        Decoder decoder = new FrameDecoder();
        UIRenderer renderer = new ConsoleRenderer();
        Cache cache = new LastFrameCache();
        
        Player player = new Player(decoder, renderer, cache);
        player.play(new byte[]{1,2,3,4});
    }
}
