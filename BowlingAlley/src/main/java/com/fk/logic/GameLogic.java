package com.fk.logic;

import java.util.List;

import com.fk.model.Player;

/**
 * Abstract GameLogic with some sensible defaults.
 * @author drm
 *
 */
public abstract class GameLogic {
  private final int sets;
  private final int attemptsPerSet;
  public final static int MAX_SCORE_PER_HIT = 10;
  
  public GameLogic(int sets, int attemptsPerSet) {
    this.sets = sets;
    this.attemptsPerSet = attemptsPerSet;
  }
  
  public abstract int calculateScore(Player player, String score, int set, int attempt);
  
  public abstract boolean getsMoreChance(Player player,int set, int scoreInt);

  public Player findWinner(List<Player> players) {
    Player winner = null;
    
    for(Player player : players) {
      if(winner == null) {
        winner = player;
      } else {
        if(player.getTotalScore() > winner.getTotalScore()) {
          winner = player;
        }
      }
    }
    
    return winner;
  }

  public int getSets() {
    return sets;
  }

  public int getAttemptsPerSet() {
    return attemptsPerSet;
  }

  
  
}
