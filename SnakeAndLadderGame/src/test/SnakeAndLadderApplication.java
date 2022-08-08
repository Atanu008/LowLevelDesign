package test;

import org.games.snakeladder.Player;
import org.games.snakeladder.SnakeAndLadderGame;

import java.util.Scanner;

public class SnakeAndLadderApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board Size");
        int boardSize = scanner.nextInt();
        System.out.println("Enter number of players");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Enter number of snakes");
        int numberOfSnakes = scanner.nextInt();
        System.out.println("Enter number of ladders");
        int numberOfLadders = scanner.nextInt();

        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(boardSize, numberOfSnakes, numberOfLadders);

        for(int player = 0; player < numberOfPlayers; player++){
            System.out.println("Enter player name");
            String playerName = scanner.next();
            snakeAndLadderGame.addPlayer(playerName);
        }

        //Start the Game
        snakeAndLadderGame.startGame();

        System.out.println("Winners");
        for(Player player : snakeAndLadderGame.getWinners()){
            System.out.println(player.getName());
        }
    }
}
