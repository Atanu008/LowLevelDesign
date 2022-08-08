package org.games.snakeladder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Dice {

    int minvalue;
    int maxValue;
    int currentValue;

    public int rollDice(){
        //The min parameter (the origin) is inclusive, whereas the upper bound max is exclusive
        //min = 8 max = 14
        //nextInt(15 - 8) --> nextInt(7) => Range [0, 6] + 8 == [8, 14]
        return new Random().nextInt((maxValue + 1) - minvalue ) + minvalue;
    }

}
