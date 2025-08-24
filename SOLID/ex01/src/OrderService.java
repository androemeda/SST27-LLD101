public class OrderService {
    TaxCalculator tc;
    Notifier notifier;
    OrderRepo or;

    public OrderService(TaxCalculator tc , Notifier notifier , OrderRepo or){
        this.tc = tc;
        this.notifier = notifier;
        this.or = or;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = tc.calculate(subtotal);
        notifier.send(customerEmail, "Thanks! Your total is " + total);
        or.save();
    }
}

/*
The current OrderService class violates multiple SOLID principles:

  1. Single Responsibility Principle (SRP) - VIOLATED

  The OrderService class has multiple responsibilities:
  - Tax calculation (totalWithTax method)
  - Email notification (checkout method uses EmailClient)
  - Order persistence (simulated database storage)

  2. Open/Closed Principle (OCP) - VIOLATED

  - Tax rate is hardcoded (0.18), making it difficult to extend for different regions
  - Email logic is tightly coupled, can't easily change notification methods

  3. Dependency Inversion Principle (DIP) - VIOLATED

  - OrderService directly depends on concrete EmailClient class
  - No abstraction for notification or persistence mechanisms
 */