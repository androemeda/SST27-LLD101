public interface IShipping {
    public boolean supports(String type);
    public double cost(Shipment shipment);
}