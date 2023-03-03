package main.park.monster;

import main.park.attraction.Attraction;
import main.park.client.Client;

import java.util.Random;

import static main.park.client.Client.park;

public class Mermaid extends WaterBeast implements Kidnapper{

    private String hairColor;

    public Mermaid(String name,int age, String hairColor) {
        super(name, BeastType.MERMAID, age);
        this.hairColor = hairColor;
    }


    @Override
    public void beastAct(Client client) {
        System.out.println("The mermaid sings a song.");
        int chance = new Random().nextInt(1, 10);
        if (chance < 1){
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
