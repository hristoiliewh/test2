package main.park.client;

public class Adult extends Client{


    public Adult(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.ADULT);
    }

    @Override
    public void pay(double amount) {

        park.receiveMoney(amount);
    }
}
