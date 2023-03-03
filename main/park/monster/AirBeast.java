package main.park.monster;

import main.park.attraction.Attraction;

public abstract class AirBeast extends Beast{

    private int maxFlySpeed;

    public AirBeast(String name, BeastType beastType, int age) {
        super(name, beastType, age);
    }
}
