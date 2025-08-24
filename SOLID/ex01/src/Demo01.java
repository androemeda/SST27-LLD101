

public class Demo01 {
    public static void main(String[] args) {
        OrderRepo or = new PretendOrderRepo();
        Notifier nf = new EmailNotifier();
        TaxCalculator tc = new TaxCalculator(0.18);

        OrderService os = new OrderService(tc, nf, or);
        os.checkout("a@gmail.com", 100);
    }
}
