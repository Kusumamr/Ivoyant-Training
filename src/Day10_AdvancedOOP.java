record Vehicle(int veh_num,String brand,String color){

}
record Animal(int age,String name,int weight,String color){

}
sealed abstract class PaymentMethod
    permits creditCard , UPI , Cash{

    abstract void pay(double amount);

}
final class creditCard extends PaymentMethod{
    void pay(double amount){
        System.out.println("Amount " + amount + " paid via card ");
    }
}
final class UPI extends PaymentMethod{
    void pay(double amount){
        System.out.println("Amount " + amount + "paid via UPI");
    }
}
final class Cash extends PaymentMethod{
    void pay(double amount){
        System.out.println("Amount " + amount + "paid via Cash");
    }
}

public class Day10_AdvancedOOP {
    public static void main(String[] args) {
        Vehicle car=new Vehicle(2343,"XUV","Black");
        Animal dog=new Animal(5,"Tom",42,"Brown");

        System.out.println(car);
        System.out.println(dog);

        PaymentMethod p;

        p=new creditCard();
        p.pay(22000);

        p=new UPI();
        p.pay(2989);

        p=new Cash();
        p.pay(500);
    }
}
