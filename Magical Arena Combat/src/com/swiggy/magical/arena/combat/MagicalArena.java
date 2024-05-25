package com.swiggy.magical.arena.combat;

import java.util.ArrayDeque;
import java.util.Deque;

import com.swiggy.magical.arena.combat.model.Player;

public class MagicalArena {

    public static void playGame(Player player1, Player player2) {
        Deque<Player> players = new ArrayDeque<>();
        players.add(player1);
        players.add(player2);
        
        boolean firstTurn = true;
        while (player1.isAlive() && player2.isAlive()) {
            Player attacker;
            Player defender;

            if (firstTurn) {
                attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
                defender = (attacker == player1) ? player2 : player1;
                firstTurn = false;
            } else {
                attacker = players.pollFirst();
                defender = players.peekFirst();
                players.addLast(attacker);
            }

            System.out.println("Player " + attacker + " attacks");
            int attackDamage = attacker.attack();
            int defendDamage = defender.defend();
            int damageTaken = Math.max(0, attackDamage - defendDamage);
            defender.takeDamage(damageTaken);
            System.out.println("Attack damage: " + attackDamage);
            System.out.println("Defend damage: " + defendDamage);
            System.out.println("Damage taken by " + defender + ": " + damageTaken);
            System.out.println(defender + "'s health: " + defender.getHealth());
            System.out.println();
        }
    }


	public static void main(String[] args) {
		Player playerA = new Player("A",500, 5, 10);
		Player playerB = new Player("B",100, 10, 5);
		playGame(playerA, playerB);
	}

}
