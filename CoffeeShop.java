
// Strategy pattern to implement the payment method for the coffee or tea
interface PaymentStrategy{
    public void pay(double amount);
}

class CashPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with credit card.");
    }
}


// template method for drink preperation

abstract class Drink{

    protected String name;
    protected double price;
    protected PaymentStrategy payment;

    public Drink(PaymentStrategy payment, String name, double price) {
        this.payment = payment;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void prepare(){
        System.out.println("Preparing " + name);
        boil();
        brew();
        pourInCup();
        addExtras();
        payment.pay(price);
    }

    private void boil(){
        System.out.println("Boiling water");
    }

    protected void brew(){
        System.out.println("Brewing Drink " + name);
    }

    private void pourInCup(){
        System.out.println("Pouring " + name + " into cup");
    }

    protected void addExtras(){
        System.out.println("Adding extras in a Drink " + name);
    }
}

class Coffee extends Drink{
    public Coffee(PaymentStrategy payment) {
        super(payment, "Coffee", 300);
    }

    @Override
    protected void brew(){
        System.out.println(" Brewing ground coffee...");
    }
}

class Tea extends Drink{
    public Tea(PaymentStrategy payment) {
        super(payment, "Tea", 200);
    }

    @Override
    protected void brew(){
        System.out.println(" Brewing ground tea...");
    }
}

// abstract class DrinkDecorator {
//     protected Drink drink;

//     public DrinkDecorator(Drink drink) {
//         this.drink = drink;
//     }
// }

// abstract class DrinkFactory{
//     public Drink order(PaymentStrategy payment, boolean addSugar, boolean addMilk){
        
//     }
// }

// class CoffeeFactory extends DrinkFactory{
// }

public class CoffeeShop {
    public static void main(String[] args) {
        // DrinkFactory coffeeFactory = new CoffeeFactory();

        // Drink order1 = coffeeFactory.order(new CashPayment(), true, false);
        // order1.prepare();

        // PaymentStrategy payment = new CreditCardPayment();
        // payment.pay(300);

        // PaymentStrategy payment2 = new CashPayment();
        // payment2.pay(200);
    }
}