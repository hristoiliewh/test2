package main;

import java.util.Random;

public class Util {

    public static int getRandomInt(int min, int max){
        return new Random().nextInt(min, max+1);
    }
}
