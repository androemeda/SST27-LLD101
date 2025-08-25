public class ConsoleRenderer extends UIRenderer {
    public void render(int dataSize) {
        System.out.println("\u25B6 Playing " + dataSize + " bytes");
    }
}