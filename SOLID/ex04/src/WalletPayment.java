public class WalletPayment implements IPaymentMethod{

    @Override
    public boolean supports(String provider) {
        return "WALLET".equals(provider);
    }

    @Override
    public String pay(Payment p) {
       return "Wallet debit: " + p.amount;
    }
    
}