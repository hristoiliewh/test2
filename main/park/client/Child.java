package main.park.client;

public class Child extends Client{


    public Child(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.CHILD);
    }

    @Override
    public void pay(double amount) {

        park.receiveMoney(amount * 0.5);
    }
}
