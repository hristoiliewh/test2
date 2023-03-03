package main.park.monster;

import main.park.attraction.Attraction;

public abstract class WaterBeast extends Beast{

    private int maxDepth;

    public WaterBeast(String name, BeastType beastType, int age) {
        super(name, beastType, age);
    }
}
