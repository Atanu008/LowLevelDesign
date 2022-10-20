package bowlingalley;

import bowlingalley.constants.AppConstants;
import bowlingalley.model.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BowlingGame {

    Queue<Player> players;
    Player winner;

    public BowlingGame(){
        players = new LinkedList<>();
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    public void startGame(){

        int maxScore = 0;
        while(!players.isEmpty()){

            Player player = players.poll();

            int standingPins = AppConstants.TOTAL_PINS;
            int roll = 2;

            while(roll --> 0){

                int numPinDown = takeShot(standingPins);
                player.getScoreBoard().roll(numPinDown);

                System.out.println("Rolling Score "+ numPinDown);
                standingPins -= numPinDown;

                // standingPins become 0 when we get a strike i.e. 10 on the first roll itself.
                // But we need to roll with 0 to increment the currentRoll value in scoreBoard.
                if(standingPins == 0){
                    player.getScoreBoard().roll(0);
                    break;
                }
            }

            //Bonus Roll :)
            if(player.getScoreBoard().isLastRound()){

                if(player.getScoreBoard().isEligibleForLastBonus()){
                    standingPins =  refillPin();
                    int numPinDown = takeShot(standingPins);
                    System.out.println("Taking Bonus with PinDown "+ numPinDown);
                    player.getScoreBoard().roll(numPinDown);
                }

                int finalScore = player.getScoreBoard().score();
                System.out.println("Final Score of " + player.getName() +" is "+ finalScore);
                if(finalScore > maxScore){
                    maxScore = finalScore;
                    winner = player;
                }
            }
            else{
                players.add(player);//Add it in Queue if not last Round
            }


        }
    }

    private int takeShot(int standingPins) {
        return new Random().nextInt(standingPins + 1);
        //return (int) (Math.random() * (standingPins + 1)); same
    }

    private int refillPin(){
        return AppConstants.TOTAL_PINS;
    }

    public String getWinner() {
        winner.setWon(true);
        return winner.toString();
    }
}
