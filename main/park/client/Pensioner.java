package main.park.client;

public class Pensioner extends Client{


    public Pensioner(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.PENSIONER);
    }

    @Override
    public void pay(double amount) {
        park.receiveMoney(amount * 0.2);
    }
}
