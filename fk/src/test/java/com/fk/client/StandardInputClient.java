package com.fk.client;

import java.util.Scanner;

import com.fk.game.Game;
import com.fk.logic.DefaultGameLogic;
import com.fk.logic.GameLogic;
import com.fk.model.Player;

/**
 * A client which reads input from STDIN
 * @author drm
 *
 */
public class StandardInputClient implements Client {
  public static void main(String[] args) {
    StandardInputClient client = new StandardInputClient();
    client.process();
  }

  @Override
  public void process() {
    Scanner sc = new Scanner(System.in);
    try {
      this.process(sc);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }

  public void process(Scanner sc) {
    int playerCount = sc.nextInt();

    GameLogic logic = new DefaultGameLogic(2, 2);
    Game game = new Game(logic, playerCount);

    for (int set = 0; set < logic.getSets(); set++) {
      for (Player player : game.getPlayers()) {
        for (int attempt = 0; attempt < logic.getAttemptsPerSet(); attempt++) {
          String score = sc.next();
          try {
            int scoreInt = logic.calculateScore(player, score, set, attempt);

            player.updateScore(set, scoreInt, attempt);
            game.announceScores();

            if(logic.getsMoreChance(player, set, scoreInt)) {
              attempt--;
              player.setFinalSetAttempts(player.getFinalSetAttempts() + 1);
            }
            
            if (scoreInt >= GameLogic.MAX_SCORE_PER_HIT) {
              break;
            }
          } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Invalid argument. Try again");
            attempt--;
          }
        }
      }
    }

    game.announceWinner();
  }

}
