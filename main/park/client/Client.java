package main.park.client;

import main.park.Park;
import main.park.attraction.Attraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Client implements Comparable<Client>{


    public enum Gender{
        MALE,FEMALE
    }

    public static Park park;
    private String name;
    private double expenses;
    private int age;
    private Gender gender;
    private ArrayList<Attraction> visitedAttractions = new ArrayList<>();
    private ClientType clientType;

    public Client(String name, int age, Gender gender, ClientType clientType) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clientType = clientType;
    }

    public abstract void pay(double amount);

    public ClientType getClientType() {
        return clientType;
    }

//    public void visitAttraction(Attraction attraction){ //TODO how to access the wanted from the Client attraction?
//        if(attraction.checkIfPossibleToVisit(this)) {
//            for (Attraction a : park.getAttractions()){
//                a.visit(this,attraction);
//            }
//            park.receiveMoney(pay(attraction.getPrice()));
//        //    this.visitedAttractions.add(attraction);
//        }else{
//            System.out.println("You cannot visit this attraction.");
//        }
//    }
//    public void visitAttraction(Attraction attraction){
//        if (attraction.checkIfPossibleToVisit(this)){
//
//        }
//    }

    @Override
    public int compareTo(Client o) {

        if(this.name.compareTo(o.name) == 0) {
            return this.age - o.age;
        }
        return this.name.compareTo(o.name);
    }

    public List<Attraction> getVisitedAttractions() {
        return Collections.unmodifiableList(visitedAttractions);
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
