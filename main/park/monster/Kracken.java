package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

public class Kracken extends WaterBeast implements NormalBeast{

    private int length;

    public Kracken(String name, int age, int length) {
        super(name, BeastType.KRACKEN, age);
        this.length = length;
    }

    @Override
    public void beastAct(Client client) {
        System.out.println("Gives a pearl to the client.");
        //TODO
    }
}
