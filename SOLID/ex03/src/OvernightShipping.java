public class OvernightShipping implements IShipping{
    @Override
    public boolean supports(String type) {
        return "OVERNIGHT".equals(type);
    }

    @Override
    public double cost(Shipment shipment) {
        return 120 + 10 * shipment.weightKg;
    }
}