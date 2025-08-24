public class PretendOrderRepo extends OrderRepo{
    
    public void save(){
        System.out.println("Order stored (pretend DB).");
    }
}
