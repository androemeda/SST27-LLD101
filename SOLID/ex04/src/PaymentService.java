import java.util.Arrays;
import java.util.List;

public class PaymentService {

    private List<IPaymentMethod> providers = Arrays.asList(
        new UPIPayment(),
        new CardPayment(),
        new WalletPayment()
    );
    
    public String pay(Payment p){
        return providers.stream()
        .filter(pr -> pr.supports(p.provider))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No provider"))
        .pay(p);
    }
}