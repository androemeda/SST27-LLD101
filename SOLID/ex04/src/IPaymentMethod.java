public interface IPaymentMethod {
    public boolean supports(String provider);
    public String pay(Payment p);
}