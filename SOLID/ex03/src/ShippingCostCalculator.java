import java.util.Arrays;
import java.util.List;

public class ShippingCostCalculator {
    private final List<IShipping> shipping = Arrays.asList(
        new StandardShipping(),
        new ExpressShipping(),
        new OvernightShipping()
    );

    public double cost(Shipment s) {
        return shipping.stream()
            .filter(sh -> sh.supports(s.type))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown type: " + s.type))
            .cost(s);
    }
}