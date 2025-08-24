public class TaxCalculator {
    double rate;

    public TaxCalculator(double rate){
        this.rate = rate;
    }

    double calculate(double subtotal){
        return subtotal*(1.0+rate);
    }
}
