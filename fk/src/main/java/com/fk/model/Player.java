package com.fk.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A player with a name and scores. If name is not provided default name will be taken.
 * 
 * @author drm
 *
 */
public class Player {
  private static final AtomicInteger counter = new AtomicInteger(0);
  private final int playerId;
  private final String playerName;
  private final Map<Integer, SetScore> scores;
  private int totalScore;
  private int finalSetAttempts;
  
  private final static String DEFAULT = "P";
  
  public Player() {
    this.playerId = counter.incrementAndGet();
    this.playerName = DEFAULT + playerId;
    this.scores = new LinkedHashMap<Integer, SetScore>();
  }
  
  public Player(String name) {
    this.playerId = counter.incrementAndGet();
    this.playerName = name;
    this.scores = new LinkedHashMap<Integer, SetScore>();
  }

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public int getPlayerId() {
    return playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public Map<Integer, SetScore> getScores() {
    return scores;
  }

  @Override
  public String toString() {
    return playerName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + playerId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Player other = (Player) obj;
    if (playerId != other.playerId)
      return false;
    return true;
  }

  public String getScoreHistory() {
    StringBuilder builder = new StringBuilder();
    for(SetScore score : scores.values()) {
      for(int scoreInt : score.getScores().values()) {
        builder.append(scoreInt).append(",");
      }
    }
    
    return builder.toString();
  }
  
  public void updateScore(int set, int scoreInt, int attempt) {
    this.setTotalScore(this.getTotalScore() + scoreInt);
    SetScore setScore = this.getScores().get(set);
    if(setScore == null) {
      setScore = new SetScore(set);
      this.getScores().put(set, setScore);
    }
    
    Map<Integer, Integer> scores = setScore.getScores();
    scores.put(attempt, scoreInt);
  }

  public int getFinalSetAttempts() {
    return finalSetAttempts;
  }

  public void setFinalSetAttempts(int finalSetAttempts) {
    this.finalSetAttempts = finalSetAttempts;
  }

  public int getScoreInThisSet(int set) {
    Map<Integer, SetScore> scores = this.getScores();
    SetScore setScore = scores.get(set);
    
    if(setScore == null) {
      setScore = new SetScore(set);
      scores.put(set, setScore);
    }
    
    Map<Integer, Integer> scores2 = setScore.getScores();

    int total = 0;
    for(int score : scores2.values()) {
      total += score;
    }
    
    return total;
  }

  
}
