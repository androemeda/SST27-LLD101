package beverages_decorator;

public class CreamDecorator extends BeverageDecorator{
    public CreamDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 10;
    }
}
