

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
}

class Coffee extends Drink{
    public Coffee() {
        this.name = "Coffee";
        this.price = 200;
    }
}

class Tea extends Drink{
    public Tea() {
        this.name = "Tea";
        this.price = 150;
    }
}

abstract class DrinkFactory{
    public Drink order(PaymentStrategy payment, boolean addSugar, boolean addMilk){

    }
}