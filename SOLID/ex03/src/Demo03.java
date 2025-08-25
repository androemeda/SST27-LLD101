public class Demo03 {
    public static void main(String[] args) {
        ShippingCostCalculator calc = new ShippingCostCalculator();
        System.out.println(calc.cost(new Shipment("EXPRESS", 2.0)));
    }
}