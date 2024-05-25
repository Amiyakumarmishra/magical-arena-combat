package com.swiggy.magical.arena.combat;

import java.util.ArrayDeque;
import java.util.Deque;

import com.swiggy.magical.arena.combat.model.Player;

public class MagicalArena {

	public static void playGame(Deque<Player> players) {

		while (players.peekFirst().isAlive() && players.peekLast().isAlive()) {
			Player attacker;
			Player defender;

			attacker = players.pollFirst();
			defender = players.peekFirst();
			players.addLast(attacker);

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

		Player winner = players.peekFirst().isAlive() ? players.peekFirst() : players.peekLast();
		System.out.println("\nGame Over!");
		System.out.println(winner.getPlayerName() + " wins!");
	}

	public static void main(String[] args) {
		Player playerA = new Player("A", 50, 5, 10);
		Player playerB = new Player("B", 100, 10, 5);

		Deque<Player> players = new ArrayDeque<>();
		if (playerA.getHealth() < playerB.getHealth()) {
			players.add(playerA);
			players.add(playerB);
		} else {
			players.add(playerB);
			players.add(playerA);
		}

		playGame(players);
	}

}
