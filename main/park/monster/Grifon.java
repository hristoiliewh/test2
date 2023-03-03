package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

public class Grifon extends AirBeast implements NormalBeast{

    private int wingsLength;
    private String color;

    public Grifon(String name,int age, int wingsLength, String color) {
        super(name, BeastType.GRIFON, age);
        this.wingsLength = wingsLength;
        this.color = color;
    }

    @Override
    public void beastAct(Client client) {
        System.out.println("The Grifon lets the client ride him.");
        //TODO
    }
}
