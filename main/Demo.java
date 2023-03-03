package main;

import main.park.Park;
import main.park.attraction.Attraction;
import main.park.attraction.ExtremeAttraction;
import main.park.attraction.NormalAttraction;
import main.park.client.Adult;
import main.park.client.Child;
import main.park.client.Client;
import main.park.client.Pensioner;
import main.park.monster.*;

import java.util.Iterator;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Park park = new Park("Krasi`s Fantastic Beasts", "Sofia, Aleksi Rilets 38");
        Attraction.park = park;
        Client.park = park;

//        for (int i = 0; i < 3; i++) {
//            park.addAttraction(new ExtremeAttraction("Strashilishte",10,new Mermaid("Mermaid" + i,22,"blonde"),));
//        }
        for (int i = 0; i < 2; i++) {
            park.addAttraction(new ExtremeAttraction("Strahotiq",13,new Mermaid("Rusalka" + i,23,"blonde")));
            park.addAttraction(new ExtremeAttraction("Strashilishte",20,new Devil("Devil" + i, 22)));
            park.addAttraction(new ExtremeAttraction("Opasnost",22,new Dracon("Dracon" + i,12)));
        }
        for (int i = 0; i < 3; i++) {
            park.addAttraction(new NormalAttraction("Normalno",12,new Dwarf("Dwarf" + i,18)));
            park.addAttraction(new NormalAttraction("Normalen",16,new Grifon("Grifon" + i,24,12,"green")));
            park.addAttraction(new NormalAttraction("Normalna",16,new Kracken("Kracken " + i, 18, 16)));
        }
        for (int i = 0; i < 100; i++) {
            int chance = new Random().nextInt(3);
            Client client = switch (chance){
                case 0 -> new Child("Child" + i,Util.getRandomInt(12,18),new Random().nextBoolean() ? Client.Gender.MALE : Client.Gender.FEMALE);
                case 1 -> new Adult("Adult " + i,Util.getRandomInt(18,65),new Random().nextBoolean() ? Client.Gender.MALE : Client.Gender.FEMALE);
                default -> new Pensioner("Rentner " + i,Util.getRandomInt(66,86),new Random().nextBoolean() ? Client.Gender.MALE : Client.Gender.FEMALE);
            };
            park.addClient(client);
        }
        for (int i = 0; i < 2; i++) {
            park.distributeByAttraction();
        }
        park.printStats();
//        for (Client c : park.getClients()){
//            c.visitAttraction(park.getAttraction());
//        }
//        for (Iterator<Client> it = park.getClients().iterator();it.hasNext();){
//            Client c = it.next();
//            c.visitAttraction(park.getAttraction());
//            System.out.println("fggfgggg");
//        }
        //park.printStats();

        //TODO To implement Comparable by Sets and hashcode and equals by Hash...
    }
}
