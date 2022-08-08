package org.games.snakeladder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
public class SnakeAndLadderGame {

    private Board board;
    private Dice dice;
    private Queue<Player> players;
    private List<Player> winners;

    public SnakeAndLadderGame(int boardSize, int numberOfSnakes, int numberOfLadders){
        //Initialize Board
        board = new Board(boardSize);
        board.addSnakeAndLadders(numberOfSnakes, numberOfLadders);
        //Initialize Dice
        dice = new Dice(1, 6 , 2);// Current Value hase no meaning though
        //Create Player Queue
        players = new LinkedList<>();
        //Create Winner List
        winners = new ArrayList<>();
    }

    public void addPlayer(String name){
        Player player = new Player(name);
        this.getPlayers().offer(player);
    }

    public void startGame(){

        while (!isGameCompleted()){

            Player player = players.poll();
            int diceRollValue = dice.rollDice();

            int playersNewPosition = player.getCurrentPosition() + diceRollValue;

            //If New position is outside board then players position will not be changed . No setCurrentPosition
            //Add it in the queue for next turn
            if(playersNewPosition > board.end){
                this.getPlayers().offer(player);
            }
            else{
                playersNewPosition = board.getNewPositionAfterGoingThroughSnakesAndLadders(playersNewPosition);
                player.setCurrentPosition(playersNewPosition);
                if(playersNewPosition == board.getEnd()){
                    player.setWon(true);
                    winners.add(player);
                    System.out.println(player.getName() + " Won the Game"); //No need to queue again as won
                }
                else{
                    System.out.println("Settings players "+player.getName()+ " "+ playersNewPosition);
                    this.getPlayers().offer(player); // Back in queue for next turn
                }
            }
        }
    }

    private boolean isGameCompleted() {
        //Game is completed if there is only one player left , basically the looser :)
        return this.getPlayers().size() < 2;
    }
}
