package main.park.monster;


import main.park.attraction.Attraction;
import main.park.client.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Beast implements Comparable<Beast>{

    protected Attraction attraction;
    private String name;
    private BeastType beastType;
    private int age;
    private List<Client> kidnappedClients = new ArrayList<>();

    public Beast(String name, BeastType beastType, int age) {
        this.name = name;
        this.beastType = beastType;
        this.age = age;
    }
    public abstract void beastAct(Client client);

    public BeastType getBeastType() {
        return beastType;
    }
    protected void addKidnappedClient(Client client){
        this.kidnappedClients.add(client);
    }

    @Override
    public int compareTo(Beast o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public List<Client> getKidnappedClients() {
        return Collections.unmodifiableList(kidnappedClients);
    }
}
