public class StandardShipping implements IShipping {

    @Override
    public boolean supports(String type) {
        return "STANDARD".equals(type);
    }

    @Override
    public double cost(Shipment shipment) {
        return 50 + 5 * shipment.weightKg;
    }
}