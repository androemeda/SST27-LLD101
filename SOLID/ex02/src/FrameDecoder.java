public class FrameDecoder extends Decoder {
    public Frame decode(byte[] fileBytes) {
        return new Frame(fileBytes);
    }
}