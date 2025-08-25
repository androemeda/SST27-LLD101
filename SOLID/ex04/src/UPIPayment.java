public class UPIPayment implements IPaymentMethod {

    @Override
    public boolean supports(String provider) {
        return "UPI".equals(provider);
    }

    @Override
    public String pay(Payment p) {
        return "Paid via UPI: " + p.amount;
    }
}