package com.fk.game;

import java.util.LinkedList;
import java.util.List;

import com.fk.logic.GameLogic;
import com.fk.model.Player;

/**
 * Game class is central to the Bowling Game.
 * It can have a configurable GameLogic and a list of players to start with.
 * @author drm
 *
 */
public class Game {
  private final GameLogic logic;
  private final List<Player> players;
  private Player winner;
  
  public Game(GameLogic logic, int playerCount) {
    this.logic = logic;
    players = new LinkedList<Player>();
    this.addDefaultPlayers(playerCount);
  }
  
  public Game(GameLogic logic, List<Player> players) {
    this.logic = logic;
    this.players = players;
  }
  
  public void announceWinner() {
    Player winner = logic.findWinner(players);
    this.setWinner(winner);
    
    System.out.println("Player " + winner + " is the winner with score " + winner.getTotalScore());
  }
  
  public void start() {
    
  }
  
  public void addDefaultPlayers(int count) {
    for(int i = 0; i < count; i++) {
      Player p = new Player();
      players.add(p);
    }
  }
  
  public void addPlayers(List<Player> players) {
    if(!(players instanceof LinkedList)) {
      throw new IllegalArgumentException("Only a linked list of players is allowed");
    }
    
    this.players.addAll(players);
  }
  
  public void addPlayer(Player player) {
    players.add(player);
  }
  
  public void removePlayer(Player player) {
    players.remove(player);
  }
  
  public Player getWinner() {
    return winner;
  }
  
  public boolean setWinner(Player player) {
    boolean success = false;
    if(players.contains(player)) {
      this.winner = player;
      success = true;
    } else {
      throw new IllegalArgumentException("Player " + player + " is no longer part of the game");
    }
    
    return success;
  }

  public void announceScores() {
    for(Player player : players) {
      System.out.println(player + ":" + player.getScoreHistory() + "->" + player.getTotalScore());
    }
  }

  public GameLogic getLogic() {
    return logic;
  }

  public List<Player> getPlayers() {
    return players;
  }
  
  
}
