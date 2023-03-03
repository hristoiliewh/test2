package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

import java.util.Random;

import static main.park.client.Client.park;

public class Dracon extends AirBeast implements Kidnapper{

    private boolean guardTreasure = true;

    public Dracon(String name, int age) {
        super(name, BeastType.DRACON, age);
    }

    @Override
    public void beastAct(Client client) {
        System.out.println("The Dracon goves the client a gem.");
        int chance = new Random().nextInt(1, 10);
        if (chance <= 10){
            kidnapHim(client);
        }
    }

    @Override
    public void kidnapHim(Client client) {
        addKidnappedClient(client);
        park.kidnapClient(client);
        System.out.println("The beast kidnapped the client");

    }
}
