package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

import java.util.Random;

import static main.park.client.Client.park;

public class Devil extends EarthBeast implements Kidnapper{

    private final boolean makeWish = true;

    public Devil(String name, int age) {
        super(name, BeastType.DEVIL, age);
    }

    @Override
    public void beastAct(Client client) {
        System.out.println("The devil fulfils a desire.");
        int chance = new Random().nextInt(1, 10);
        if (chance <= 10){
            kidnapHim(client);
            park.increaseStolenSouls();
        }
    }

    @Override
    public void kidnapHim(Client client) {
        addKidnappedClient(client);
        park.kidnapClient(client);
        System.out.println("The beast kidnapped the client");

    }
}
