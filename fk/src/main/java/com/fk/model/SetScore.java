package com.fk.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class SetScore {
  private Map<Integer, Integer> scores;//attempt, score
  private int set;

  public SetScore(int set) {
    this.scores = new LinkedHashMap<>();
    this.set = set;
  }

  public Map<Integer, Integer> getScores() {
    return scores;
  }

  public void setScores(Map<Integer, Integer> scores) {
    this.scores = scores;
  }

  public int getSet() {
    return set;
  }

  public void setSet(int set) {
    this.set = set;
  }


}
