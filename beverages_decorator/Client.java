package beverages_decorator;

public class Client {

	public static void main(String[] args) {	
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee : "+coffee.cost());
		
		coffee = new ChocolateDecorator(coffee);
        System.out.println("Coffee with Chocolate : "+coffee.cost());

		coffee = new ChocolateDecorator(coffee);
        System.out.println("Coffee with double Chocolate : "+coffee.cost());

		coffee = new CreamDecorator(coffee);
        System.out.println("Coffee with double Chocolate and cream : "+coffee.cost());
	}
}