package org.games.snakeladder;

import lombok.Getter;

import java.util.*;

@Getter
public class Board {

    int size;
    int start;
    int end;
    List<Snake> snakes;
    List<Ladder> ladders;

    public Board(int size){
        // Suppose Board size is 100 . start and end is be [1-100]
        start = 1;
        end = start + size - 1;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public void addSnakeAndLadders(int numberOfSnakes, int numberOfLadders){

        Set<String> occupiedPositions = new HashSet<>();

        for(int i = 0; i < numberOfSnakes; i++){

            while(true){
                int head = new Random().nextInt((end+1) - start) + start;
                int tail = new Random().nextInt((end+1) - start) + start;
                //We dont want upside down snake :)
                if(tail >= head){
                    continue;
                }

                String headTailPair = head + "-" + tail;
                String tailHeadPair = tail + "-" + head;
                //Add Snake if there is No entry for Snake present already
                if(!occupiedPositions.contains(headTailPair) && !occupiedPositions.contains(tailHeadPair)){
                    Snake snake = new Snake(head, tail);
                    this.getSnakes().add(snake);
                    occupiedPositions.add(headTailPair);
                    occupiedPositions.add(tailHeadPair);
                    break; // Out for while loop . To choose another Snake
                }
            }
        }

        for(int i = 0; i < numberOfLadders; i++){

            while(true){
                int startLadder = new Random().nextInt((end+1) - start) + start;
                int endLadder = new Random().nextInt((end+1) - start) + start;

                if(startLadder >= endLadder){
                    continue;
                }

                String headTailPair = startLadder + "-" + endLadder;
                String tailHeadPair = endLadder + "-" + startLadder;
                //Add ladder if there is No entry for Ladder and Snake present already
                if(!occupiedPositions.contains(headTailPair) && !occupiedPositions.contains(tailHeadPair)){
                    Ladder ladder = new Ladder(startLadder, endLadder);
                    this.getLadders().add(ladder);
                    occupiedPositions.add(headTailPair);
                    occupiedPositions.add(tailHeadPair);
                    break; // Out for while loop . To choose another Snake
                }
            }
        }
    }

    public int getNewPositionAfterGoingThroughSnakesAndLadders(int currentPosition){

        for(Snake snake : this.getSnakes()){
            if(snake.getHead() == currentPosition){
                System.out.println("Snake Bites At "+snake.getHead());
                return snake.getTail();
            }
        }

        for(Ladder ladder : this.getLadders()){
            if(ladder.getStart() == currentPosition){
                System.out.println("Climbed Ladder At "+ladder.getStart());
                return ladder.getEnd();
            }
        }

        // If we don't get any snake/ladder, that means we can stay on the currentPosition
        return currentPosition;
    }
}
