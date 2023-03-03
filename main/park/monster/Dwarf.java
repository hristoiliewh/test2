package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

public class Dwarf extends EarthBeast implements NormalBeast{

    private final boolean makeJewelry = true;

    public Dwarf(String name, int age) {
        super(name, BeastType.DWARF, age);
    }

    @Override
    public void beastAct(Client client) {
        System.out.println("The dwarf forge a gem.");
        //TODO
    }
}
