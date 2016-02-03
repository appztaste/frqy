package com.fk.logic;

import com.fk.model.Player;

/**
 * Default game logic as per the case study requirement
 * @author drm
 *
 */
public class DefaultGameLogic extends GameLogic {

  public DefaultGameLogic(int sets, int attemptsPerSet) {
    super(sets, attemptsPerSet);
  }

  @Override
  public int calculateScore(Player player, String score, int set, int attempt) {
    int scoreInt = 0;
    int scoreInThisSet = player.getScoreInThisSet(set);
    
    if(score == null || score.isEmpty()) {
      throw new IllegalArgumentException("Invalid score " + score);
    }
    
    if(score.equals("/")) {
      if(scoreInThisSet <= 0) {
        throw new IllegalArgumentException("Spare input is valid only on second attempt");
      }
      
      scoreInt = 15 - scoreInThisSet;//FIXME
    } else if(score.equals("X")) {
      scoreInt = 20;
    } else {
      try {
        scoreInt = Integer.parseInt(score);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid score " + score, e);
      }
      
      if(scoreInt > 9) {
        throw new IllegalArgumentException("Invalid score " + score);
      }
    }
    
    return scoreInt;
  }

  public boolean getsMoreChance(Player player, int set, int score) {
    boolean result = false;
    
    int scoreInThisSet = player.getScoreInThisSet(set);
    if (set == this.getSets() - 1) {// final set
      if (score == 20 && player.getFinalSetAttempts() < 2) {// X
        result = true;
      } else if (player.getFinalSetAttempts() < 2 && scoreInThisSet == 15) {// spare
        result = true;
      }
    }
    
    return result;
  }
  
}
