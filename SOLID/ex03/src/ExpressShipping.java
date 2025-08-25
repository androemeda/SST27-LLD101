public class ExpressShipping implements IShipping{
    @Override
    public boolean supports(String type) {
        return "EXPRESS".equals(type);
    }

    @Override
    public double cost(Shipment shipment) {
        return 80 + 8 * shipment.weightKg;
    }
}