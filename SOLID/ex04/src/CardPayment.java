public class CardPayment implements IPaymentMethod{

    @Override
    public boolean supports(String provider) {
       return "CARD".equals(provider);
    }

    @Override
    public String pay(Payment p) {
       return "Charged card: " + p.amount;
    }
    
}