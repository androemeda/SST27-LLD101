public class EmailNotifier extends Notifier {
    
    public void send(String to , String msg){
        System.out.println("[EMAIL to=" + to + "] " + msg);
    }
}
