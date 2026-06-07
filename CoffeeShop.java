
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

abstract class Drink{
    protected String name;
    protected double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void order(PaymentStrategy payment, boolean addSugar, boolean addMilk){

        double finalPrice = price;
        if(addSugar) finalPrice += 10;
        if(addMilk) finalPrice += 20;
        payment.pay(finalPrice);
    }
}

// class Coffee extends Drink{
//     public Coffee() {
//         this.name = "Coffee";
//         this.price = 300;
//     }
// }

// class Tea extends Drink{
//     public Tea() {
//         this.name = "Tea";
//         this.price = 200;
//     }
// }

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

        PaymentStrategy payment = new CreditCardPayment();
        payment.pay(300);

        PaymentStrategy payment2 = new CashPayment();
        payment2.pay(200);
    }
}